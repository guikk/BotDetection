public interface AccessReader extends AutoCloseable{
    public abstract Access read() throws Exception;
    public abstract void close() throws Exception;
}
