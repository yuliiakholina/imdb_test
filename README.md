# imdb_test

How to run tests?(Linux)
1. Install maven via command
sudo apt-get install maven
2. Open command line in project's root folder (where is pom.xml file is stored)
3. Run tests with command
mvn clean test
For having allure test report, you can find the instructions here https://docs.qameta.io/allure/ (2.1.1)

Please note, for making checking process of the task easier, tests are also run through github actions. So, you can navigate to Actions tab here and see the test build, currently it it run on latest version of Ubuntu
