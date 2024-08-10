package revers.myDomain.staticToolsForWorkingWithFiles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class ReadWriteFile {

    public static String readFile(String pathFile) {
        StringBuilder data = new StringBuilder();
        try(    FileReader fr = new FileReader(pathFile, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(fr);
        ){
            String line;
            while((line = br.readLine()) != null) {
                data.append(line + "\n");
            }

        }catch (FileNotFoundException e) {
            System.out.println("File not found. The program will try to continue working without " +
                    Path.of(pathFile).getFileName()+
                    " file");
        }catch (IOException e) {
            System.out.println("Error. The program will try to continue working without " +
                    Path.of(pathFile).getFileName()+
                    " file");
        }
        return data.toString();
    }

    public static void writeFile(String pathFile, String data, Boolean append) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(pathFile, StandardCharsets.UTF_8, append))){
            bf.write(data+"\n");
        } catch (IOException e) {
            System.out.println("Error writing to file . The program will try to continue working without " +
                    Path.of(pathFile).getFileName()+
                    " file");
        }
    }


}
