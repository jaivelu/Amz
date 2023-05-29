@SelectHotel
Feature: Verifying Adactin hotel select hotel details

  Scenario Outline: Verifying select hotel by select any hotel name
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login success message "Hello Djayavel123!"
    And User should search hotel with enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after search hotel its navigate to success "Select Hotel"
    And User should select a hotel name
    Then User should verify after select hotel its navigate to success "Book A Hotel"

    Examples: 
      | Username    | Password   | Location | Hotels         | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Djayavel123 | 1234567890 | London   | Hotel Sunshine | Double    | 5 - Five        | 21/09/2022    | 23/09/2022     | 2 - Two         | 1 - One           |

  Scenario Outline: Verifying select hotel without select hotel name
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login success message "Hello Djayavel123!"
    And User should search hotel with enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after search hotel its navigate to success "Select Hotel"
    And User should click continue without select hotel name
    Then User should verify after select hotel error msg "Please Select a Hotel"

    Examples: 
      | Username    | Password   | Location | Hotels         | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Djayavel123 | 1234567890 | London   | Hotel Sunshine | Double    | 5 - Five        | 21/09/2022    | 23/09/2022     | 2 - Two         | 1 - One           |
