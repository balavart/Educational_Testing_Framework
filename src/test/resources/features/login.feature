Feature: Login User

  /todo
  Scenario: Login user
    When Click User button
    When Input login
    When Input password
    When Click Submit button
    When Enter personal account
    Then Content with Данные покупателя visible
