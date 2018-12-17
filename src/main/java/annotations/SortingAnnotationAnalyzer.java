package annotations;

import org.apache.log4j.Logger;
import properties.ConfigProperties;
import sorter.BubbleSort;

import java.lang.reflect.Field;

public class SortingAnnotationAnalyzer {
    private static final Logger logger = Logger.getLogger(SortingAnnotationAnalyzer.class);

    public static <T> void analyze(T object) {
        Class clazz = object.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SortingAnnotation.class)) {
                ConfigProperties configProperties = new ConfigProperties();
                String sortClassName = configProperties.getProperty("sort", "BubbleSort");

                Class classForField;
                try {
                    classForField = Class.forName("sorter." + sortClassName);
                } catch (Exception e) {
                    classForField = BubbleSort.class;
                    logger.error(e);
                }

                field.setAccessible(true);
                try {
                    field.set(object, classForField.newInstance());
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }
}
