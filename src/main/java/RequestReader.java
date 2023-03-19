public interface RequestReader extends AutoCloseable{
    /**
     * @return The next request from the source
     * @throws Exception
     */
    public abstract Request read() throws Exception;

    public abstract void close() throws Exception;
}
