Feature: Verifying Adactin hotel search hotel details

  Scenario Outline: Verifying search hotel by select all feilds
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login success message "Hello Djayavel123!"
    And User should search hotel with enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after search hotel its navigate to success "Select Hotel"

    Examples: 
      | Username    | Password   | Location | Hotels         | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Djayavel123 | 1234567890 | London   | Hotel Sunshine | Double    | 2 - Two         | 21/09/2022    | 23/09/2022     | 2 - Two         | 1 - One           |

  Scenario Outline: Verifying search hotel by only Mandatory fields
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login success message "Hello Djayavel123!"
    And User should search hotel with enter mandatory "<Location>","<Number of Rooms>","<Check In Date>","<Check Out Date>" and "<Adults per Room>"
    Then User should verify after search hotel its navigate to success "Select Hotel"

    Examples: 
      | Username    | Password   | Location | Number of Rooms | Check In Date | Check Out Date | Adults per Room |
      | Djayavel123 | 1234567890 | London   | 5 - Five        | 21/09/2022    | 23/09/2022     | 2 - Two         |

  Scenario Outline: Verifying search hotel by Date checking
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login success message "Hello Djayavel123!"
    And User should search hotel with enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and "<Children per Room>"
    Then User should verify after search hotel error message "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | Username    | Password   | Location | Hotels         | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Djayavel123 | 1234567890 | London   | Hotel Sunshine | Double    | 5 - Five        | 25/09/2022    | 23/09/2022     | 2 - Two         | 1 - One           |

  Scenario Outline: Verifying search hotel without enter all feilds
    Given User is on the Adactin page
    When User should perform login "<Username>","<Password>"
    Then User should verify after login success message "Hello Djayavel123!"
    And User should search hotel without enter the all fields
    Then User should verify after search hotel error message "Please Select a Location"

    Examples: 
      | Username    | Password   |
      | Djayavel123 | 1234567890 |
