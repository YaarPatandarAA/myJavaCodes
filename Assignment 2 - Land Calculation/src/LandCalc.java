public class LandCalc {
	public static void main(String[] args) {
		final int acre_SQFT =  43560, someNUM = 389767;
		System.out.printf("There are %d acres in %,d sqFT", (someNUM/acre_SQFT), someNUM);
	}
}
