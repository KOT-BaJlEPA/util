package revers.myDomain;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Args {

    private static Map<String,Boolean> inputArgument = new HashMap<String,Boolean>();

    public static void updateArguments(String ...args){
        inputArgument.putIfAbsent("dirForResult", false);
        inputArgument.putIfAbsent("prefixToResultFile", false);
        inputArgument.putIfAbsent("addToResultFile", false);
        inputArgument.putIfAbsent("shortStatistic", false);
        inputArgument.putIfAbsent("longStatistic", false);

        for (int i = 0; i < args.length; i++) {
            //шаблон для проверки что аргумент похож на имя файла
            Pattern patternNameFileTxt = Pattern.compile(".*.txt");
            if (args[i].trim().equals("-o")) {
                inputArgument.put("dirForResult", true);
            }else if (args[i].trim().equals("-p")) {
                inputArgument.put("prefixToResultFile", true);
            }else if (args[i].trim().equals("-a")) {
                inputArgument.put("addToResultFile", true);
            }else if (args[i].trim().equals("-s")) {
                inputArgument.put("shortStatistic", true);
            }else if (args[i].trim().equals("-f")) {
                inputArgument.put("longStatistic", true);
            } else if (patternNameFileTxt.matcher(args[i]).matches()) {
                String fileName = args[i];
            }
        }
    }




    public static boolean checkArgs(String[] args) {
        if (args.length < 1) {
            return false;
        }
        return false;
    }
}
