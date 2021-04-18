## Keywords should start with Capital letters
## using right click--pretty format, format can be changed as done here
## Scenario Outline is used for for data driven testing using examples:
## using @tags to group scenarios together
## here 2 types of paramters are used. normal parameters using "" and parameters using "<>"
Feature: Test Api's for manipulting places(add/get/delete place)
@AddPlace @Regression
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI and verify using getPlaceAPI
    Given Add place payload with "<name>" "<language>" "<address>"
    When user calls "addPlaceAPI" with "POST" HTTPS request
    Then The Api call should be success with status code "200"
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place created maps to "<name>" using "getPlaceAPI"

    Examples: 
      | name           | language | address    |
      | Jubly hills    | Hindi    | Gomtinagar |
      | Sheetal palace | English  | Lucknow    |

@DeletePlace @Regression
  Scenario: Verify if delete API functionality is working
    Given delete place payload
    When user calls "deletePlaceAPI" with "DELETE" HTTPS request
    Then The Api call should be success with status code "200"
    And "status" in response body is "OK"