package revers.myDomain;

import revers.myDomain.argsManipulation.DirectoriesAndFiles;
import revers.myDomain.argsManipulation.ParserArgs;
import revers.myDomain.argsManipulation.RawAllArgsSubject;
import revers.myDomain.dataManipulation.DataWorker;
import revers.myDomain.dataManipulation.Statistic;
import revers.myDomain.dirAndFileManipulation.ReadWriteFile;

public class Application {

    private RawAllArgsSubject rawAllArgsSubject;
    private ParserArgs parserArgs;
    private DirectoriesAndFiles directoriesAndFiles;
    private DataWorker dataWorker;
    private Statistic statistic;
    private String[] args;


    public Application(String[] args) {
        this.args = args;
        this.rawAllArgsSubject = new RawAllArgsSubject();
        this.parserArgs = new ParserArgs();
        this.directoriesAndFiles = new DirectoriesAndFiles();
        this.dataWorker = new DataWorker();
        this.statistic = new Statistic();
    }

    private void createDependencies(){
        this.rawAllArgsSubject.registerObserver(this.parserArgs);
        this.parserArgs.registerObserver(this.directoriesAndFiles);
        this.rawAllArgsSubject.setNewArgs(this.args);
    }

    public void run(){
        createDependencies();
        String rawData;
        for ( String inputFile: this.directoriesAndFiles.getListInputFiles()) {
            rawData = ReadWriteFile.readFile(inputFile);
            this.dataWorker.parserData(rawData);
        }
    }


}
