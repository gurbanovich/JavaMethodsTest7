package testA.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SymbolChanger {

	/**
	 * The task: In the text, each letter is replaced by its ordinal number in
	 * the alphabet. When output in one line print text with two spaces between
	 * letters, In the next line below, under each letter print its number.
	 */

	BufferedReader in;

	public SymbolChanger(String path) {
		try {
			this.in = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.err.println("Enter another path of file");
		}
	}

	public BufferedReader getIn() {
		return in;
	}

	private void printSymbols(final String line) {
		for (char symb : line.toCharArray()) {
			if (Character.isAlphabetic(symb))
				System.out.print(" " + symb + " ");
		}
		System.out.println();
	}

	private void printSymbolsNumbers(final String line) {
		for (char symb : line.toCharArray()) {
			if (Character.isAlphabetic(symb))
				System.out.print(((int) symb - (int) 'a' + 1) + "  ");
		}
		System.out.println();
	}

	private void streamClose(BufferedReader in) {
		try {
			in.close();
		} catch (IOException e) {
			System.err.println("Stream exception!!!");
		}
	}

	public void printLines() {
		String s = null;
		List<String> str = new ArrayList<String>();
		try {
			while ((s = getIn().readLine()) != null)
				str.add(s.toLowerCase());
			for (String line : str) {
				printSymbols(line);
				printSymbolsNumbers(line);
			}
		} catch (IOException e) {
			System.err.println("Stream exception!!!");
		} finally {
			streamClose(getIn());
		}
	}

}
