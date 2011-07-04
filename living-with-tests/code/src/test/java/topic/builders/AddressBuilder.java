package topic.builders;

public class AddressBuilder {

	private static final String VALID_POSTCODE = "LU11AT";
	
	// sensible defaults
	private int number = 99;
	private String house = "house";
	private String street = "street";
	private String area = "area";
	private String town = "town";
	private String postcode = VALID_POSTCODE;

	public AddressBuilder withTown(String town) {
		this.town = town;
		return this;
	}

	public AddressBuilder withStreet(String street) {
		this.street = street;
		return this;
	}

	public Address build() {
		return new Address(number, house, street, area, town, postcode);
	}
}
