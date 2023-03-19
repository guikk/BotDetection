public interface WebMetrics {
    /**
     * @return If there is currently a spike on pageviews or not
     */
    public abstract boolean hasPageViewSpike();


    /**
     * @return Current bounce rate
     */
    public abstract float getBounceRate();


    /**
     * @param host Client IP
     * @return Current session duration for the host
     */
    public abstract float getSessionDuration(String host);
}
