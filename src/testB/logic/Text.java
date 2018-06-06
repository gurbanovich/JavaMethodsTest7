package testB.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Text {
	/**
	 * The task: Create a text processing program textbook on programming using
	 * the classes: Symbol, Word, Sentence, Paragraph, Lexem, Listing,
	 * Punctuation, etc. In all tasks with the formation of text, replace tabs
	 * and sequences of spaces with one space.
	 */

	private String value;
	private List<Paragraph> paragraphs;

	public Text(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public List<Paragraph> getParagraphs() {
		paragraphs = new ArrayList<Paragraph>();
		String lineSeparator = System.getProperty("line.separator");
		for (String substr : getValue().split(lineSeparator)) {
			paragraphs.add(new Paragraph(substr));
		}
		return paragraphs;
	}

	public List<Sentence> getAllSentence() {
		List<Sentence> allSent = new ArrayList<Sentence>();
		paragraphs = getParagraphs();
		for (Paragraph par : paragraphs) {
			for (Sentence sent : par.getSentences()) {
				allSent.add(sent);
			}
		}
		return allSent;
	}

	public static Text createText(BufferedReader br) {
		StringBuffer sb = new StringBuffer();
		String s = new String();
		try {
			while (((s = br.readLine()) != null)) {
				sb.append(s);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.err.println("Stream exception!!!");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("Stream exception!!!");
			}
		}
		return new Text(sb.toString());
	}

	@Override
	public String toString() {
		return getValue();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		else if (!(o instanceof Text))
			return false;
		Text p = (Text) o;
		if (!getValue().equals(p.getValue()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}

}
