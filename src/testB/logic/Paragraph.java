package testB.logic;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {

	private String value;
	private List<Sentence> sentences;

	public Paragraph(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public List<Sentence> getSentences() {
		List<Character> buff = new ArrayList<Character>();
		sentences = new ArrayList<Sentence>();
		for (Character ch : getValue().toCharArray()) {
			buff.add(ch);
			if (Punctuation.isPunctuation(ch) && new Punctuation(ch).getEndOfSentence() == true) {
				Character[] sentC = buff.toArray(new Character[0]);
				StringBuffer sb = new StringBuffer();
				for (Character symb : sentC) {
					sb.append(symb);
				}
				String sent = sb.toString();
				sentences.add(new Sentence(sent));
				buff.clear();
			}
		}
		return sentences;
	}

	@Override
	public String toString() {
		return getValue();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		else if (!(o instanceof Paragraph))
			return false;
		Paragraph p = (Paragraph) o;
		if (!getValue().equals(p.getValue()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}

}
