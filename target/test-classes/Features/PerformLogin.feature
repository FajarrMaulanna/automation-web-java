Feature: Login Account
  @positive
  Scenario: Perform Login with Valid Account
    Given I Open browser
    And Open website Swag Labs
    When Input Valid Username
    And Input Password
    Then Showing Page Dashboard

  @negative
  Scenario: Perform Login with Invalid Account
    Given I Open browser
    And Open website Swag Labs
    When Input Invalid Username
    And Input Password
    Then Showing Error Message

  @positive
  Scenario: Perform Add to Chart One of the Product
    Given I Open browser
    And Open website Swag Labs
    When Input Valid Username
    And Input Password
    When Add Product to Chart
    Then Product has been Added


  @positive
  Scenario: Perform Checkout the Product from Chart
    Given I Open browser
    And Open website Swag Labs
    When Input Valid Username
    And Input Password
    When Add Product to Chart
    And Checkout Product from Chart
    Then Product has been checkout