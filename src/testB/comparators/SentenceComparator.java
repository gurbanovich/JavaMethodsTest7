package testB.comparators;

import java.util.Comparator;
import java.util.List;

import testB.logic.Sentence;
import testB.logic.Word;

public class SentenceComparator implements Comparator<Sentence> {

	@Override
	public int compare(Sentence s1, Sentence s2) {
		List<Word> w1 = s1.getWords();
		List<Word> w2 = s2.getWords();
		return Integer.compare(w1.size(), w2.size());
	}

}
