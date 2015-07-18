package printQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import queues.Queues;

public class Simulation {

	// probability that some user will make a print request in a single time
	// interval
	static double requestProb;

	// number n of queues to be used
	static int queueNum;

	// number k of dequeue operations from one queue before an item from a
	// lower-priority queue is promoted
	static int dequeueNum;

	// algorithm ("A", "B", or "C" from the problem) for determining how the
	// operating
	// system will decide which queue will be used for a user's print request.
	static String algorithm;

	// create an array of Queues<PrintRequest>
	Queues<PrintRequest>[] queue;

	// starting time of current print request;
	int startTime;;

	// total wait time for a print request

	int totalTime;

	// http://stackoverflow.com/questions/7961788/math-random-explained
	// generates an integer between 1 and 100 for number of pages to print
	public int randomPageNumber() {
		return (int) Math.ceil(Math.random() * 100);

	}

	// Based on random number generator and the user given probability
	// requestProb
	// return true if a new request should be made,return false otherwise.
	public boolean newRequest() {
		if (Math.random() < requestProb)
			return true;
		else
			return false;
	}

	// returns true if there is no more pending print Queue or false otherwise
	public boolean printQueueEmpty(Queues<PrintRequest>[] qArray) {

		int i = 0;

		while (i <= qArray.length - 1 && qArray[i].size() == 0) {
			i++;

		}

		if (i == qArray.length)
			return true;
		else
			return false;

	}

	// looks for and returns the next item to be processed
	public PrintRequest nextItem(Queues<PrintRequest>[] qArray) {

		if (printQueueEmpty(qArray))
			return null;

		int i = 0;

		// loop and look for the first item in order. look for until it has
		// checked the whole array if needed.
		while (qArray[i].size() < 1 && i < qArray.length - 1) {
			i++;
		}

		// next PrintRequest to be sent to the printer and processed
		PrintRequest prTemp = qArray[i].dequeue();

		// if this k number of dequeues will have been called after
		// qArray[i] is dequeue
		if (dequeueNum % qArray[i].getNumDequeue() == 0
				&& i < qArray.length - 1)
			if ((qArray[i + 1].size() > 0)) {

				qArray[i].enqueue(qArray[i + 1].dequeue());

			}

		// return either the next item in order
		return prTemp;
	}

	// where to place received print request in the correct queue according to
	// the
	// algorithm B given in the problem
	public int printRequestAssignB(PrintRequest pr) {

		// which number in the array to be stored in for this print request.So
		// this print request gets enqueued in array[arrayNumber]
		int arrayNumber = (pr.numOfPages - 1) / 10;

		if (arrayNumber > queueNum - 1)
			return queueNum - 1;
		else
			return arrayNumber;

	}

	// where to place received print request in the correct queue according to
	// the algorithm C given in the problem : print request for a file of size i
	// is initially assigned to queue qi%n.
	public int printRequestAssignC(PrintRequest pr) {

		return pr.numOfPages % queueNum;

	}

	public void algorithmC() {
		// the maximum waiting time for any Print Request
		int maxWaitTime = 0;

		// the sum of waiting time for all processed Print Requests
		int sumWaitTime = 0;

		// number of total print jobs done;
		int requestTotal = 0;

		// create an array of Queues<PrintRequest> size of queueNum(not
		// necessary since algorithmA puts all PrintRequests in one queue
		queue = new Queues[queueNum];
		for (int i = 0; i < queueNum; i++)
			queue[i] = new Queues<PrintRequest>();

		// create a new Printer object
		Printer printer = new Printer();

		// print and take Print Requests until clock hits 999
		while (printer.getClockTime() < 1000) {

			// if printer is in use, print one page of the current job
			if (!printer.printerIdle()) {
				// store starting time of current print request;
				startTime = printer.currentPrintReuqest.getTime();

				printer.processForOneUnit();

			}
			// if printer is idle
			else {

				// and if there is at least one print request pending,
				// update maxWaitTime and
				// sumWaitTime

				if (!printQueueEmpty(queue)) {
					PrintRequest temporary = nextItem(queue);
					totalTime = printer.getClockTime() - startTime;
					if (totalTime > maxWaitTime)
						maxWaitTime = totalTime;
					sumWaitTime = sumWaitTime + totalTime;

					// start printing next request
					printer.printFile(temporary);
				}
			}

			// send a new PrintRequest at the probability of the user given
			// probability requestProb
			if (newRequest()) {

				// create a random printRequest
				PrintRequest tempPrintRequest = new PrintRequest(
						randomPageNumber(), printer.getClockTime());

				// insert the newly created printrequest into the appropirate
				// queue
				queue[printRequestAssignC(tempPrintRequest)]
						.enqueue(tempPrintRequest);
				// update the total number of print requests
				requestTotal++;

			}

		}

		// stop taking new print requests, but finish all of the pending
		// requests
		while (!printQueueEmpty(queue) || !printer.printerIdle()) {

			// if printer is in use, print one page of the current job
			if (!printer.printerIdle()) {
				// store starting time of current print request;
				startTime = printer.currentPrintReuqest.getTime();

				printer.processForOneUnit();

			}
			// if printer is idle
			else {

				// and if there is at least one print request pending,
				// update maxWaitTime and
				// sumWaitTime

				PrintRequest temporary = nextItem(queue);
				if (temporary != null) {
					totalTime = printer.getClockTime() - startTime;
					if (totalTime > maxWaitTime)
						maxWaitTime = totalTime;
					sumWaitTime = sumWaitTime + totalTime;

					// start printing next request
					printer.printFile(temporary);
				}
			}
		}
		// When all print quests have been processed, print maxWaitTime and
		// averageWaitTime

		System.out.println("maximum waiting time for any print request: "
				+ maxWaitTime);
		System.out
				.println("average waiting time for all processed print requests: "
						+ sumWaitTime / requestTotal);

		System.out.println("number of print jobs: " + requestTotal);

	}

	public void algorithmA() {

		// the maximum waiting time for any Print Request
		int maxWaitTime = 0;

		// the sum of waiting time for all processed Print Requests
		int sumWaitTime = 0;

		// number of total print jobs done;
		int requestTotal = 0;

		// create an array of Queues<PrintRequest> size of queueNum(not
		// necessary since algorithmA puts all PrintRequests in one queue
		queue = new Queues[queueNum];
		for (int i = 0; i < queueNum; i++)
			queue[i] = new Queues<PrintRequest>();

		// create a new Printer object
		Printer printer = new Printer();

		// print and take print requests until clock hits 999
		while (printer.getClockTime() < 1000) {

			// if printer is in use, print one page of the current job
			if (!printer.printerIdle()) {
				// store starting time of current print request;
				startTime = printer.currentPrintReuqest.getTime();

				printer.processForOneUnit();

			}
			// if printer is idle
			else {
				// and if there is at least one print request pending,
				if (queue[0].size() > 0) { // update maxWaitTime and
											// sumWaitTime
					totalTime = printer.getClockTime() - startTime;
					if (totalTime > maxWaitTime)
						maxWaitTime = totalTime;
					sumWaitTime = sumWaitTime + totalTime;

					// start printing next request
					printer.printFile(queue[0].dequeue());
				}
			}

			// send a new PrintRequest at the probability of the user given
			// probability requestProb
			if (newRequest()) {
				queue[0].enqueue(new PrintRequest(randomPageNumber(), printer
						.getClockTime()));
				// update the total number of print requests
				requestTotal++;
			}

		}
		// stop taking new print requets, but finish all of the pending requests
		while (queue[0].size() > 0) {

			// if printer is in use, print one page of the current job
			if (!printer.printerIdle()) {
				// starting time of current print request;
				startTime = printer.currentPrintReuqest.getTime();

				printer.processForOneUnit();
			}
			// if printer is idle
			else {
				// and if there is at least one print request pending,
				if (queue[0].size() > 0) { // update maxWaitTime and
											// sumWaitTime
					totalTime = printer.getClockTime() - startTime;
					if (totalTime > maxWaitTime)
						maxWaitTime = totalTime;
					sumWaitTime = sumWaitTime + totalTime;

					// start printing next request
					printer.printFile(queue[0].dequeue());
				}
			}

		}

		// When all print quests have been processed, print maxWaitTime and
		// averageWaitTime

		System.out.println("maximum waiting time for any print request: "
				+ maxWaitTime);
		System.out
				.println("average waiting time for all processed print requests: "
						+ sumWaitTime / requestTotal);

		System.out.println("number of print jobs: " + requestTotal);

	}

	public void algorithmB() {
		// the maximum waiting time for any Print Request
		int maxWaitTime = 0;

		// the sum of waiting time for all processed Print Requests
		int sumWaitTime = 0;

		// number of total print jobs done;
		int requestTotal = 0;

		// create an array of Queues<PrintRequest> size of queueNum(not
		// necessary since algorithmA puts all PrintRequests in one queue
		queue = new Queues[queueNum];
		for (int i = 0; i < queueNum; i++)
			queue[i] = new Queues<PrintRequest>();

		// create a new Printer object
		Printer printer = new Printer();

		// print and take Print Requests until clock hits 999
		while (printer.getClockTime() < 1000) {

			// ///////////////////////////////////////////////
			System.out.println(printer.getClockTime());

			// if printer is in use, print one page of the current job
			if (!printer.printerIdle()) {
				// store starting time of current print request;
				startTime = printer.currentPrintReuqest.getTime();

				printer.processForOneUnit();

			}
			// if printer is idle
			else {

				// and if there is at least one print request pending,
				// update maxWaitTime and
				// sumWaitTime

				if (!printQueueEmpty(queue)) {
					PrintRequest temporary = nextItem(queue);
					totalTime = printer.getClockTime() - startTime;
					if (totalTime > maxWaitTime)
						maxWaitTime = totalTime;
					sumWaitTime = sumWaitTime + totalTime;

					// start printing next request
					printer.printFile(temporary);
				}
			}

			// send a new PrintRequest at the probability of the user given
			// probability requestProb
			if (newRequest()) {

				// create a random printRequest
				PrintRequest tempPrintRequest = new PrintRequest(
						randomPageNumber(), printer.getClockTime());

				// insert the newly created printrequest into the appropirate
				// queue
				queue[printRequestAssignB(tempPrintRequest)]
						.enqueue(tempPrintRequest);
				// update the total number of print requests
				requestTotal++;

			}

		}

		// stop taking new print requests, but finish all of the pending
		// requests
		while (!printQueueEmpty(queue) || !printer.printerIdle()) {

			// if printer is in use, print one page of the current job
			if (!printer.printerIdle()) {
				// store starting time of current print request;
				startTime = printer.currentPrintReuqest.getTime();

				printer.processForOneUnit();

			}
			// if printer is idle
			else {

				// and if there is at least one print request pending,
				// update maxWaitTime and
				// sumWaitTime

				PrintRequest temporary = nextItem(queue);
				if (temporary != null) {
					totalTime = printer.getClockTime() - startTime;
					if (totalTime > maxWaitTime)
						maxWaitTime = totalTime;
					sumWaitTime = sumWaitTime + totalTime;

					// start printing next request
					printer.printFile(temporary);
				}
			}
		}
		// When all print quests have been processed, print maxWaitTime and
		// averageWaitTime

		System.out.println("maximum waiting time for any print request: "
				+ maxWaitTime);
		System.out
				.println("average waiting time for all processed print requests: "
						+ sumWaitTime / requestTotal);

		System.out.println("number of print jobs: " + requestTotal);

	}

	// http://www.java-tips.org/java-se-tips/java.util/how-to-read-input-from-console.html
	// for command line input help)
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// create a new simulation object
		Simulation sim = new Simulation();

		// Reads a single line from the console and stores into requestProb
		// variable
		System.out.println("Enter requestProb(double between 0 and 1): ");
		sim.requestProb = Double.parseDouble(in.nextLine());

		// Reads a single line from the console and stores into queueNum
		// variable
		System.out.println("Enter queueNum(integer): ");
		sim.queueNum = Integer.parseInt(in.nextLine());

		// Reads a single line from the console and stores into dequeueNum
		// variable
		System.out.println("Enter dequeueNum (integer): ");
		sim.dequeueNum = Integer.parseInt(in.nextLine());

		// Reads a single line from the console and stores into algorithm
		// variable
		System.out.println("Enter algorithm (A,B,or C): ");
		sim.algorithm = in.nextLine();

		// depending on which algorithm user uses, call that method accordingly.
		if (algorithm.compareTo("A") == 0) {
			sim.algorithmA();
		}

		else if (algorithm.compareTo("B") == 0) {
			sim.algorithmB();

		} else if (algorithm.compareTo("C") == 0) {
			sim.algorithmC();
		}

		System.out.println("requestProb:" + requestProb + " queueNum: "
				+ queueNum + " dequeueNum: " + dequeueNum + " algorithm: "
				+ algorithm);

	}
}
