package fields;


public class Penalty{
	
	private int timePenalty;
	private boolean DNF;
	
	public Penalty(){
		
		setTimePenalty(0);
		setDNF(false);
	}

	public boolean getDNF() {
		return DNF;
	}

	public void setDNF(boolean DNFIn) {
		DNF = DNFIn;
	}

	public int getTimePenalty() {
		return timePenalty;
	}

	public void setTimePenalty(int timePenaltyIn) {
		timePenalty = timePenaltyIn;
	}
	
}
