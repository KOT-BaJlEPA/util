package revers.myDomain.argsManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

//Класс для манипуляции с аргументами.
public class ParserArgs implements Observer, Subject {
    //Мапа введенных опциональных аргументов K-значение аргумента V-булеан был ли введен данный аргумент или нет(по умолчанию ни один опциональный аргумент не введен)
    private  Map<String,Boolean> inputOptionalArgument = new HashMap<String,Boolean>();

    //шаблон для проверки, что аргумент похож на имя файла
    private final Pattern patternTxtFile = Pattern.compile(".*.txt");

    private String dirForResult = "";
    private String prefixFile = "";
    private List<String> inputFileList = new ArrayList<String>();

    //лист сырых необработанных аргументов
    private List<String> rawListArguments = new ArrayList<>();

    private List<Observer> listObservers = new ArrayList<>();


    public ParserArgs() {
        //заполняем дефолтными значениями Мапу введенных опциональных аргументов
        inputOptionalArgument.put("dirForResult", false);
        inputOptionalArgument.put("prefixToFile", false);
        inputOptionalArgument.put("addToFile", false);
        inputOptionalArgument.put("shortStatistic", false);
        inputOptionalArgument.put("longStatistic", false);
    }

    //обрабатывает лист сырых аргументов и оповещает Observer DirectoryInputOutputFile
    private void parseArguments() {
        //проверка, что есть хотябы один входной файл
        if(isInvalidArgument()){
            return;
        }
        //Перебираем все введенные аргументы, распределяя их в соответствии с их смысловой нагрузкой
        for (int i = 0; i < this.rawListArguments.size(); i++) {
            //Try Catch на случай если будет опциональный аргумент за, которым должно быть значеие, но значение не введут
            try{
                if (this.rawListArguments.get(i).trim().equals("-o")) {
                    inputOptionalArgument.put("dirForResult", true);
                    this.dirForResult = this.rawListArguments.get(i+1).trim();
                    i++;
                }else if (this.rawListArguments.get(i).trim().equals("-p")) {
                    inputOptionalArgument.put("prefixToFile", true);
                    prefixFile = this.rawListArguments.get(i+1).trim();
                    i++;
                }else if (this.rawListArguments.get(i).trim().equals("-a")) {
                    inputOptionalArgument.put("addToFile", true);
                    i++;
                }else if (this.rawListArguments.get(i).trim().equals("-s")) {
                    inputOptionalArgument.put("shortStatistic", true);
                }else if (this.rawListArguments.get(i).trim().equals("-f")) {
                    inputOptionalArgument.put("longStatistic", true);
                } else if (patternTxtFile.matcher(this.rawListArguments.get(i).trim()).matches()) {
                    this.inputFileList.add(this.rawListArguments.get(i).trim());
                }else {
                    System.out.println(this.rawListArguments.get(i) + " is not a valid argument. The program will try to continue working without this argument");
                }
            }
            catch(IndexOutOfBoundsException e){
                e.printStackTrace();
                e.getCause();
                System.out.println("After the entered optional argument not found the value of argument");
            }
        }
        //прокаидываем данные об аргументах, которые удальсь получить дальше
        this.notifyObservers();

    }

    //проверка аргументов
    private  boolean isInvalidArgument(){
        boolean isInvalid = true;
        //проверка, что есть хотябы один входной файл
        if(!this.rawListArguments.isEmpty()){
            for (int i = 0; i < this.rawListArguments.size(); i++) {
                if(patternTxtFile.matcher(this.rawListArguments.get(i).trim()).matches()){
                    isInvalid = false;
                    break;
                }
                if(isInvalid){
                    System.out.println("No input file found ");
                }
            }
        }else {
            System.out.println("args is empty try again");
        }
        return isInvalid;
    }


    //сохраняем лист сырых аргументов и обрабатываем его this.updateArguments()
    @Override
    public void update(List<String> listArgs) {
        this.rawListArguments = listArgs;
        this.parseArguments();
    }



    @Override
    public void registerObserver(Observer... observers) {
        for (int i = 0; i < observers.length; i++) {
            this.listObservers.add(observers[i]);
        }
    }

    @Override
    public void removeObserver(Observer... observers) {
        for (int i = 0; i < observers.length; i++) {
            this.listObservers.remove(observers[i]);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < this.listObservers.size(); i++) {
            this.listObservers.get(i).update(this.dirForResult, this.prefixFile, this.inputFileList);
        }
    }



    @Override
    public String toString() {
        return "Arg{" +
                "inputOptionalArgument=" + inputOptionalArgument +
                ", patternTxtFile=" + patternTxtFile +
                ", dirForResult='" + dirForResult + '\'' +
                ", prefixFile='" + prefixFile + '\'' +
                ", inputFileList=" + inputFileList +
                ", rawListArguments=" + rawListArguments +
                ", listObservers=" + listObservers +
                '}';
    }

    //plug
    @Override
    public void update(String dirForResult, String prefixFile, List<String> listArgs) {
    }
}
