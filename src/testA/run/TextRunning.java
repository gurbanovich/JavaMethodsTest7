package testA.run;

import testA.logic.PuttingSubstring;
import testA.logic.SymbolChanger;

public class TextRunning {

	public static void main(String[] args) {
		/**
		 * Demo classes SymbolChanger and PuttingSubstring
		 */

		SymbolChanger sc = new SymbolChanger(args[0]);
		PuttingSubstring ps = new PuttingSubstring(args[0]);

		// Showing the text, each letter is replaced by its ordinal number in
		// the alphabet. When output in one line print text with two spaces
		// between
		// letters, In the next line below, under each letter print its number.
		sc.printLines();

		// Showing the text after each words, ending with the one specified
		// below the line, insert the specified word;
		ps.getPuttingSubstring("ing ", "INSERT ");

	}
}
