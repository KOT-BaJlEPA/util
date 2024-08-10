package revers.myDomain.dataManipulation;

public class Statistic {
    private DataWorker dataWorker;

    public Statistic(DataWorker dataWorker) {
        this.dataWorker = dataWorker;
    }

    public void shortStatistic(){
        System.out.println("\n\n-----------------------------Краткая статисика-----------------------------");
        System.out.println("\t\tЦелых чисел введено : " + this.dataWorker.getLongList().size());
        System.out.println("\t\tВещественных чисел введено : " + this.dataWorker.getDoubleListList().size());
        System.out.println("\t\tСтрок введено : " + this.dataWorker.getStringList().size());
        System.out.println("---------------------------------------------------------------------------\n\n");
    }

    public void fullStatistic(){
        System.out.println("\n\n-----------------------------Полная статисика-----------------------------");
        System.out.println("\tЦелых чисел введено : " + this.dataWorker.getLongList().size());
        if(this.dataWorker.getLongList().size()>0){
            System.out.println("\t\tМаксимальное целое число : " + this.maxElement("int"));
            System.out.println("\t\tМинимальное целое число : " + this.minElement("int"));
            System.out.println("\t\tСумма целых чисел : " + this.sumElements("int"));
            System.out.println("\t\tСреднее значение целых чисел (было округлено до тысячных): " + this.averageElements("int"));
        }


        System.out.println("\n\tВещественных чисел введено : " + this.dataWorker.getDoubleListList().size());
        if(this.dataWorker.getDoubleListList().size()>0){
            System.out.println("\t\tМаксимальное Вещественное число : " + this.maxElement("double"));
            System.out.println("\t\tМинимальное Вещественное число : " + this.minElement("double"));
            System.out.println("\t\tСумма Вещественных чисел : " + this.sumElements("double"));
            System.out.println("\t\tСреднее значение Вещественных чисел (было округлено до тысячных): " + this.averageElements("double"));
        }

        System.out.println("\n\tСтрок введено : " + this.dataWorker.getStringList().size());
        if(this.dataWorker.getStringList().size()>0){
            System.out.println("\t\tДлинна самой длинной строки : " + this.maxMinString("max"));
            System.out.println("\t\tДлинна самой короткой строки : " + this.maxMinString("min"));
        }
        System.out.println("---------------------------------------------------------------------------\n\n");
    }

    private Number sumElements(String caseValue){
        Number sum = 0;
        switch (caseValue){
            case "int":
                sum = this.dataWorker.getLongList().stream().reduce(0L, (acc, el) -> acc + el);
                break;
            case "double":
                sum = Double.valueOf(this.dataWorker.getDoubleListList().stream().reduce(0.0, (acc, el) -> acc + el).toString());
                break;
        }
        return sum;
    }

    private Number averageElements(String caseValue){
        Number avg = 0;
        switch (caseValue){
            case "int":
                long divisible = this.dataWorker.getLongList().stream().reduce(0L, (acc, el) -> acc + el);
                long divider = this.dataWorker.getLongList().size();
                Double doubleDivisible = Double.valueOf(divisible);
                Double doubleDivider = Double.valueOf(divider);
                avg = doubleDivisible/doubleDivider;
                break;
            case "double":
                avg = Double.valueOf(this.dataWorker.getDoubleListList().stream().reduce(0.0, (acc, el) -> acc + el).toString())
                        /this.dataWorker.getDoubleListList().size();
                break;
        }
        avg = Math.round(avg.doubleValue()*1000)/1000.0;
        return avg;
    }

    private Number maxElement(String caseValue){
        Number max = 0;
        switch (caseValue){
            case "int":
                max = this.dataWorker.getLongList().stream().max((i1, i2) -> Long.compare(i1, i2)).get();
                break;
            case "double":
                max = this.dataWorker.getDoubleListList().stream().max((d1, d2) -> Double.compare(d1, d2)).get();
                break;
        }
        return max;
    }

    private Number minElement(String caseValue){
        Number min = 0;
        switch (caseValue){
            case "int":
                min = this.dataWorker.getLongList().stream().min((i1, i2) -> Long.compare(i1, i2)).get();
                break;
            case "double":
                min = this.dataWorker.getDoubleListList().stream().min((d1, d2) -> Double.compare(d1, d2)).get();
                break;
        }
        return min;
    }

    private int maxMinString(String caseValue){
        int val = 0;
        switch (caseValue){
            case "max":
                val = this.dataWorker.getStringList().stream().max((str1, str2) ->{
                    return str1.length() - str2.length();
                }).get().length();
                break;
            case "min":
                val = this.dataWorker.getStringList().stream().min((str1, str2) ->{
                    return str1.length() - str2.length();
                }).get().length();
                break;
        }
        return val;
    }

}
