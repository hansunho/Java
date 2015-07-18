package printQueues;

public class PrintRequest {

	// number of pages for this print request
	int numOfPages;
	// the clock time when the user submitted a print request
	int Time;

	public PrintRequest(int printSize, int time) {
		super();
	
		numOfPages = printSize;
		Time = time;
	}

	// getters and setters for the fields
	

	public int getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}

	public int getTime() {
		return Time;
	}

	public void setTime(int time) {
		Time = time;
	}
	

}
