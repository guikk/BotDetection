public interface RequestReader extends AutoCloseable{
    public abstract Request read() throws Exception;
    public abstract void close() throws Exception;
}
