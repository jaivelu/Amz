@Login
Feature: Verifying Adactin login details

  Scenario Outline: Verifying Adactin hotel login valid datas
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login success message "Hello Djayavel123!"

    Examples: 
      | Username    | Password   |
      | Djayavel123 | 1234567890 |

  Scenario Outline: Verifying Adactin hotel login valid datas using Enter
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>" with Enter key
    Then User should verify after login success message "Hello Djayavel123!"

    Examples: 
      | Username    | Password   |
      | Djayavel123 | 1234567890 |

  Scenario Outline: Verifying Adactin hotel login invalid credentials
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login with invalid credential error msg contains "Invalid Login details or Your Password might have expired. Click here to reset your password"

    Examples: 
      | Username | Password  |
      | Djayavel | 123456789 |
