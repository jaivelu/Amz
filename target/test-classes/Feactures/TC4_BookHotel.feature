@BookHotel
Feature: Verifying Adactin hotel book hotel details

  Scenario Outline: Verifying book hotel by select all feilds
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

    Examples: 
      | Username    | Password   | Location | Hotels         | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room | First Name | Last Name | Billing Address    |
      | Djayavel123 | 1234567890 | London   | Hotel Sunshine | Double    | 5 - Five        | 21/09/2022    | 23/09/2022     | 2 - Two         | 1 - One           | Jayavel    | Jayavel   | 435,Chennai-606076 |

  Scenario Outline: Verifying book hotel without select all feilds
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login success message "Hello Djayavel123!"
    And User should search hotel with enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after search hotel its navigate to success "Select Hotel"
    And User should select a hotel name
    Then User should verify after select hotel its navigate to success "Book A Hotel"
    And User should click bookNow without select all feilds
    Then User should verify after book hotel error msg "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | Username    | Password   | Location | Hotels         | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Djayavel123 | 1234567890 | London   | Hotel Sunshine | Double    | 5 - Five        | 21/09/2022    | 23/09/2022     | 2 - Two         | 1 - One           |
