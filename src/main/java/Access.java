public class Access {
    private String rawString;
    private String clientIP;
    private String username;
    private String timestamp;
    private String requeString;
    private int statusCode;
    private int responseSize;
    private String refererHeader;
    private String userAgent;

    public Access(String rawLogString) {
        this.rawString = rawLogString;
    }

    public String toString() {
        return this.rawString;
    }
} 