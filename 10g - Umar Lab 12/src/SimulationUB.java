import java.text.DecimalFormat;
import java.util.Arrays;

public class SimulationUB {
	// decimal formaters used for getting a good decimal format
	static DecimalFormat df = new DecimalFormat("0.00");
	static DecimalFormat df2 = new DecimalFormat("#");
	
	public static void main(String[] args) {
		int SIZE;
		double cityCounter, fwyCounter, tossUp, percCity, percFwy, percTossUp;
		
		final double hrsMin = 60;

		// distance arrays, used initialization lists used
		double [] freewaySegment = {4.7, 5.3}; 
		double [] citySegment = {3.4, 4.1, 2.5};
		
		// speed arrays declared
		int [] freewaySpeed = new int [2];
		int [] citySpeed = new int[2];
		
		// city speed and time arrays
		int [] sc1;	double [] tc1;
		int [] sc2;	double [] tc2;
		int [] sc3;	double [] tc3;
		
		// fwy speed and time arrays
		int [] sf1;	double [] tf1;
		int [] sf2;	double [] tf2;
		
		// time city and freeway array
		double [] Tcity;	double [] Tfwy;

		// ask user for amt simulation (array size)
		SIZE = UtilsUB.readInt("How many simulation iterations? ", false);
		
		// ask user for max min speed fwy
		freewaySpeed[1] = UtilsUB.readInt("Average freeway speed (min)? ", false);
		freewaySpeed[0] = UtilsUB.readInt("Average freeway speed (max)? ", false);
		
		// ask user for max min speed city
		citySpeed[1] = UtilsUB.readInt("Average city speed (min)? ", false);
		citySpeed[0] = UtilsUB.readInt("Average city speed (max)? ", false);
		
		// initial data set
		cityCounter = 0;
		fwyCounter = 0;
		tossUp = 0;
		
		// set array SIZE
		sc1 = new int[SIZE];	tc1 = new double[SIZE];
		sc2 = new int[SIZE];	tc2 = new double[SIZE];
		sc3 = new int[SIZE];	tc3 = new double[SIZE];
		
		sf1 = new int[SIZE];	tf1 = new double[SIZE];
		sf2 = new int[SIZE];	tf2 = new double[SIZE];
		
		Tcity = new double[SIZE];	Tfwy = new double[SIZE];
		
		System.out.println();
		
		// loop for giving values to arrays
		for (int i = 0; i < SIZE; i++){
			
			// random speed for all 3 city segments
			sc1[i] = UtilsUB.randomInt(citySpeed[1], citySpeed[0]);
			sc2[i] = UtilsUB.randomInt(citySpeed[1], citySpeed[0]);
			sc3[i] = UtilsUB.randomInt(citySpeed[1], citySpeed[0]);
			
			// random speeds for all 2 city segments
			sf1[i] = UtilsUB.randomInt(freewaySpeed[1], freewaySpeed[0]);
			sf2[i] = UtilsUB.randomInt(freewaySpeed[1], freewaySpeed[0]);
			
			// time for all 3 city segments
			tc1[i] = (citySegment[0] / sc1[i]) * hrsMin;
			tc2[i] = (citySegment[1] / sc1[i]) * hrsMin;
			tc3[i] = (citySegment[2] / sc1[i]) * hrsMin;
			
			// time for both fwy segments
			tf1[i] = (freewaySegment[0] / sf1[i]) * hrsMin;
			tf2[i] = (freewaySegment[1] / sf2[i]) * hrsMin;
			
			// total time for all segments combined
			Tcity[i] = tc1[i] + tc2[i] + tc3[i];
			Tfwy[i] = tf1[i] + tf2[i];
			
			// counter for which is faster
			if (Tcity[i] > Tfwy[i]){
				fwyCounter++;
			}
			else if (Tcity[i] < Tfwy[i]){
				cityCounter++;
			}
			else if (Tcity[i] == Tfwy[i]){
				tossUp++;
			}
			
			// print out iteration number
			System.out.println("performing simulation for iteration: " + (i + 1) + "...");
		}
		
		// print outs for iteration table
		System.out.println();
		System.out.println("=========================================================");
		System.out.println("  TRAFFIC SIMULATION FOR " + SIZE + " ITERATIONS");
		System.out.println("=========================================================");

		System.out.println();
		System.out.println("  ###  sc1    tc1  sc2    tc2  sc3    tc3     sf1    tf1  sf2    tf2    Tcity   Tfwy    Fastest Route");
		System.out.println("  ===  ===  =====  ===  =====  ===  =====     ===  =====  ===  =====    =====  =====   ==============");
		
		// loop 2 for all values
		for(int i = 0; i < SIZE; i++){
			System.out.printf("%5d", (i + 1));
			System.out.printf("%5d", sc1[i]);
			System.out.printf("%7s", df.format(tc1[i]));
			System.out.printf("%5d", sc2[i]);
			System.out.printf("%7s", df.format(tc2[i]));
			System.out.printf("%5d", sc3[i]);
			System.out.printf("%7s", df.format(tc3[i]));
			System.out.printf("%8d", sf1[i]);
			System.out.printf("%7s", df.format(tf1[i]));
			System.out.printf("%5d", sf2[i]);
			System.out.printf("%7s", df.format(tf2[i]));
			System.out.printf("%9s", df.format(Tcity[i]));
			System.out.printf("%7s", df.format(Tfwy[i]));
			
			// show which is faster
			if (Tcity[i] > Tfwy[i]){
				System.out.printf("%17s", "Freeway Faster");
			}
			else if (Tcity[i] < Tfwy[i]){
				System.out.printf("%17s", "City Faster");
			}
			else if (Tcity[i] == Tfwy[i]){
				System.out.printf("%17s", "Both Fast");
			}

			System.out.println();
		}
		
		// print out for segments travled
		System.out.println("\n   City Travel Segments [MILES]: " + Arrays.toString(citySegment));
		System.out.println("Freeway Travel Segments [MILES]: " + Arrays.toString(freewaySegment));
		
		// how any trips
		System.out.println("\n " + SIZE + " trips taken");
		
		// total distance and speed range
		System.out.println("  " + Arrays.stream(citySegment).sum() + " city miles, speed range " + citySpeed[1] + "-" + citySpeed[0] + " MPH");
		System.out.println("  " + Arrays.stream(freewaySegment).sum() + " fwy miles, speed range " + freewaySpeed[1] + "-" + freewaySpeed[0] + " MPH");

		// calculations for percentage fo which is faster
		percCity = (cityCounter * 100/ SIZE);
		percFwy = (fwyCounter * 100/ SIZE);
		percTossUp = (tossUp * 100/ SIZE);

		// display percentage f which is faster
		System.out.println("\nCity route faster " + df2.format(cityCounter) + "/" + SIZE + " times (" + df.format(percCity) + "%)");
		System.out.println("Fwy route faster " + df2.format(fwyCounter) + "/" + SIZE + " times (" + df.format(percFwy) + "%)");
		System.out.println("A toos-up  " + df2.format(tossUp) + "/" + SIZE + " times (" + df.format(percTossUp) + "%)");

		
	}

}
