@CancelBooking
Feature: Verifying Adactin hotel cancel booking details

  Scenario Outline: Verifying cancel booking and gendrate order id
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login success message "Hello Djayavel123!"
    And User should search hotel with enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after search hotel its navigate to success "Select Hotel"
    And User should select a hotel name
    Then User should verify after select hotel its navigate to success "Book A Hotel"
    And User should book hotel with enter "<First Name>","<Last Name>" and "<Billing Address>"
      | creditCardNo     | creditCardType   | expiryMonth | expiryYear | cvv |
      | 1234567823456345 | American Express | November    |       2022 | 456 |
      | 1234567823456345 | VISA             | November    |       2022 | 456 |
      | 1234567678456345 | Master Card      | November    |       2022 | 322 |
      | 8234567823456677 | Other            | November    |       2022 | 409 |
    Then User should verify after book hotel its navigate to success "Booking Confirmation"
    And User should cancel gendreate order id
    Then User should after cancelled order id success message "The booking has been cancelled."

    Examples: 
      | Username    | Password   | Location | Hotels         | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room | First Name | Last Name | Billing Address    |
      | Djayavel123 | 1234567890 | London   | Hotel Sunshine | Double    | 5 - Five        | 21/09/2022    | 23/09/2022     | 2 - Two         | 1 - One           | Jayavel    | Jayavel   | 435,Chennai-606076 |

  Scenario Outline: Verifying cancel booking and existing order id
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login success message "Hello Djayavel123!"
    And User should cancel existing order id "<OrderID>"
    Then User should after cancelled order id success message "The booking has been cancelled."

    Examples: 
      | Username    | Password   | OrderID    |
      | Djayavel123 | 1234567890 | O53Z6AE6W9 |
