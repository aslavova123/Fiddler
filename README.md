# Project Description

This project represents example test automation framework for the Fiddler Everywhere desktop application.

The test cases are implemented in Java with Gradle as building tool and TestNG as test running framework. SikuliX API is used as external library to facilitate the assertions in the test cases. 

# Important Notes

I was not able to  set up Sikuli with Java properly on my local environment. As a result, the test cases are never actually executed. Sikuli was successfully imported as library to the project but for some reason on runtime, the packages were not found. This seems to be common issue (https://stackoverflow.com/questions/20137020/package-doesnt-exist-error-in-intellij) which unfortunately, I was not able to resolve. So, I am sending you more of an example of project structure as the assignment suggests that I can do so even if the solution is not running.