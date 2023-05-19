package blackjack.card;

public class Card {
	private String pattern;
	private String number;
	
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Card [pattern=" + pattern + ", number=" + number + "]";
	}
	
	

}
