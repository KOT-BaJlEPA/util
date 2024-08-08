package revers.myDomain.dirAndFileManipulation;

import java.io.File;

public class DirManipulation {
    public static void createDir(String dir){
        File diructory = new File(dir);
        if(!diructory.exists()){
            diructory.mkdir();
        }
    }

}
