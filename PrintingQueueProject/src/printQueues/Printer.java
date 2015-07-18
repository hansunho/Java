package printQueues;

public class Printer {

	// current clock time. initialized to -1.
	int clockTime = -1;

	// current printRequest. initialized to null
	PrintRequest currentPrintReuqest = null;
	// number of processed pages of currentPrintReuqest. initialized to zero.
	int pageCounter = 0;

	public Printer() {
		super();
	}

	// a boolean printerIdle() method that returns true if the printer currently
	// is not processing a print request, and false if the printer is busy
	// processing a Print Request (i.e., the printer is printing a requested
	// file).
	public boolean printerIdle() {
		// if there currently is not a PrintRequest then printer is idle. return
		// true;
		if (currentPrintReuqest == null)
			return true;
		// otherwise return false since printer is busy
		else
			return false;

	}

	public boolean printFile(PrintRequest pr) {

		// if the printer is idle, the printer will start processing the given
		// print request, and the method returns true
		if (Printer.this.printerIdle() == true) {
			currentPrintReuqest = pr;
			return true;

		}
		// if the printer is already processing another Print Request, the new
		// Print Request pr is ignored, and the method returns false
		else
			return false;
	}

	// processForOneUnit() prints one page of the current print request
	public PrintRequest processForOneUnit() {

		// if the printer is idle, or if the current Print Request is NOT
		// completed
		// within 1 unit of time, then processForOneUnit returns null.
		if (Printer.this.printerIdle() == true)
			return null;

		else if (currentPrintReuqest.numOfPages - pageCounter > 1) {
			System.out.println("page number:" + (pageCounter + 1) + "/"
					+ currentPrintReuqest.numOfPages);
			// increment clocktime and pageCounter
			clockTime++;
			pageCounter++;
			return null;
		}

		// if the current Print Request is completed in the current time unit,
		// them method returns the current PrintRequest object that just
		// finished
		// printing.
		else if (currentPrintReuqest.numOfPages - pageCounter == 1) {
			System.out.println("page number:" + (pageCounter + 1) + "/"
					+ currentPrintReuqest.numOfPages);
			// After printing the last page rest pageCounter and
			// currentPrintReuqest, increment clockTime.
			pageCounter = 0;
			clockTime++;
			PrintRequest temp = currentPrintReuqest;
			currentPrintReuqest = null;
			// returns the current PrintRequest object that just finishes
			// printing.
			return temp;
		}

		else
			return null;

	}

	// getters and setters for clockTime
	public int getClockTime() {
		return clockTime;
	}

	public void setClockTime(int clockTime) {
		this.clockTime = clockTime;
	}

}
