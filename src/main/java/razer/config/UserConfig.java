package razer.config;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public interface UserConfig {
  String USER_LOGIN = "gta255@yandex.ru";
  String USER_PASSWORD = "Password1";
  String NEW_NAME = "Ba" + randomAlphabetic(4);
  String NEW_SURNAME = "Su" + randomAlphabetic(4);
  String NEW_EMAIL = "my_" + randomAlphabetic(6) + "@mail.ru";
  String NEW_PHONE_NUMBER = "7" + randomNumeric(10);
  String NEW_PASSWORD = "123" + randomAlphabetic(6);
}
