@smoke
  Feature: F09_ResetPassword | User could reset password
    Scenario: User could reset his/her password successfully
      Given user click on login button
      When user click on Forgot password link
      And user enter valid "QAtester@msn.com"
      And click on recover button
      Then check the reset successfully