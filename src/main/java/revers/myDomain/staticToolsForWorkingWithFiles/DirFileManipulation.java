package revers.myDomain.staticToolsForWorkingWithFiles;

import revers.myDomain.argsManipulation.DirectoriesAndFiles;
import revers.myDomain.dataManipulation.DataWorker;

import java.io.File;
import java.io.IOException;

public class DirFileManipulation {

    public static void createDirAndFile(DirectoriesAndFiles directoriesAndFiles, DataWorker dataWorker){
        boolean isCreatedDir = false;
        boolean isCreatedFileInteger = false;
        boolean isCreatedFileFloat = false;
        boolean isCreatedFileString = false;
        if(!dataWorker.getIntegerList().isEmpty()){
            isCreatedDir = true;
            isCreatedFileInteger = true;
        }
        if(!dataWorker.getDoubleListList().isEmpty()){
            isCreatedDir = true;
            isCreatedFileFloat = true;

        }
        if(!dataWorker.getStringList().isEmpty()){
            isCreatedDir = true;
            isCreatedFileString = true;
        }


        if(isCreatedDir){
            File diructory = new File(directoriesAndFiles.getDirForResult());
            if(!diructory.exists()){
                diructory.mkdirs();
            }
        }

        if(isCreatedFileInteger){
            File fileInteger = new File(directoriesAndFiles.getFullPathForInteger());
            if(!fileInteger.exists()){
                try {
                    fileInteger.createNewFile();
                } catch (IOException e) {
                    System.out.println("Error creating new file" + fileInteger.getName());
                    System.out.println("The program will try to continue working without this file" + fileInteger.getName());

                }
            }
        }

        if(isCreatedFileFloat){
            File fileFloat = new File(directoriesAndFiles.getFullPathForFloats());
            if(!fileFloat.exists()){
                try {
                    fileFloat.createNewFile();
                } catch (IOException e) {
                    System.out.println("Error creating new file" + fileFloat.getName());
                    System.out.println("The program will try to continue working without this file" + fileFloat.getName());

                }
            }
        }

        if(isCreatedFileString){
            File fileString = new File(directoriesAndFiles.getFullPathForString());
            if(!fileString.exists()){
                try {
                    fileString.createNewFile();
                } catch (IOException e) {
                    System.out.println("Error creating new file" + fileString.getName());
                    System.out.println("The program will try to continue working without this file" + fileString.getName());
                }
            }
        }

    }

}
