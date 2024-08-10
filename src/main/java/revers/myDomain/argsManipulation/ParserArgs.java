package revers.myDomain.argsManipulation;

import java.util.*;
import java.util.regex.Pattern;


//класс отвечает за обработку и хранение введенных аргументов
public class ParserArgs implements Subject {

    private String[] rawArgs;

    //Мапа введенных опциональных аргументов K-значение аргумента V-булеан был ли введен данный аргумент или нет(по умолчанию ни один опциональный аргумент не введен)
    private Map<String,Boolean> inputOptionalArgument = new HashMap<String,Boolean>();

    //шаблон для проверки, что аргумент похож ли на имя файла
    private final Pattern patternTxtFile = Pattern.compile(".*.txt");

    private String dirForResult = "";
    private String prefixFile = "";
    private List<String> inputFileList = new ArrayList<>();

    private List<Observer> listObservers = new ArrayList<>();


    public ParserArgs() {
        //заполняем дефолтными значениями Мапу введенных опциональных аргументов
        inputOptionalArgument.put("dirForResult", false);
        inputOptionalArgument.put("prefixToFile", false);
        inputOptionalArgument.put("addToFile", false);
        inputOptionalArgument.put("shortStatistic", false);
        inputOptionalArgument.put("longStatistic", false);
    }

    public void setRawArgs(String ...args) {
        this.rawArgs = args;
        //проверка, что есть хотябы один входной файл
        if(!this.isInvalidArguments()){
            this.parseArguments();
        }
    }


    //обрабатывает лист сырых аргументов и оповещает наблюдателя DirectoryInputOutputFile
    private void parseArguments() {
        //Перебираем все введенные аргументы, распределяя их в соответствии с их смысловой нагрузкой
        for (int i = 0; i < this.rawArgs.length; i++) {
            //Try Catch на случай если будет опциональный аргумент за, которым должно быть значеие, но значение не введут
            try{
                if (this.rawArgs[i].trim().equals("-o")) {
                    if(this.isInvalidValueOfOptionalArgument(this.rawArgs[i+1].trim())){
                        System.out.println("After Optional argument : " + this.rawArgs[i].trim() + " is invalid values : " + this.rawArgs[i+1].trim());
                        System.out.println("The program will try to continue working without this arguments");
                    }else {
                        inputOptionalArgument.put("dirForResult", true);
                        this.dirForResult = this.rawArgs[i+1].trim();
                        i++;
                    }
                }else if (this.rawArgs[i].trim().equals("-p")) {
                    if(this.isInvalidValueOfOptionalArgument(this.rawArgs[i+1].trim())){
                        System.out.println("After Optional argument : " + this.rawArgs[i].trim() + " is invalid values : " + this.rawArgs[i+1].trim());
                        System.out.println("The program will try to continue working without this arguments");
                    }else {
                        inputOptionalArgument.put("prefixToFile", true);
                        this.prefixFile= this.rawArgs[i+1].trim();
                        i++;
                    }
                }else if (this.rawArgs[i].trim().equals("-a")) {
                    inputOptionalArgument.put("addToFile", true);;
                }else if (this.rawArgs[i].trim().equals("-s")) {
                    inputOptionalArgument.put("shortStatistic", true);
                }else if (this.rawArgs[i].trim().equals("-f")) {
                    inputOptionalArgument.put("longStatistic", true);
                } else if (patternTxtFile.matcher(this.rawArgs[i].trim()).matches()) {
                    this.inputFileList.add(this.rawArgs[i].trim());
                }else {
                    System.out.println(this.rawArgs[i] + " is not a valid argument. The program will try to continue working without this argument");
                }
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("After the entered optional argument not found the value of argument" +
                        "\n The program will try to continue working without this argument");
            }
        }
        //оповещаем наблюдателей что появились аргументы
        this.notifyObservers();
    }

    public boolean isAppend(){
        return inputOptionalArgument.get("addToFile");
    }

    public boolean isFullStatistic(){
        return inputOptionalArgument.get("longStatistic");
    }

    public boolean isShortStatistic(){
        return inputOptionalArgument.get("shortStatistic");
    }


    //проверяет есть ли после опционального аргумента значение аргумента
    private boolean isInvalidValueOfOptionalArgument(String value){
        boolean isInvalid = false;
        String[] wrongValues = {"-o","-p","-s","-f","-a"};
        //если следующий аргумент соответствует одному из элементов wrongValues[], то это не значение аргумента а друой аргумент
        for (int i = 0; i <wrongValues.length; i++) {
            if(value.equals(wrongValues[i])){
                isInvalid = true;
            }
        }
        //если следующий аргумент соответствует шаблону this.patternTxtFile, то это не значение аргумента а имя файла
        if(this.patternTxtFile.matcher(value).matches()){
            isInvalid = true;
        }
        return isInvalid;
    }

    //проверка аргументов
    private  boolean isInvalidArguments(){
        boolean isInvalid = true;
        //проверка, что есть хотябы один входной файл
        if(this.rawArgs.length>0){
            for (int i = 0; i < this.rawArgs.length; i++) {
                if(patternTxtFile.matcher(this.rawArgs[i].trim()).matches()){
                    isInvalid = false;
                    break;
                }
            }
            if(isInvalid){
                System.out.println("No input file found ");
            }
        }else {
            System.out.println("args is empty try again");
        }
        return isInvalid;
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
        return "\nArg{" +
                "\ninputOptionalArgument=" + inputOptionalArgument +
                ", \npatternTxtFile=" + patternTxtFile +
                ", \ndirForResult='" + dirForResult + '\'' +
                ", \nprefixFile='" + prefixFile + '\'' +
                ", \ninputFileList=" + inputFileList +
                ", \nrawArgs=" + rawArgs.length+
                ", \nlistObservers=" + listObservers +
                "\n}";
    }

}

