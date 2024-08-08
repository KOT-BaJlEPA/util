package revers.myDomain.argsManipulation;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

//Класс отвечающий за авсе манипуляции с директориями и файлами
public class DirectoriesAndFiles implements Observer {
    private  String dirForResult;
    private  String prefixFile;
    private  String nameFileForInteger;
    private  String nameFileForFloats;
    private  String nameFileForString;
    private  List<String> listInputFiles = new ArrayList<String>();

    public DirectoriesAndFiles() {
        this.dirForResult = new File("").getAbsolutePath();
        this.prefixFile = "";
        this.nameFileForInteger = "integers.txt";
        this.nameFileForFloats = "floats.txt";
        this.nameFileForString = "strings.txt";
    }

    public  String getDirForResult() {
        return this.dirForResult;
    }

    public  String getNameFileForInteger() {
        nameFileForInteger = prefixFile + nameFileForInteger;
        return nameFileForInteger.trim();
    }

    public  String getNameFileForFloats() {
        nameFileForFloats = prefixFile + nameFileForFloats;
        return nameFileForFloats.trim();
    }

    public  String getNameFileForString() {
        nameFileForString = prefixFile + nameFileForString;
        return nameFileForString.trim();
    }


    public  List<String> getListInputFiles() {
        return listInputFiles;
    }



    @Override
    public void update(String dirForResult, String prefixFile, List<String> listInputFiles) {
        this.dirForResult = Path.of(this.dirForResult, dirForResult).toString();
        this.prefixFile = prefixFile;
        this.listInputFiles = listInputFiles;
    }



    @Override
    public String toString() {
        return "DirectoryInputOutputFile{" +
                "dirForResult='" + dirForResult + '\'' +
                ", prefixFile='" + prefixFile + '\'' +
                ", nameFileForInteger='" + nameFileForInteger + '\'' +
                ", nameFileForFloats='" + nameFileForFloats + '\'' +
                ", nameFileForString='" + nameFileForString + '\'' +
                ", listInputFiles=" + listInputFiles +
                '}';
    }

    //plug
    @Override
    public void update(List<String> listArgs) {

    }
}
