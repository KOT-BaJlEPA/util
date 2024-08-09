package revers.myDomain;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String path = "C:\\Users\\regul\\IdeaProjects\\util\\src\\main" +
                "\\java\\revers\\myDomain\\test.txt";

        String path2 = "C:\\Users\\regul\\IdeaProjects\\util\\src\\main" +
                "\\java\\revers\\myDomain\\test2.txt";

        String[] arStr = {"-a", path};

        Application application = new Application("-a", "-o", "result", "-p", "this_is","-f", path, path2);
//        application.run();
        System.out.println(44646465);

    }
}