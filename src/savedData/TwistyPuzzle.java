package savedData;

import java.util.ArrayList;

import fields.Constants;
import fields.TwistyPuzzleType;

public class TwistyPuzzle {

	private TwistyPuzzleType twistyPuzzleType;
	private ArrayList<Time> times;
	private ArrayList<Double> last5SolvesForAvarageOf5;
	private String avarageOf5;
        private int scrambleLength;

	public TwistyPuzzle(TwistyPuzzleType twistyPuzzleTypeIn) {

		twistyPuzzleType = twistyPuzzleTypeIn;
		times = new ArrayList<Time>();
		avarageOf5 = "No Avarage Of 5 Yet";

                if(twistyPuzzleType == TwistyPuzzleType.megaMinx){
                    scrambleLength = Constants.megaMinxDefaultScrambleLength;
                }
                else{
                    scrambleLength = Constants.defaultScrambleLength;
                }
	}

        public int getScrambleLength(){
            return scrambleLength;
        }
     
        public void setScrambleLength(int scrambleLengthIn){
            scrambleLength = scrambleLengthIn;
        }

	public TwistyPuzzleType getTwistyPuzzleType() {

		return twistyPuzzleType;
	}

	public ArrayList<Time> getTimes() {

		return times;
	}

	public Time getTime(int index) {

		return times.get(index);
	}

	public void setTime(int index, Time time) {

		times.set(index, time);
	}

	public void addTime(Time time) {

		times.add(time);

		while (times.size() > 20) {
			times.remove(0);
		}
	}

	public void removeFirstElementInTimes() {

		times.remove(0);
	}

	public void removeTime(double time) {

		times.remove(time);
	}

	public int getSize() {

		return times.size();
	}

	private ArrayList<Double> getLast5Times() {

		ArrayList<Double> last5Times = new ArrayList<Double>();
		int timesSize = times.size();

		if (timesSize >= 5) {

			last5Times.add(times.get(timesSize - 1).getFinalValue());
			last5Times.add(times.get(timesSize - 2).getFinalValue());
			last5Times.add(times.get(timesSize - 3).getFinalValue());
			last5Times.add(times.get(timesSize - 4).getFinalValue());
			last5Times.add(times.get(timesSize - 5).getFinalValue());
		}

		return last5Times;

	}

	public void setLastAvarageOf5() {

		last5SolvesForAvarageOf5 = getLast5Times();

		double minimum;
		double maximum;
		double sumForAvarageOf5 = 0.0;
		double avarageOf5Seconds;

		if (last5SolvesForAvarageOf5.size() > 0) {

			if (last5SolvesForAvarageOf5.contains(0.0)) {
				maximum = 0.0;
			}

			else {

				maximum = last5SolvesForAvarageOf5.get(0);

				for (int i = 1; i < last5SolvesForAvarageOf5.size(); i++) {
					if (maximum < last5SolvesForAvarageOf5.get(i)) {
						maximum = last5SolvesForAvarageOf5.get(i);
					}
				}
			}

			last5SolvesForAvarageOf5.remove(maximum);

			if (last5SolvesForAvarageOf5.contains(0.0)) {
				avarageOf5 = "DNF";
			}

			minimum = last5SolvesForAvarageOf5.get(0);

			for (int i = 1; i < last5SolvesForAvarageOf5.size(); i++) {

				if (minimum > last5SolvesForAvarageOf5.get(i)) {
					minimum = last5SolvesForAvarageOf5.get(i);
				}
			}
			last5SolvesForAvarageOf5.remove(minimum);

			for (int i = 0; i < last5SolvesForAvarageOf5.size(); i++) {
				sumForAvarageOf5 = sumForAvarageOf5
						+ last5SolvesForAvarageOf5.get(i);
			}

			avarageOf5Seconds = sumForAvarageOf5 / 3;

			int timeMinutes = 0;

			while (avarageOf5Seconds > 60) {

				timeMinutes++;
				avarageOf5Seconds = avarageOf5Seconds - 60;
			}
			avarageOf5 = Integer.toString(timeMinutes) + ":"
					+ String.format("%.2f", avarageOf5Seconds);
		}

		else {
			avarageOf5 = "No Avarage Of 5 Yet";
		}
	}

	public void removeLastTime() {

		if (times.size() > 0) {
			times.remove(times.size() - 1);
		}

	}
	
	public Time getLastTime(){
		
		return times.get(times.size() - 1);
	}

	public ArrayList<String> getAllSolves() {

		ArrayList<String> allSolves = new ArrayList<String>();

		for (int i = 0; i < times.size(); i++) {

			allSolves.add(times.get(i).getDisplayTime());
		}

		return allSolves;
	}
	
	public String getAvarageOf5(){
		
		return avarageOf5;
	}
}
