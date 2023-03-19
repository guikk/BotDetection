import java.util.Scanner;
import java.util.regex.Pattern;

public class Request {
    // TODO: Valid/invalid unit tests to improve completeness
        // Valid -> String in brackets
        // Valid -> String in quotes (no escapes)
        // Valid -> String in quotes (with escapes) <------- not currently covered
        // Invalid
    // TODO: Validate fields are also in format
    // TODO: Exception handling to improve robustness (not crash due to bad format)
    private String rawLog;
    private String clientIP;
    private String identity;
    private String username;
    private String timestamp;
    private String requestLine;
    private int statusCode;
    private int responseSize;
    private String refererHeader;
    private String userAgent;

    public Request(String rawLogString) throws Exception {
        this.rawLog = rawLogString;
        this.marshallRawLog();
    }

    
        // Regular expressions
        // TODO: Change quotes pattern to support escaped characters inside string
        private Pattern quotesPattern = Pattern.compile("\"([^\"]*)\""); // string in quotes
        private Pattern bracketPattern = Pattern.compile("\\[([^\\]]*)\\]"); // string in brackets
    /**
     * Reads the raw log string and assigns formatted data into the Request structure's fields
     * @throws Exception
     */
    private void marshallRawLog() throws Exception {
        
        try (Scanner scanner = new Scanner(this.rawLog)) {
            this.clientIP = scanner.next();
            this.identity = scanner.next();
            this.username = scanner.next();
            this.timestamp = scanner.findWithinHorizon(bracketPattern, 0);
            this.requestLine = scanner.findWithinHorizon(quotesPattern, 0);
            this.statusCode = scanner.nextInt();
            if (scanner.hasNextInt()) {
                this.responseSize = scanner.nextInt();
            } else { // If response size is 0, the log info is '-'
                this.responseSize = 0;
                scanner.next();
            }
            this.refererHeader = scanner.findWithinHorizon(quotesPattern, 0);
            this.userAgent = scanner.findWithinHorizon(quotesPattern, 0);
        } catch (Exception e) {
            System.out.println(
                "Request: Wrong log format: " + this.rawLog + "\n" +
                " expected \"%h %l %u %t \"%r\" %>s %b \"%{Referer}i\" \"%{User-agent}i\"\"" + "\n Error: " +
                e + "\n"
            );
        }
    }

    public String getClientIP() {
        return this.clientIP;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client IP: " + this.clientIP);
        sb.append(", Identity: " + this.identity);
        sb.append(", Username: " + this.username);
        sb.append(", Timestamp: " + this.timestamp);
        sb.append(", Request: " + this.requestLine);
        sb.append(", Status code: " + this.statusCode);
        sb.append(", Response size: " + this.responseSize);
        sb.append(", Referer: " + this.refererHeader);
        sb.append(", User-agent: " + this.userAgent);
        return sb.toString();
    }
} 