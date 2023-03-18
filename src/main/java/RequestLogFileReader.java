import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestLogFileReader implements RequestReader {
    private FileInputStream fstream;
    private BufferedReader reader;

    public RequestLogFileReader(String filename) throws FileNotFoundException{
        try {
            this.fstream = new FileInputStream(filename);
        } catch (Exception e) {
            throw new FileNotFoundException("RequestLogFileReader Error: " + e.getMessage());
        }
        this.reader = new BufferedReader(new InputStreamReader(fstream));
    }

    public Request read() throws IOException {
        String line = "";
        try {
            // ignore blank lines
            while (line.isEmpty()) {
                line = this.reader.readLine();
            }
        } catch (Exception e) {
            throw new IOException("RequestLogFileReader Error: " + e.getMessage());
        }
        return new Request(line);
    }

    public void close() throws IOException {
        try {
            this.fstream.close();
            this.reader.close();
        } catch (Exception e) {
            throw new IOException("RequestLogFileReader Error: " + e.getMessage());     
        }
    }
}
