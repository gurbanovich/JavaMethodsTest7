package testB.logic;

import java.util.ArrayList;
import java.util.List;

import testB.commons.SentenceObject;

public class Word implements SentenceObject {

	private String value;
	List<Symbol> symbols;

	public Word(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public List<Symbol> getSymbols() {
		symbols = new ArrayList<Symbol>();
		char[] arr = getValue().toCharArray();
		for (char c : arr) {
			symbols.add(new Symbol(c));
		}
		return symbols;
	}

	@Override
	public String toString() {
		return getValue();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		else if (!(o instanceof Word))
			return false;
		Word w = (Word) o;
		if (!getValue().equals(w.getValue()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}

}
