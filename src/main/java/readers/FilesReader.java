package readers;

import java.io.IOException;

public interface FilesReader {

    void readFromFile(String path) throws IOException;
}
