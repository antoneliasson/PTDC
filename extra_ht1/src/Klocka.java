import se.lth.cs.ptdc.window.SimpleWindow;

public class Klocka {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "Klocka");
		java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
		
		int hour = cal.get(java.util.Calendar.HOUR);
		int minute = cal.get(java.util.Calendar.MINUTE);
		int second = cal.get(java.util.Calendar.SECOND);
		
		Visare hourHand = new Visare(w, java.awt.Color.BLACK, 300, 300, 50, 12, hour),
				minuteHand = new Visare(w, java.awt.Color.RED, 300, 300, 100, 60, minute),
				secondHand = new Visare(w, java.awt.Color.GREEN, 300, 300, 200, 60, second);
		
		while (true) {
			w.clear();
			hourHand.draw();
			minuteHand.draw();
			secondHand.draw();
			SimpleWindow.delay(1000);
			
			if (secondHand.increment()) { // öka sekunder, om överslag...
				if (minuteHand.increment()) { // ...öka minuter, om överslag...
					hourHand.increment(); // ...öka timmar
				}
			}
			System.out.println(hourHand.getValue() + ":" + minuteHand.getValue() + ":" + secondHand.getValue());
		}
	}
}