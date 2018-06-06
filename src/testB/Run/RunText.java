package testB.Run;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import testB.commons.SentenceObject;
import testB.comparators.SentenceComparator;
import testB.comparators.WordComparator;
import testB.logic.Sentence;
import testB.logic.Text;
import testB.logic.Word;

public class RunText {
	/**
	 * The task: 
	 * 2. Output all sentences of the given text in ascending order of
	 * the number of words in each of them. 
	 * 5. In each sentence of the text swap
	 * the first word with the last, without changing the length of the
	 * sentence. 
	 * 6. Type the words of the text in alphabetical order by the
	 * first letter. Words beginning with a new letter are printed from the red
	 * line.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			System.err.println("File not found, please enter enother path");
		}
		Text myText = Text.createText(in);
		List<SentenceObject> soList = new ArrayList<SentenceObject>();
		List<Word> words = new ArrayList<Word>();
		List<Sentence> allSent = myText.getAllSentence();

		// Showing start text
		System.out.println(myText.toString());

		// Showing task 2
		System.out.println();
		System.out.println("Text after sorting by sentence length: ");
		Collections.sort(allSent, new SentenceComparator());
		for (Sentence sent : allSent)
			System.out.println(sent.toString());

		// Showing task 5
		System.out.println();
		System.out.println("Text after changing the first and the last words in sentences: ");
		for (Sentence sent : allSent) {
			Word wFirst = null, wLast = null;
			int indexFirst = 0, indexLast = 0;
			soList = sent.getTokens();
			for (SentenceObject so : soList) {
				if (so instanceof Word) {
					indexFirst = soList.indexOf(so);
					wFirst = (Word) so;
					break;
				}
			}
			for (int i = soList.size() - 1; i >= 0; i--) {
				SentenceObject so;
				if ((so = soList.get(i)) instanceof Word) {
					indexLast = i;
					wLast = (Word) so;
					break;
				}
			}
			soList.set(indexFirst, wLast);
			soList.set(indexLast, wFirst);
			System.out.print("\n");
			for (SentenceObject sentt : soList)
				System.out.print(sentt.toString() + " ");
		}

		// Showing task 6
		System.out.println();
		System.out.println("All words after sorting by alphabet of the first letter: ");
		for (Sentence sent : allSent) {
			for (Word w : sent.getWords()) {
				words.add(w);
			}
		}

		Collections.sort(words, new WordComparator());
		for (int i = 0; i <= words.size() - 1; i++) {
			if ((i - 1 >= 0)
					&& (!words.get(i).getSymbols().get(0).equalsIgnoreCase(words.get(i - 1).getSymbols().get(0))))
				System.out.println("\u0009");
			System.out.print(words.get(i) + " ");
		}

	}

}
