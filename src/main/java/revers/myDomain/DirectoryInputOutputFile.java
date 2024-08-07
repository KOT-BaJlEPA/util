package revers.myDomain;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

//Класс отвечающий за авсе манипуляции с директориями и файлами
public class DirectoryInputOutputFile {
    private static String dirForResult = new File("").getAbsolutePath();
    private static String prefixFile = "";
    private static String nameFileForInteger = "integers.txt";
    private static String nameFileForFloats = "floats.txt";
    private static String nameFileForString = "strings.txt";
    private static List<String> listInputFiles = new ArrayList<String>();

    public static String getDirForResult() {
        return dirForResult;
    }

    public static void setDirForResult(String dirForResult) {
        DirectoryInputOutputFile.dirForResult = Path.of(DirectoryInputOutputFile.dirForResult, dirForResult).toString();
        System.out.println("the directory has been set : " + DirectoryInputOutputFile.dirForResult);
    }

    public static void setPrefixFile(String prefixForFile) {
        DirectoryInputOutputFile.prefixFile = prefixForFile;
        System.out.println("the prefix has been set : " + DirectoryInputOutputFile.prefixFile);
    }

    public static String getNameFileForInteger() {
        nameFileForInteger = prefixFile + nameFileForInteger;
        return nameFileForInteger.trim();
    }

    public static String getNameFileForFloats() {
        nameFileForFloats = prefixFile + nameFileForFloats;
        return nameFileForFloats.trim();
    }

    public static String getNameFileForString() {
        nameFileForString = prefixFile + nameFileForString;
        return nameFileForString.trim();
    }


    public static List<String> getListInputFiles() {
        return listInputFiles;
    }

    public static void addNewInputFile(String nameFileInput) {
        listInputFiles.add(nameFileInput);
    }
}
