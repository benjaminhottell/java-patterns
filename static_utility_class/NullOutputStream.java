import java.io.OutputStream;

public class NullOutputStream extends OutputStream {

	public NullOutputStream() {
	}

	@Override
	public void write(byte[] data) {
		// discard
	}

	@Override
	public void write(byte[] data, int off, int len) {
		// discard
	}

	@Override
	public void write(int b) {
		// discard
	}

}

