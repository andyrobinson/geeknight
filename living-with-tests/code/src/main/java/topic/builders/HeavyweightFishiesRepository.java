package topic.builders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HeavyweightFishiesRepository {

	private Properties properties;

	public HeavyweightFishiesRepository(String storageFilename) throws IOException {
		this.properties = loadPropertiesFromFile(storageFilename);
	}

	public Fishies getFishiesFor(String owner) {
		return parseFishies(properties.getProperty(owner + "-fish"));
	}

	private Fishies parseFishies(String fishyNameList) {
		List<Fish> fish = new ArrayList<Fish>();
		for (String fishName : fishyNameList.split(",")) {
			fish.add(new Fish(fishName, Fish.Type.valueOf(properties.getProperty(fishName + "-type")), Integer.valueOf(properties.getProperty(fishName + "-age"))));
		}
		return new Fishies(fish);
	}

	private Properties loadPropertiesFromFile(String storageFilename) throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(storageFilename);
		try {
			properties.load(fis);
			return properties;
		} 
		finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
}
