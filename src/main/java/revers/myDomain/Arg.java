package revers.myDomain;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

//Класс для манипуляции с аргументами.
public class Arg {
    //Мапа введенных опциональных аргументов K-значение аргумента V-булеан был ли введен данный аргумент или нет(по умолчанию ни один опциональный аргумент не введен)
    private static Map<String,Boolean> inputOptionalArgument = new HashMap<String,Boolean>();

    //шаблон для проверки, что аргумент похож на имя файла
    private static final Pattern patternTxtFile = Pattern.compile(".*.txt");


    public static void updateArguments(String ...args){
        if(isInvalidArgument(args)){
            return;
        }
        //заполняем дефолтными значениями Мапу введенных опциональных аргументов
        inputOptionalArgument.putIfAbsent("dirForResult", false);
        inputOptionalArgument.putIfAbsent("prefixToResultFile", false);
        inputOptionalArgument.putIfAbsent("addToResultFile", false);
        inputOptionalArgument.putIfAbsent("shortStatistic", false);
        inputOptionalArgument.putIfAbsent("longStatistic", false);

        //Перебираем все введенные аргументы, распределяя их в соответствии с их смысловой нагрузкой
        for (int i = 0; i < args.length; i++) {
            if (args[i].trim().equals("-o")) {
                inputOptionalArgument.put("dirForResult", true);
                DirectoryInputOutputFile.setDirForResult(args[i+1].trim());
                i++;
            }else if (args[i].trim().equals("-p")) {
                inputOptionalArgument.put("prefixToResultFile", true);
                DirectoryInputOutputFile.setPrefixFile(args[i+1].trim());
                i++;
            }else if (args[i].trim().equals("-a")) {
                inputOptionalArgument.put("addToResultFile", true);
                i++;
            }else if (args[i].trim().equals("-s")) {
                inputOptionalArgument.put("shortStatistic", true);
            }else if (args[i].trim().equals("-f")) {
                inputOptionalArgument.put("longStatistic", true);
            } else if (patternTxtFile.matcher(args[i].trim()).matches()) {
                DirectoryInputOutputFile.addNewInputFile(args[i].trim());
            }else {
                System.out.println(args[i] + " is not a valid argument. The program will try to continue working without this argument");
            }
        }
    }

    //проверка аргументов
    private static boolean isInvalidArgument(String[] args){
        boolean isInvalid = true;
        //проверка, что есть хотябы один входной файл
        if(args.length>0){
            for (int i = 0; i < args.length; i++) {
                if(patternTxtFile.matcher(args[i].trim()).matches()){
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


}
