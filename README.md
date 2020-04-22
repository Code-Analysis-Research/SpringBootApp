# SpringBootApp
This repo will contain spring boot app used to run static code analysis on
List of rules that sonarqube uses: https://rules.sonarsource.com/java/RSPEC-5135

Run the sonarqube server, Create a new project within sonarqube and run the command below to compile 
and analyze code, The login credential (-Dsonar.login) is created and given to you when you create the project
within sonarqube.

Run:
mvn clean install sonar:sonar \
  -Dsonar.projectKey=com.codeanalysis:spring-boot-sample-app \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=ae0a6227f9af8a3bb328ca3db064643089b26dea
