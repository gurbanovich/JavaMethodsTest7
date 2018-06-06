package testB.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import testB.commons.SentenceObject;

public class Sentence implements Iterable<SentenceObject> {

	private String value;
	private List<SentenceObject> tokens;

	public Sentence(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public List<SentenceObject> getTokens() {
		char chF, chL;
		tokens = new ArrayList<SentenceObject>();
		for (String substr : getValue().split(" ")) {
			if (substr.length() - 1 > 0) {
				chL = substr.charAt(substr.length() - 1);
				chF = substr.charAt(0);
				if(Punctuation.isPunctuation(chF)) {
					tokens.add(new Punctuation(chF));
					substr=substr.substring(1);
				}
				if (Punctuation.isPunctuation(chL)) {
					tokens.add(new Word(substr.substring(0, substr.length() - 1)));
					tokens.add(new Punctuation(chL));
				} else
					tokens.add(new Word(substr));
			}
		}
		return tokens;
	}

	public List<Word> getWords() {
		List<Word> words = new ArrayList<Word>();
		for (SentenceObject so : getTokens()) {
			if (so instanceof Word)
				words.add((Word) so);
		}
		return words;
	}

	@Override
	public String toString() {
		return getValue();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		else if (!(o instanceof Sentence))
			return false;
		Sentence w = (Sentence) o;
		if (!getValue().equals(w.getValue()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}

	@Override
	public Iterator<SentenceObject> iterator() {
		return tokens.iterator();
	}

}
