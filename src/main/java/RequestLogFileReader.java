import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestLogFileReader implements RequestReader {
    // TODO: Refactor reader to separate file reads from instantiating the Request structure

    private FileInputStream fstream;
    private BufferedReader reader;

    public RequestLogFileReader(String filename) throws FileNotFoundException{
        this.fstream = new FileInputStream(filename);
        this.reader = new BufferedReader(new InputStreamReader(fstream));
    }

    public Request read() throws Exception {
        String line = "";
        while (line.isEmpty()) { // ignore blank lines
            line = this.reader.readLine();
        }
        return new Request(line);
    }

    public void close() throws IOException {
        this.fstream.close();
        this.reader.close();
    }
}
