package revers.myDomain.argsManipulation;

import java.util.List;

public interface Observer {

    public void update(String dirForResult, String prefixFile, List<String> listInputFiles);
}

