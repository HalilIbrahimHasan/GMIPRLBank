@database
  Feature: all data validation based on DB


    Background: create a connection with DB
      Given user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"


      Scenario Outline: read data using column name

        Given user provides the query as "<query>" and "<columnName>"
        And user validates all db data
        Then user prints them on the pdf and close connection


        Examples: read the data
        |query|columnName|
        |Select * from tp_country|id|
        |Select * from tp_country|name|


        @dbTest
    Scenario Outline: read data using column name

      Given user provides the query as "<query>" , columnName "<columnName>" and next "<columnName2>"
      And user validates all db data
      Then user prints them on the pdf and close connection


      Examples: read the data
        |query|columnName|columnName2|
        |Select * from tp_country|id|name|




          @datatest001
          Scenario Outline: test all ssn ids provided from UI
            Given user reads and gets all ssn "<id>" and "<query>" using db
            And user saves the ssn ids to correspondent files
            Then user validates them

            Examples: all the data
            |id|query|
            |ssn|Select * from tp_customer|





