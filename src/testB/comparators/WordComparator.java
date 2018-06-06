package testB.comparators;

import java.util.Comparator;

import testB.logic.Word;

public class WordComparator implements Comparator<Word> {

	@Override
	public int compare(Word w1, Word w2) {
		return w1.toString().compareToIgnoreCase(w2.toString());
	}

}
