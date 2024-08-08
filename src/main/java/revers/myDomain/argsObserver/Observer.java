package revers.myDomain.argsObserver;

import java.util.List;

public interface Observer {
    //для revers/myDomain/Arg.java
    public void update(List<String> listArgs);

    //для revers.myDomain.DirectoriesAndFiles
    public void update(String dirForResult, String prefixFile, List<String> listInputFiles);
}

