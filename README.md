# Backbase
I just make web part until it is not necessary I dont want to use more time for backend part.
I used java with serenity bdd, because it creates automatically reports, and support rest assured.
I wanted to use rest assured to automate backend part, but building frontend framework took me more time than I expected.
Please review my code and solutions and if you are still interested in my candidature and rest part to be written is necessary let me know.


1. Create a series of manual test cases that cover one functionality that you choose
testcases/testcases.txt
testcases/testcases.png
2. Automate ( at least two ) of the previously created test cases
features/article/article.feature
features/article/login.feature
3. Provide a test report for executed test cases
please run mvn clean verify -> it will generate report automatically, please open: target/site/serenity/index.html
screen from report:
features/report/reportHomePage.png
4. Provide an overall evaluation report for the application (approach, issues, risks, recommendation, why you chose the test cases to automate, etc.)
Overall application needs to be completed, there is lots of bugs, eg: I cannot add tags separately.
I focused on automation.
I didnt make pen tests, because dont want spent days on it.
5. When the assignment is completed please push your deliverables to a private git repository. The repository must include clear instructions on where to find each deliverable and how to run tests

Please git clone and run tests:
mvn clean verify

