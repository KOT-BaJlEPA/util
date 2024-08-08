package revers.myDomain;

import revers.myDomain.argsManipulation.DirectoriesAndFiles;
import revers.myDomain.argsManipulation.ParserArgs;
import revers.myDomain.argsManipulation.RawAllArgsSubject;

public class Main {
    public static void main(String[] args) {

      String path = "C:\\Users\\regul\\IdeaProjects\\util\\src\\main" +
              "\\java\\revers\\myDomain\\test.txt";

      String[] arPath = new String[]{path};


      Application app = new Application(arPath);
      app.run();




//        //отвечает за работу с сырыми аргументами, принимает их и отправляет их наблюдателям
//        RawAllArgsSubject rawArgSubject = new RawAllArgsSubject();
//
//        //отвечает за работу с аргументами, обрабатывает сырые аргументы,
//        // и все, что касается файлов и директорий отправляет своим наблюдателям
//        ParserArgs arg = new ParserArgs();
//
//        //отвечает за работу с файлами и директориями
//        DirectoriesAndFiles directoriesAndFiles = new DirectoriesAndFiles();
//
//        //добавляем наблюдателей
//        rawArgSubject.registerObserver(arg);
//        arg.registerObserver(directoriesAndFiles);
//
//        // ввод/применение аргументов
//        rawArgSubject.setNewArgs(args);










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