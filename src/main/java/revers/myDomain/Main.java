package revers.myDomain;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String currentDir = new File("").getAbsolutePath();

        String ssr = "yl89.fk.txt";

        Pattern pattern = Pattern.compile(".*.txt$");
        System.out.println(pattern.matcher(ssr).matches());




//        integers.txt, floats.txt, strings.txt
//        Дополнительно с помощью опции -o нужно уметь задавать путь для результатов.
//        Опция -p задает префикс имен выходных файлов.

//        По умолчанию файлы результатов перезаписываются. С помощью опции -a можно задать
//        режим добавления в существующие файлы.

//        краткая и полная. Выбор статистики  производится опциями -s и -f соответственно.

//        Краткая статистика содержит только
//        количество элементов записанных в исходящие файлы. Полная статистика для чисел
//        дополнительно содержит минимальное и максимальное значения, сумма и среднее.
//        Полная статистика для строк, помимо их количества, содержит также размер самой
//        короткой строки и самой длинной.
    }
}