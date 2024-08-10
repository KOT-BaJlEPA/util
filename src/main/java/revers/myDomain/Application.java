package revers.myDomain;

import revers.myDomain.argsManipulation.DirectoriesAndFiles;
import revers.myDomain.argsManipulation.ParserArgs;
import revers.myDomain.dataManipulation.DataWorker;
import revers.myDomain.dataManipulation.Statistic;
import revers.myDomain.staticToolsForWorkingWithFiles.DirFileManipulation;
import revers.myDomain.staticToolsForWorkingWithFiles.ReadWriteFile;


//
public class Application {
    private ParserArgs parserArgs;
    private DirectoriesAndFiles directoriesAndFiles;
    private DataWorker dataWorker;
    private Statistic statistic;
    private String[] args;


    public Application(String ...args) {
        this.args = args;
        this.parserArgs = new ParserArgs();
        this.directoriesAndFiles = new DirectoriesAndFiles();
        this.dataWorker = new DataWorker();
    }


    public void run(){
        this.createDependencies();
        this.readFiles();
        this.writeFiles();
        this.statistic = new Statistic(this.dataWorker);
        if(this.parserArgs.isShortStatistic()){
            this.statistic.shortStatistic();
        }
        if(this.parserArgs.isFullStatistic()){
            this.statistic.fullStatistic();
        }
        System.out.println("Done!");
    }

    private void createDependencies(){
        this.parserArgs.registerObserver(this.directoriesAndFiles);
        this.parserArgs.setRawArgs(this.args);
    }

    private void readFiles(){
        String rawData;
        for ( String inputFile: this.directoriesAndFiles.getListInputFiles()) {
            rawData = ReadWriteFile.readFile(inputFile);
            this.dataWorker.parserData(rawData);
        }
    }
    private void writeFiles(){
        DirFileManipulation.createDirAndFile(this.directoriesAndFiles, this.dataWorker);
        if(!dataWorker.getLongList().isEmpty()){
                String valueFoWrite = bildListIntegerToString();
                ReadWriteFile.writeFile(this.directoriesAndFiles.getFullPathForInteger(), valueFoWrite, this.parserArgs.isAppend());
        }
        if(!dataWorker.getDoubleListList().isEmpty()){
                String valueFoWrite = bildListDoubleToString();
                ReadWriteFile.writeFile(this.directoriesAndFiles.getFullPathForFloats(), valueFoWrite, this.parserArgs.isAppend());
        }
        if(!dataWorker.getStringList().isEmpty()){
            String valueFoWrite = bildListStringToString();
                ReadWriteFile.writeFile(this.directoriesAndFiles.getFullPathForString(), valueFoWrite, this.parserArgs.isAppend());
        }

    }

    private String bildListIntegerToString(){
        StringBuilder result = new StringBuilder();
        this.dataWorker.getLongList().stream().forEach((el)->{
            result.append(el.toString() + "\n");
        });
        return result.toString();
    }

    private String bildListDoubleToString(){
        StringBuilder result = new StringBuilder();
        this.dataWorker.getDoubleListList().stream().forEach((el)->{
            result.append(el.toString() + "\n");
        });
        return result.toString();
    }

    private String bildListStringToString(){
        StringBuilder result = new StringBuilder();
        this.dataWorker.getStringList().stream().forEach((el)->{
            result.append(el + "\n");
        });
        return result.toString();
    }



}
