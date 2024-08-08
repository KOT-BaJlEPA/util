package revers.myDomain.readWrite;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class ManipulationWithFiles {

    public static String readFile(String pathFile) {
        StringBuilder data = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(pathFile, StandardCharsets.UTF_8));
        ) {
            String line;
            while((line = br.readLine()) != null) {
                data.append(line + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("File not found. The program will try to continue working without " +
                    Path.of(pathFile).getFileName()+
                    " file");
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("Error. The program will try to continue working without " +
                    Path.of(pathFile).getFileName()+
                    " file");
        }
        return data.toString();
    }

    public static void writeFile(String pathFile, String data, Boolean append) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(pathFile, StandardCharsets.UTF_8, append))){
            bf.write(data);
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("Error. The program will try to continue working without " +
                    Path.of(pathFile).getFileName()+
                    " file");
        }
    }


}
