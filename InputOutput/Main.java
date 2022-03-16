import java.util.*;
import java.io.*;

public class Main {
	public static void readFully(InputStream is, byte[] b) throws IOException {
		int offset = 0;
		while(offset < b.length) {
			int count = is.read(b, offset, b.length - offset);
			if(count == -1) 
				throw new IOException("Stream has less bytes than " + b.length);
			offset += count;
		}
	}

	public static void main(String... args) throws IOException{
		byte[] b = new byte[10];
		readFully(System.in, b);
		System.out.println(Arrays.toString(b));
	}
}
