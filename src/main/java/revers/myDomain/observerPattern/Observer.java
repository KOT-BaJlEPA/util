package revers.myDomain.observerPattern;

import java.util.List;
import java.util.Observable;

public interface Observer {
    //для revers/myDomain/Arg.java
    public void update(List<String> listArgs);

    //для revers.myDomain.DirectoryInputOutputFile
    public void update(String dirForResult, String prefixFile, List<String> listInputFiles);
}

