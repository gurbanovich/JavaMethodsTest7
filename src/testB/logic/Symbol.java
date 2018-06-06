package testB.logic;

public class Symbol {

	private char symbol;

	protected Symbol(char symbol) {
		this.symbol = symbol;
	}

	public Character getSymbol() {
		return symbol;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		else if (!(o instanceof Symbol))
			return false;
		Symbol s = (Symbol) o;
		if (!getSymbol().equals(s.getSymbol()))
			return false;
		return true;
	}

	public boolean equalsIgnoreCase(Object o) {
		if (this == o)
			return true;
		else if (!(o instanceof Symbol))
			return false;
		Symbol s = (Symbol) o;
		if (!getSymbol().toString().equalsIgnoreCase(s.getSymbol().toString()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return getSymbol().hashCode();
	}

	@Override
	public String toString() {
		return getSymbol().toString();
	}

}
