
public class Compiler {

    public static void main(String[] args) throws IOException {
        //создаем переменную file в которой хранится исходная программа 
        FileInputStream file = new FileInputStream("Program.txt");
        Controller(file);

    }
}

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Lexer {

    public Lexer() throws IOException {
        String line;
        int hCode;
        String Type = null;
        //номер строки изначально равен 1
        int linenum = 1;

        //служебные слова
        String[] keywords = {
            "program", "var", "begin",
            "end", ":=", "for", "to", "arrray", "of",
            "do", "if", "then", "else",
            "repeat", "until", "writeln", ";",
            "and", "or", "not", "while", "integer", ":" , "inc" };

        //создаем файлы для записи лексем, идентификаторов и местоположения каждой лексемы
        PrintWriter writer = new PrintWriter("Table_lexeme.txt", "UTF-8");
        PrintWriter writer1 = new PrintWriter("Table_id.txt", "UTF-8");
        PrintWriter writer2 = new PrintWriter("Table_place.txt", "UTF-8");
        //записать в файлы
        writer.println("lexeme---------------type ");
        writer1.println("id----------type----------hash ");
        writer2.println("lexeme----------string");
        //считываем исходную программу построчно
        BufferedReader br = new BufferedReader(new InputStreamReader(file));
        Pattern pattern = Pattern.compile("\\s*(\\s|,|\n|\\.)\\s*");
        //пока файл не закончился
        while ((line = br.readLine()) != null) {
            //делим строки на лексемы
            String[] words = pattern.split(line);
            //перебираем слова
            for (String word : words) {
                //если слово состоит из цифр, то это число
                if (word.matches("(^|\\s)\\d+(\\s|$)") || word.matches("(^|\\s)[$a$b$c$d$e$f$1$2$3$4$5$6$7$8$9]+(\\s|$)")) {
                    hCode = word.hashCode();
                    Type = "digit";
                    writer.println(word + "     Number");
                    writer1.println(word + "   " + Type + "   " + hCode);
                    writer2.println(word + "     " + linenum);
                    //если слово соответствует какому либо слову из массива reserved то это слово служебное
                } else if (Arrays.stream(keywords).anyMatch(word::equals)) {
                    hCode = word.hashCode();
                    Type = "keyword";
                    writer.println(word + "     Keyword");
                    writer1.println(word + "   " + Type + "   " + hCode);
                    writer2.println(word + "     " + linenum);
                    //если найденное слово символ
                } else if (word.matches("(^|\\s)[(),]+(\\s|$)")) {
                    hCode = word.hashCode();
                    Type = "separator";
                    writer.println(word + "     Separator");
                    writer1.println(word + "   " + Type + "   " + hCode);
                    writer2.println(word + "     " + linenum);
                    //если знаки арифметические
                } else if (word.matches("(^|\\s)[:=*/+-><]+(\\s|$)")) {
                    hCode = word.hashCode();
                    Type = "arithmetic signs";
                    writer.println(word + "     Arithmetic sign");
                    writer1.println(word + "   " + Type + "   " + hCode);
                    writer2.println(word + "     " + linenum);
                } //если найденное слово состоит из букв и цифр, то это переменная
                else if (word.matches("(^|\\s)[a-zA-Z0-9]+(\\s|$)")) {
                    hCode = word.hashCode();
                    Type = "variable";
                    writer.println(word + "     Identifier");
                    writer1.println(word + "   " + Type + "   " + hCode);
                    writer2.println(word + "     " + linenum);
                }
            }
                linenum++;
        }
        //закрыть запись в файлы
        writer.close();
        writer1.close();
        writer2.close();
   
   
    }
}

public class Parser {
      Parser() {
    //грамматика
   //ArrayList G = ({program, begin, end,:=, if, then, repeat, until, id,  do, =, <, >, +, -, (, ), ;, :, ε ,  var, byte integer, for, writeln, ., ..}, {S, Id, Block, Decl, Type, Stat,  Sect, List, Text, Expr, Sign, Term , Perem, ListTerm, ExprList, Oper}, R, S);
    ArrayList rules ;
//построение множества крайне левых и крайне правых символов для нетерминальных символов
//построение множества крайне левых и крайне правых символов для терминальных символов
//построение матрицы предшествования
//реализация алгоритма сдвиг-свертка
//построение дерева синтаксического разбора
String syntaxtree;

Optimizer opt=new Optimizer(syntaxtree);
    }
}


public class Optimizer {

    Optimizer() throws IOException {
        //реализация алгоритма построения оптимизированных триад
        String triads = null;
        Generator gen=new Generator(triads);
    }
    
}

public class Generator {

    Generator()) throws IOException {
        //перевод триад в код на ассемблер
        BufferedWriter bw = new BufferedWriter(new FileWriter("Result.txt"));
    }
    
}
import java.io.File;


public class Controller {
    Controller(File file) {
    Lexer lex=new Lexer();
    Parser pars=new Parser();
    Optimizer opt=new Optimizer();
    Generator gen=new Generator();
    
}
}
