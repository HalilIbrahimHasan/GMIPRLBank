$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\resources\\features\\Database.feature");
formatter.feature({
  "name": "all data validation based on DB",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@database"
    }
  ]
});
formatter.scenarioOutline({
  "name": "test all ssn ids provided from UI",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@datatest001"
    }
  ]
});
formatter.step({
  "name": "user reads and gets all ssn \"\u003cid\u003e\" and \"\u003cquery\u003e\" using db",
  "keyword": "Given "
});
formatter.step({
  "name": "user saves the ssn ids to correspondent files",
  "keyword": "And "
});
formatter.step({
  "name": "user validates them",
  "keyword": "Then "
});
formatter.examples({
  "name": "all the data",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "id",
        "query"
      ]
    },
    {
      "cells": [
        "ssn",
        "Select * from tp_customer"
      ]
    }
  ]
});
formatter.background({
  "name": "create a connection with DB",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a connection with db using \"jdbc:postgresql://157.230.48.97:5432/gmibank_db\" , \"techprodb_user\" and \"Techpro_@126\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_creates_a_connection_with_db_using_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "test all ssn ids provided from UI",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@database"
    },
    {
      "name": "@datatest001"
    }
  ]
});
formatter.step({
  "name": "user reads and gets all ssn \"ssn\" and \"Select * from tp_customer\" using db",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabaseStep.user_reads_and_gets_all_ssn_and_using_db(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user saves the ssn ids to correspondent files",
  "keyword": "And "
});
formatter.match({
  "location": "DatabaseStep.user_saves_the_ssn_ids_to_correspondent_files()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validates them",
  "keyword": "Then "
});
formatter.match({
  "location": "DatabaseStep.user_validates_them()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});