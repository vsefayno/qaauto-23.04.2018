# Environment setup steps

## Download enviroment setup files
1. [Download Intellij Idea](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)
2. [Download Java SE Development Kit by link](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)

## Install downloaded files
1. Install Java SE Development Kit **use default settings during installation**
2. Install Intellij Idea **use default settings during installation**
3. Install Firefox browser *{if it is already intalled, check if the updates installed}*

## Create new project in Intellij Idea
1. Launch Intellij Idea
2. Create New project
3. Select 'Maven' tab from the left menu
4. Select installed Java JDK in 'Project SDK' field
5. Click 'Next' button
6. Fill 'GroupID' and 'ArtifactID' on your own and click 'Next' button
7. Type project name in 'Project Name' and 'Project Location' fields as in 'ArtifactID' field in previous wizard window 
8. Click 'Finish' button

## Add Selenium WebDriver to navigate browser 
1. Go to [Maven repository](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.11.0)
2. Copy text 'Selenium dependency'
3. Open 'pom.xml' file in project directory 
4. Insert copied Selenium dependency
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
  <dependency>
     <groupId>org.seleniumhq.selenium</groupId>
     <artifactId>selenium-java</artifactId>
     <version>3.11.0</version>
 </dependency>
5. Border *<dependency>* and *</dependency>* block with *<dependencies>* and *</dependencies>* tags
6. Wait till all components dondload and tags become in black text 

## Adding geckodriver to let Selenium manipulate browser
1. Go to [Geckodriver page](https://github.com/mozilla/geckodriver/releases)
2. Download geckodriver
3. Unpack downloaded ZIP file to EXE 
4. Copy 'geckodriver.exe' to 'C:\Windows\System32'

## Adding additional panels
1. Click on 'View' tab in Main menu and click on 'Toolbar' and 'Tool Buttons' points
2. Check new panels appear from the right

## Adding new Class
1. Click right mouse button on 'java' folder in path 'Name of the project > src > main > java'
2. Put mouse on 'New' tab 
3. Click on 'Java Class' option
4. Type any name of class in 'Name' field
5. Click 'Ok' button

## Adding main method
1. Type main method 'public static void main(String args[]) {}'

## Print 'Hello world!' text {not mandatory step}
1. System.out.println("Hello world!");

## Connecting to Firefox browser and opening 'Google' page
1. Type next strings:
 WebDriver WebDriver = new FirefoxDriver();
 WebDriver.get("https://www.google.com/");
2. Note thst if 'WebDriver' has red color - you need to press ALT+ENTER and this string 'import org.openqa.selenium.WebDriver;' appears st the top
3. Note thst if 'FirefoxDriver' has red color - you need to press ALT+ENTER and this string 'import org.openqa.selenium.firefox.FirefoxDriver;' appears st the top

## Running the project
1. Click on green arrow button on menu ribbon
2. Check 'Hello world!' text is displayed in console
3. Check 'Process finished with exit code 0' text is displayed in console
4. Check Firefox browser launched and 'https://www.google.com/' page is opened
5. Enjoy the project :)