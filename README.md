# Facebook Post

## Requirements
* Maven
* [Chrome Driver](https://sites.google.com/a/chromium.org/chromedriver/downloads)

## Instructions
1. Clone this repository
1. Create a directory under root folder named "driver"
1. Copy Chrome Driver into "driver" folder
1. Set your email, password and message on App.java
1. Run Maven to build JAR file with dependencies
```sh
$ mvn clean install
```
1. Open a terminal and go to the root folder project
1. Run Java
```sh
$ java -jar FacebookPost-0.1-jar-with-dependencies.jar
```