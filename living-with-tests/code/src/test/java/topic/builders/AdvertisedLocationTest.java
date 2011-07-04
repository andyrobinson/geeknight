package topic.builders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static topic.builders.Demographic.RETIREE;
import static topic.builders.Demographic.YOUNG_PROFESSIONAL;

import org.junit.Test;

public class AdvertisedLocationTest {

	private static final String VALID_POSTCODE = "LU11AT";
	private AdvertisedLocation asAdvertised;
	private Address address;

	@Test
	public void shouldPutAPositiveLightOnTownForYoungProfessionals() {
		address = new Address(111, "house", "street", "area", "Luton", VALID_POSTCODE);
		
		asAdvertised = new AdvertisedLocation(YOUNG_PROFESSIONAL, address);
		
		assertThat(asAdvertised.townName(), is("Trendy Luton"));
	}

	@Test
	public void shouldPutAPositiveLightOnTownForRetirees() {
		address = new Address(111, "house", "street", "area", "Luton", VALID_POSTCODE);
		
		asAdvertised = new AdvertisedLocation(RETIREE, address);
		
		assertThat(asAdvertised.townName(), is("Tranquil Luton"));
	}

	@Test
	public void shouldPutAPositiveLightOnStreetForRetirees() {
		address = new Address(333, "house", "Factory Lane", "area", "town", VALID_POSTCODE);

		asAdvertised = new AdvertisedLocation(RETIREE, address);
		
		assertThat(asAdvertised.streetName(), is("Leafy Factory Lane"));
	}

	@Test
	public void shouldPutAPositiveLightOnTownForYoungProfessionalsUsingABuilder() {
		address = new AddressBuilder().withTown("Luton").build();
		
		asAdvertised = new AdvertisedLocation(YOUNG_PROFESSIONAL, address);
		
		assertThat(asAdvertised.townName(), is("Trendy Luton"));
	}

	@Test
	public void shouldPutAPositiveLightOnTownForRetireesUsingABuilder() {
		address = new AddressBuilder().withTown("Luton").build();
		
		asAdvertised = new AdvertisedLocation(RETIREE, address);
		
		assertThat(asAdvertised.townName(), is("Tranquil Luton"));
	}

	@Test
	public void shouldPutAPositiveLightOnStreetForRetireesUsingABuilder() {
		address = new AddressBuilder().withStreet("Factory Lane").build();

		asAdvertised = new AdvertisedLocation(RETIREE, address);
		
		assertThat(asAdvertised.streetName(), is("Leafy Factory Lane"));
	}
}
