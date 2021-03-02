package razer.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesData {

  private static FileInputStream inputStream;
  private static final Properties property;

  static {
    property = new Properties();
  }

  public static String getPropertyField(String fieldName, String propertyPath) {
    try {
      inputStream = new FileInputStream(propertyPath);
      property.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return property.getProperty(fieldName);
  }
}
