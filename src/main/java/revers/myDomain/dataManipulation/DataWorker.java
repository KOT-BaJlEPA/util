package revers.myDomain.dataManipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//класс отвечает за обработку и хранение данных
public class DataWorker {
    private List<Long> longsList;
    private List<Double> doubleListList;
    private List<String> stringList;

    public DataWorker() {
        this.longsList = new ArrayList<Long>();
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
        if(line.length()==0){
            return;
        }
        long longValue;
        double doubleValue;
        try {
            longValue = Long.parseLong(line);
            this.longsList.add(longValue);
        }catch (NumberFormatException e){
            try {
                doubleValue = Double.parseDouble(line);
                this.doubleListList.add(doubleValue);
            }catch (NumberFormatException e2){
                this.stringList.add(line);
            }

        }
    }

    public List<Long> getLongList(){
        return this.longsList;
    }
    public List<Double> getDoubleListList(){
        return this.doubleListList;
    }
    public List<String> getStringList(){
        return this.stringList;
    }

    @Override
    public String toString() {
        return "\nDataWorker{" +
                "\nintegerList=" + longsList +
                ", \ndoubleListList=" + doubleListList +
                ", \nstringList=" + stringList +
                "\n}";
    }
}
