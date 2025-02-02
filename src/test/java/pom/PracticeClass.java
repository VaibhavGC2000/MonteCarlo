package pom;

public class PracticeClass {

	public static String findPincode(String address) {
		// Split the address into parts using space, comma, or hyphen as delimiters
		String[] parts = address.split("[,\\s-]+");

		// Loop through the parts to find a 6-digit number
		for (String part : parts) {
			if (part.length() == 6 && part.matches("\\d{6}")) {
				return part;
			}
		}

		return "Pincode not found";
	}

	public static void main(String[] args) {
		String address = "Monte Carlo Fashions Limited Unit-2, 231, Industrial Area - A, Ludhiana-141003, Punjab, India";
		String pincode = findPincode(address);
		System.out.println("Extracted Pincode: " + pincode);
	}
}
