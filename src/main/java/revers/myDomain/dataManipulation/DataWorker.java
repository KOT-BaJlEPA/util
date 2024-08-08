package revers.myDomain.dataManipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataWorker {
    private List<Integer> integerList;
    private List<Double> doubleListList;
    private List<String> stringList;

    public DataWorker() {
        this.integerList = new ArrayList<Integer>();
        this.doubleListList = new ArrayList<Double>();
        this.stringList = new ArrayList<String>();
    }

    public void parserData(String data){
        Scanner scanner = new Scanner(data);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            this.separatorData(line);
        }
    }

    private void separatorData(String line){
        int intValue;
        double doubleValue;
        try {
            intValue = Integer.parseInt(line);
            this.integerList.add(intValue);
        }catch (NumberFormatException e){
            try {
                doubleValue = Double.parseDouble(line);
                this.doubleListList.add(doubleValue);
            }catch (NumberFormatException e2){
                this.stringList.add(line);
            }

        }
    }

    @Override
    public String toString() {
        return "DataWorker{" +
                "integerList=" + integerList +
                ", doubleListList=" + doubleListList +
                ", stringList=" + stringList +
                '}';
    }
}
