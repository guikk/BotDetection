import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccessLogFileReader implements AccessReader {
    private FileInputStream fstream;
    private BufferedReader reader;

    public AccessLogFileReader(String filename) throws FileNotFoundException{
        try {
            this.fstream = new FileInputStream(filename);
            this.reader = new BufferedReader(new InputStreamReader(fstream));;
        } catch (Exception e) {
            throw new FileNotFoundException("AccessReader Error: " + e.getMessage());
        }
    }

    public Access read() throws IOException {
        String line;
        try {
            line = this.reader.readLine();
        } catch (Exception e) {
            throw new IOException("AccessReader Error: " + e.getMessage());
        }
        return new Access(line);
    }

    public void close() throws IOException {
        try {
            this.fstream.close();
            this.reader.close();
        } catch (Exception e) {
            throw new IOException("AccessReader Error: " + e.getMessage());     
        }
    }
}
