

public class BotDetector {
    public static void main(String args[]) throws Exception {
        try (RequestReader requestReader = new RequestLogFileReader("input_data/access.log")) {
            while (true) {
                BotDetector.detect(requestReader.read());
            }
        }
    }

    static boolean detect(Request Request) {
        return false;
    }
}