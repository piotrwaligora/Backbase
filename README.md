# Backbase
Please review my code and solutions and if you are still interested in my candidature let me know.

Here you can see how it works on movie:
https://github.com/piotrwaligora/Backbase/blob/master/src/test/resources/additionalFiles/blog.mov

Please switch to branch master!!!
1. Create a series of manual test cases that cover one functionality that you choose ->
paths:
https://github.com/piotrwaligora/Backbase/blob/master/src/test/resources/additionalFiles/testcases.png
testcases/testcases.txt
2. Automate ( at least two ) of the previously created test cases ->
path:
features/article/article.feature
  automated: Backend: Verify article is added
  Frontend: Verify article is added
  Frontend: Verify article is added with empty data

3. Provide a test report for executed test cases ->
please run mvn clean verify -> it will generate report automatically, please open: target/site/serenity/index.html
paths to screen from report:
https://github.com/piotrwaligora/Backbase/blob/master/src/test/resources/features/report/reportHomePage.png
additionalFiles/serenityReport.png
4. Provide an overall evaluation report for the application (approach, issues, risks, recommendation, why you chose the test cases to automate, etc.) ->
Application is in good shape, however I found some defects which needs to be fixed:
a) If you change profile password, there is no input field to reenter the password. So if user make TYPO than he will lose your profile.
b) When I add article I dont have to put article title, I can add article with all fields empty, etc. Validation is needed there.
c) I can add empty comment
d) Password can be without any special signs.
e) I cannot add more than 1 tag, no possibility to splt tags.
f) Follow user doesnt work. If I add article and i logout and login as user that follow me, he doesnt get any info about new article.

I dont see any possibility of injections, application is in js/angular, I tried to break security but without success. I tried to put special signs, and inject js scripts, without success.
I didnt check max load, because I havent used jmeter for long time.

5. When the assignment is completed please push your deliverables to a private git repository. The repository must include clear instructions on where to find each deliverable and how to run tests

Please git clone, checkout master branch and run tests:
<b>mvn clean verify</b>