import java.util.HashSet;

public class BotDetector {
    // TODO: Persist ACLs, Singleton pattern (?)
    // TODO: Unit test `detect`, one test per exit condition and one more for the success ("false" outcome)

    WebMetrics metrics;

    // TODO: Optimize data structure, IP could be converted into a 4B unsigned int
    private HashSet<String> hostBlocklist;

    public BotDetector() {
        this.hostBlocklist = new HashSet<String>();
        // TODO: Initialize metrics instance (e. g. this.metrics = new WebMetricsImplementation();)
    }

    /**
     * @param request The request data to be identified as human or bot traffic
     * @return True if the request is detected as bot traffic, else false
     */
    public boolean detect(Request request) {
        if (this.hostBlocklist.contains(request.getClientIP())) {
            return true;
        }

        // TODO: Blocklist requests triggering abnormalities, pseudocode examples below
        // if (this.metrics.getPageViews() > NORMAL_PAGEVIEWS) {
        //     check if IP made too many requests
        //     if so, blocklist
        //     return true;
        // }
        // if (this.metrics.getBounceRate() > NORMAL_BOUNCE_RATE) {
        //     check if IP had multiple bounces
        //     if so, blocklist
        //     return true;
        // }
        // if (isSessionDurationOutlier(this.metrics.getSessionDuration())) {
        //     blocklist
        //     return true;
        // }

        return false;
    }

    public static void main(String args[]) throws Exception {
        BotDetector detector = new BotDetector();

        try (RequestReader requestReader = new RequestLogFileReader("input_data/access.log")) {
            while (true) {
                Request request = requestReader.read();
                // System.out.println("Detecting: " + request);
                detector.detect(request);
            }
        }
    }
}