Feature: Registration User

  Scenario: Create user
    When Open registration page
    When Input name
    When Input surname
    When Input email
    When Input phone number
    When Input new password
    When Input new password repeatedly
    When Click ReCaptcha
    When Click registration button
    When Enter personal account
    Then Check name field