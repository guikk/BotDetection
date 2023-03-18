import java.util.Scanner;

public class Request {
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

    // Regular expression patterns
    private String quotesPattern = "\"([^\"]*)\""; // string in quotes
    private String bracketPattern = "\\[([^\\]]*)\\]"; // string in brackets

    public Request(String rawLogString) throws Exception {
        this.rawLog = rawLogString;

        try (Scanner scanner = new Scanner(this.rawLog)) {
            this.clientIP = scanner.next();
            this.identity = scanner.next();
            this.username = scanner.next();
            this.timestamp = scanner.findWithinHorizon(bracketPattern, 0);
            this.requestLine = scanner.findWithinHorizon(quotesPattern, 0);
            this.statusCode = scanner.nextInt();
            this.responseSize = scanner.nextInt();
            this.refererHeader = scanner.findWithinHorizon(quotesPattern, 0);
            this.userAgent = scanner.findWithinHorizon(quotesPattern, 0);
        } catch (Exception e) {
            throw new Exception("Request: Wrong log string format, expected \"%h %l %u %t \"%r\" %>s %b \"%{Referer}i\" \"%{User-agent}i\"\", but received " + rawLogString);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client IP: " + this.clientIP);
        sb.append("\nIdentity: " + this.identity);
        sb.append("\nUsername: " + this.username);
        sb.append("\nTimestamp: " + this.timestamp);
        sb.append("\nRequest: " + this.requestLine);
        sb.append("\nStatus code: " + this.statusCode);
        sb.append("\nResponse size: " + this.responseSize);
        sb.append("\nReferer: " + this.refererHeader);
        sb.append("\nUser-agent: " + this.userAgent);
        return sb.toString();
    }
} 