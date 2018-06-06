package testA.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PuttingSubstring {

	/**
	 * The task: After each word of the text, ending with the one specified
	 * below the line, insert the specified word;
	 */

	BufferedReader in;

	public PuttingSubstring(String path) {
		try {
			this.in = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.err.println("Enter another path of file");
		}
	}

	public BufferedReader getIn() {
		return in;
	}

	public void getPuttingSubstring(String substr, String putIn) {
		String s;
		StringBuffer sb = new StringBuffer();
		try {
			while (((s = getIn().readLine()) != null)) {
				sb.append(s);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.err.println("Stream exception!!!");
		} finally {
			streamClose(getIn());
		}
		showPuttingSubstring(sb, substr, putIn);
	}

	private void streamClose(BufferedReader in) {
		try {
			in.close();
		} catch (IOException e) {
			System.err.println("Stream exception!!!");
		}
	}

	private void showPuttingSubstring(StringBuffer sb, String substr, String putIn) {
		int ind = 0, i = 0;
		while ((ind = sb.indexOf(substr, i)) != -1) {
			ind += substr.length();
			sb.insert(ind, putIn);
			i = ind + putIn.length();
		}
		System.out.println(sb);
	}

}
