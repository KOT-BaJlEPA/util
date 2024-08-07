package revers.myDomain;

public class Main {
    public static void main(String[] args) {

        //отвечает за работу с сырыми аргументами, принимает их и отправляет их наблюдателям
        RawArgSubject rawArgSubject = new RawArgSubject();

        //отвечает за работу с аргументами, обрабатывает сырые аргументы, и все, что касается файлов и путей отправляет наблюдателям
        Arg arg = new Arg();

        //отвечает за работу с файлами и путями
        DirectoriesAndFiles directoriesAndFiles = new DirectoriesAndFiles();

        //добавляем наблюдателей
        rawArgSubject.registerObserver(arg);
        arg.registerObserver(directoriesAndFiles);

        //добавляем аргументы
        rawArgSubject.setNewArgs(args);

        System.out.println(arg);
        System.out.println("\n\n\n");
        System.out.println(directoriesAndFiles);




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