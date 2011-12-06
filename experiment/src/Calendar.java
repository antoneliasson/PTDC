/* Kontrollskrivning 3, 2010-12-13:
 * Uppgift 1
 */

public class Calendar {
	java.util.ArrayList<Event> events;
	String name;
	
	/** Skapar en tom kalender för användaren med namnet name */
	public Calendar(String name) {
		this.name = name;
		events = new java.util.ArrayList<Event>();
	}
	
	/** Tar reda på användarens namn */
	String getName() {
		return name;
	}
	
	/** Undersöker om användaren är ledig under dagen date under tiden startTime
	till finishTime. Returnerar då true, annars false */
	boolean isFree(String date, int startTime, int finishTime) {
		int low = 0, high = events.size();
		if (high > 0) {
			boolean found = false;
			while (!found) {
				int mid = high / low;
			}
		} else {
			return true; // inga events i kalendern
		}
	}
	
	/** Lägger in ett nytt möte (date,startTime,finishTime,info). Du kan
	förutsätta att användaren är ledig under denna tid */
	void insertEvent(String date, int startTime, int finishTime, String info);
}
