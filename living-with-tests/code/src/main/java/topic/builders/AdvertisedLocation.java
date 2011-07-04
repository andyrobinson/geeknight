package topic.builders;

public class AdvertisedLocation {

	private final Address address;
	private final Demographic demographic;

	public AdvertisedLocation(Demographic demographic, Address address) {
		this.address = address;
		this.demographic = demographic;
	}

	public String townName() {
		String adjective = "";
		if (demographic == Demographic.YOUNG_PROFESSIONAL) {
			adjective = "Trendy ";
		}
		else if (demographic == Demographic.RETIREE) {
			adjective = "Tranquil ";
		}
		return adjective + address.town();
	}

	public String streetName() {
		return "Leafy " + address.street();
	}

}
