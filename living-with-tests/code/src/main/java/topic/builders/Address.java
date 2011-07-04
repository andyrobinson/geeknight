package topic.builders;

public class Address {

	private final int houseNumber;
	private final String houseName;
	private final String street;
	private final String area;
	private final String town;
	private final String postcode;

	public Address(int houseNumber, String houseName, String street, String area, String town, String postcode) {
				this.houseNumber = houseNumber;
				this.houseName = houseName;
				this.street = street;
				this.area = area;
				this.town = town;
				this.postcode = postcode;
		validate();
	}

	private void validate() {
		checkPostcode(postcode);
		checkIsSet(houseName, "houseName");
		checkIsSet(street, "street");
		checkIsSet(area, "area");
		checkIsSet(town, "town");
	}

	private void checkPostcode(String postcode) {
		if (! postcode.matches("^[A-Z]+[0-9]+.*")) {
			throw new IllegalArgumentException("Postcode format is invalid: " + postcode);
		}
	}

	private void checkIsSet(String field, String fieldName) {
		if (field == null || field.length() < 3) {
			throw new IllegalArgumentException("Invalid address field '" + fieldName + 
					"': must be at least 3 chars");
		}
	}

	public String town() {
		return town;
	}

	public String street() {
		return street;
	}

}
