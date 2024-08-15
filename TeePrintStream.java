import java.io.OutputStream;
import java.io.PrintStream;

public class TeePrintStream extends PrintStream {
    private PrintStream secondStream;

    public TeePrintStream(OutputStream mainStream, PrintStream secondStream) {
        super(mainStream, true);
        this.secondStream = secondStream;
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        super.write(buf, off, len);
        secondStream.write(buf, off, len);
    }

    @Override
    public void flush() {
        super.flush();
        secondStream.flush();
    }

    @Override
    public void close() {
        super.close();
        secondStream.close();
    }
}
