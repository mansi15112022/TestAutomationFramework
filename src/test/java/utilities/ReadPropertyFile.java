package utilities;

import java.io.FileReader;
import java.util.Properties;

import org.testng.SkipException;

public class ReadPropertyFile {
	
	
	public static void main(String[] args) throws Exception {
	}

	public static String getProperty (String str) throws Exception {
		String s = null;
		String projectLocation = System.getProperty("user.dir");
		String configPath = projectLocation + "/src/test/resources/configfiles/config.properties";
		FileReader fr = new FileReader(configPath);
		Properties p = new Properties();
		p.load(fr);
		
		//System.out.println(p.getProperty("browser"));
		// System.out.println(p.getProperty("testurl"));
		try {
			s= p.get(str).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(s==null) {
			throw new SkipException("value is null");
		}
		return s;
	}

}
