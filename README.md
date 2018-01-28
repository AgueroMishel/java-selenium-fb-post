# Facebook Post

## Requirements
* Maven
* [Chrome Driver](https://sites.google.com/a/chromium.org/chromedriver/downloads)

## Instructions
1. Clone this repository
1. Download [Chrome Driver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
1. Set following arguments under App.java file:
    1. Driver Path
    1. Email
    1. Password
    1. Message
1. Run Maven to build JAR file with dependencies
```sh
$ mvn clean install
```
1. Open a terminal and go to the <root-folder-project>/target
1. Run Java
```sh
$ java -jar FacebookPost-<version>-jar-with-dependencies.jar
```