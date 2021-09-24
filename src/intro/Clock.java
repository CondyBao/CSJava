package intro;

public class Clock {

	private int time;
	// create your methods here

	public void setTime(int t) {
		time = t;
	}

	public void tick() {
		time = (time + 1) % 60;
	}

	public void displayTime() {
		System.out.println(time);
	}

	public static void main(String[] args) {
		Clock tester = new Clock();
		
		// should display the time to be 56, 57, 58, 59, 0, 1, etc.

		tester.setTime(56);
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
	}
}