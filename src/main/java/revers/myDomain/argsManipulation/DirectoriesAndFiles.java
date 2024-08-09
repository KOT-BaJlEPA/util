package revers.myDomain.argsManipulation;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

//Класс отвечающий за манипуляции с директориями и файлами
public class DirectoriesAndFiles implements Observer {
    private  String dirForResult;
    private  String prefixFile;
    private  String fileNameForInteger = "integers.txt";
    private  String fileNameForFloats = "floats.txt";
    private  String fileNameForString = "strings.txt";
    private  List<String> listInputFiles = new ArrayList<String>();

    public DirectoriesAndFiles() {
        this.dirForResult = new File("").getAbsolutePath();
        this.prefixFile = "";
    }

    public String getFullPathForInteger(){
        return this.dirForResult + File.separator + (this.prefixFile.trim()+this.fileNameForInteger);
    }
    public String getFullPathForFloats(){
        return this.dirForResult + File.separator + (this.prefixFile.trim()+this.fileNameForFloats);
    }
    public String getFullPathForString(){
        return this.dirForResult + File.separator + (this.prefixFile.trim()+this.fileNameForString);
    }
    public String getDirForResult(){
        return this.dirForResult;
    }


    

    public  List<String> getListInputFiles() {
        return listInputFiles;
    }



    @Override
    public void update(String dirForResult, String prefixFile, List<String> listInputFiles) {
        this.dirForResult = (Path.of(this.dirForResult, dirForResult).toString()).trim();
        this.prefixFile = prefixFile;
        this.listInputFiles = listInputFiles;
    }



    @Override
    public String toString() {
        return "\nDirectoryInputOutputFile{" +
                "\ndirForResult='" + dirForResult + '\'' +
                ",\n prefixFile='" + prefixFile + '\'' +
                ", \nfileNameForInteger='" + fileNameForInteger + '\'' +
                ", \nfileNameForFloats='" + fileNameForFloats + '\'' +
                ", \nfileNameForString='" + fileNameForString + '\'' +
                ", \nlistInputFiles=" + listInputFiles +
                "\n}";
    }

}
