package textfile_Reader;

//http://www.cs.grinnell.edu/~walker/courses/207.fa14/readings/reading-input.shtml (TestScanner2.java)
//

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// file is located in /home/walker/207/data-sets/us-cities.dat

public class Reader {

	public static void main(String args[]) throws FileNotFoundException {

		// use System.in to initialize
		// scanner
		Scanner fileIn = new Scanner(System.in);

		//receive location of data file to be processed and store that string in String testFile.
		System.out.println("Enter location of data file");
		String testFile = fileIn.nextLine();

		// set up file reader for given data file
		FileReader fileReaderIn = new FileReader(testFile);
		// use FileReader object to initialize scanner
		fileIn = new Scanner(fileReaderIn);

		// String cityWithLargestCellphone stores a city that has the
		// greatest number of cellphones per capita. initially null
		String cityWithLargestCellphone = null;
		// double largestTelephonePerCapita stores amount of telephones per
		// capita of the city with the greatest number of cellphones per
		// capita. initially zero;
		double largestTelephonePerCapita = 0;

		// String cityWithHighestPopulationDensity stores a city that has
		// the greatest population densitiy(= population / area). initially
		// null
		String cityWithHighestPopulationDensity = null;
		// double highestPopulationDensity stores population density of the
		// city with the greatest population density. initially zero;
		double highestPopulationDensity = 0;

		// String city once the city part of String is extracted from the
		// file, store in String city.
		String city = null;
		// double population stores population of city extracted from the
		// file
		double population = 0;
		// double area stores area of city extracted from the file.
		double area = 0;
		// double stores number of telephones of city extracted from the
		// file.
		double telephone = 0;

		// double telephonePerCapita stores telephone per capita calculated
		// by telephone/population
		double telephonePerCapita = 0;
		// double populationDensity stores population density calculated by
		// population/area
		double populationDensity = 0;

		// while file has next line in the file, loop continues.
		while (fileIn.hasNextLine()) {
			// first line of each entry is city, store city name in String
			// city;
			city = fileIn.nextLine();

			// Second line of Entry is Country, county is not used for this
			// problem. So skip this line without storing data.
			fileIn.nextLine();

			// Third line of Entry is state, state is not used for this
			// problem. So skip this line without storing data.
			fileIn.nextLine();

			// Fourth line of Entry includes established year of city,
			// population of city, and Area of city with each part seperated
			// by white space. Established year is not used for this
			// problem. So skip this String without storing data (still in
			// the same line: line 4 of entry).
			fileIn.next();

			// Second String of the fourth line is population of the city,
			// population is used for this problem, store the data in
			// population after changing type String to Double. So it can be
			// used for finding number of telephones per capita and
			// population density. (Still in the same line: line 4 of entry)

			population = Double.parseDouble(fileIn.next());

			// Third String of the fourth line is area of the city, and area
			// is used to find the population density. So store the data in
			// area after changing type String to Double. So it can be
			// used for finding population density

			area = Double.parseDouble(fileIn.next());

			// fifth line of Entry is number of telephones in the city,
			// number of telephones is used in finding number of telephones
			// per capita. So store this data in telephone. so it can be
			// used for finding telephones per capita

			telephone = Double.parseDouble(fileIn.next());

			// sixth line of Entry is number of radios in the city, number
			// of radios is not used for this problem. So skip this line
			// without storing data.
			fileIn.next();

			// seventh line of Entry is a number of television stations in
			// the city,number
			// of television stations is not used for this problem. So skip
			// this line
			// without storing data.
			fileIn.nextLine();

			// skip lines to avoid the blank space between each entry
			fileIn.nextLine();
			fileIn.nextLine();

			// telephonePerCapita: average number of telephones owned by a
			// person in the city calculated by number of telephones divded
			// by population
			telephonePerCapita = telephone / population;
			// populationDensity: measurement of popoulation per unit area
			// calculated by population divided by area
			populationDensity = population / area;

			// After each entry(city) has been completed, compare that
			// city's telephone Per Capita with that of the largest. If it
			// returns true, replace cityWithLargestCellphone and
			// largestTelephonePerCapita.
			if (cityWithLargestCellphone == null
					|| telephonePerCapita > largestTelephonePerCapita) {
				cityWithLargestCellphone = city;
				largestTelephonePerCapita = telephonePerCapita;
			}
			// After each entry(city) has been completed, compare that
			// city's population density with that of the largest. If it
			// returns true, replace cityWithHighestPopulationDensity and
			// highestPopulationDensity.
			if (cityWithHighestPopulationDensity == null
					|| populationDensity > highestPopulationDensity) {
				cityWithHighestPopulationDensity = city;
				highestPopulationDensity = populationDensity;
			}

			// print city, telephonePerCapita, populationDensity of each city so
			// user can see the values being compared.
			// System.out.println("City: " + city);
			// System.out.println("telephonePerCapita: " + telephonePerCapita);
			// System.out.println("populationDensity: " + populationDensity);
			// System.out.println("\n");
		}

		System.out
				.println("city with the largest number of telephones per capita: "
						+ cityWithLargestCellphone);
		System.out.println("city with the highest population density: "
				+ cityWithHighestPopulationDensity);

	}

}