import java.util.Scanner;
import java.util.regex.Pattern;

public class Request {
    private String rawLog;
    private String clientIP;
    private String username;
    private String timestamp;
    private String requestLine;
    private int statusCode;
    private int responseSize;
    private String refererHeader;
    private String userAgent;

    // Regular expression patterns
    private Pattern quotesPattern = Pattern.compile("\"([^\"]*)\""); // string in quotes
    private Pattern bracketPattern = Pattern.compile("\\[(.*)\\]"); // string in brackets

    public Request(String rawLogString) {
        this.rawLog = rawLogString;

        Scanner scanner = new Scanner(this.rawLog);

        this.clientIP = scanner.next();
        System.out.println("IP: " + this.clientIP);
        // discard identity of the user determined by identd
        System.out.println("identity: " + scanner.next());
        this.username = scanner.next();
        System.out.println("username: " + this.username);
        this.timestamp = scanner.next(bracketPattern);
        System.out.println("time: " + this.timestamp);
        this.requestLine = scanner.next(quotesPattern);
        System.out.println("request: " + this.requestLine);
        this.statusCode = scanner.nextInt();
        System.out.println("status: " + this.statusCode);
        this.responseSize = scanner.nextInt();
        System.out.println("size: " + this.responseSize);
        this.refererHeader = scanner.next(quotesPattern);
        System.out.println("Referer: " + this.refererHeader);
        this.userAgent = scanner.next(quotesPattern);
        System.out.println("user agent: " + this.userAgent);

        scanner.close();
    }

    public String toString() {
        return "Host(" + this.clientIP + ")" + "Request(" + this.requestLine + ")";
    }
} 