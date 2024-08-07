package revers.myDomain;

import java.util.HashMap;
import java.util.Map;

public class Args {

    private static Map<String,Boolean> inputArgument = new HashMap<String,Boolean>();

    public static void updateArguments(String ...args){
        inputArgument.putIfAbsent("dirForResult", false);
        inputArgument.putIfAbsent("prefixToResultFile", false);
        inputArgument.putIfAbsent("addToResultFile", false);
        inputArgument.putIfAbsent("shortStatistic", false);
        inputArgument.putIfAbsent("longStatistic", false);

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o")) {
                inputArgument.put("dirForResult", true);
            }else if (args[i].equals("-p")) {
                inputArgument.put("prefixToResultFile", true);
            }else if (args[i].equals("-a")) {
                inputArgument.put("addToResultFile", true);
            }else if (args[i].equals("-s")) {
                inputArgument.put("shortStatistic", true);
            }else if (args[i].equals("-f")) {
                inputArgument.put("longStatistic", true);
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
