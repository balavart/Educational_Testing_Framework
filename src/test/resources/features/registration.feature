Feature: Registration User

  Scenario: Create user
    Then Open registration page
    Then Input name
    Then Input surname
    Then Input email
    Then Input phone number
    Then Input new password
    Then Input new password repeatedly
    Then Click ReCaptcha
#    Then Click registration button
#    Then Enter personal account
#    Then Check name field