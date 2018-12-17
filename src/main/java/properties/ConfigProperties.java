package properties;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private static final Logger logger = Logger.getLogger(ConfigProperties.class);

    private static String fileName = "Config.properties";

    public String getProperty(String name, String defaultResult) {
        String result;
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        try {
            properties.load(inputStream);
            result = properties.getProperty(name);

            inputStream.close();

            if (result == null || result.equals("")) {
                throw new Exception("Result is null");
            }

        } catch (Exception e) {
            result = defaultResult;
            logger.error(e);
        }

        logger.info(result);
        return result;
    }
}
