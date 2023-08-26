Feature: CRUD user

  @PostUser
  Scenario Outline: Create user successfully.
    When I consume the endpoint "<endpoint>" and I send the user information name "<name>", salary "<salary>" age "<age>"
    Then I can validate the response service <code> and message "<message>"

    Examples:
      | name | salary | age | endpoint | code | message                              |
      | test | 124    | 23  | /create  | 200  | Successfully! Record has been added. |

  @GetUser
  Scenario Outline: obtain user successfully.
    When I consume the endpoint "<endpoint>"
    Then I can validate the response service <code> and message "<message>"

    Examples:
      | endpoint  | code | message                                |
      | /employee | 200  | Successfully! Record has been fetched. |

  @PutUser
  Scenario Outline: update user successfully.
    When I consume the endpoint "<endpoint>" and I send the user information to update name "<name>", salary "<salary>" age "<age>"
    Then I can validate the response service <code> and message "<message>"

    Examples:
      | name       | salary     | age      | endpoint | code | message                                |
      | testUpdate | 1234Update | 23Update | /update  | 200  | Successfully! Record has been updated. |

  @DeleteUser
  Scenario Outline: Delete user successfully.
    When I consume the endpoint delete "<endpoint>"
    Then I can validate the response service <code> and message deleted "<message>"

    Examples:
      | endpoint | code | message                               |
      | /delete  | 200  | Successfully! Record has been deleted |

  @GetAllUser
  Scenario Outline: obtain All user successfully.
    When I consume the endpoint all users "<endpoint>"
    Then I can validate the response service <code> and message all user "<message>"

    Examples:
      | endpoint   | code | message                                     |
      | /employees | 200  | Successfully! All records has been fetched. |