package testB.logic;

import testB.commons.SentenceObject;

public class Punctuation extends Symbol implements SentenceObject{

	    private boolean endOfSentence;

	    public Punctuation(char symbol) {
	    	super(symbol);
	    	if(symbol=='.' || symbol=='?'|| symbol=='!')
	    		endOfSentence=true;
	    }
	    
	    public boolean getEndOfSentence() {
	    	return endOfSentence;
	    }

	    public static boolean isPunctuation(char c) {
	    	if(!Character.isLetter(c)) {
	    		return true;
	    	} else
	    		return false;
	    }
	    
	    public static Punctuation create(char c) {
	    	if(isPunctuation(c))
	    		return new Punctuation(c);
	    	else
	    		return null;
	    }	    
	}
