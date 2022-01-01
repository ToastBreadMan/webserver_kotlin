# What is this project? 
This is a Webserver build in kotlin with the goal of making a small lightweight http webserver
# Technical Details
Build tool: Gradle</br>
## Structure
````
│   .gitignore
│   build.gradle.kts
│   gradle.properties
│   gradlew
│   gradlew.bat
│   README.md
│   settings.gradle.kts
│
├───gradle
│   └───wrapper
│           gradle-wrapper.jar
│           gradle-wrapper.properties
│
└───src
    └───main
        └───kotlin
            │   main.kt
            │
            └───lib
                │   Handler.kt
                │   Helper.kt
                │   Webserver.kt
                │
                └───io
                        Request.kt
                        Response.kt
````
src: source Files with the code </br>
lib: Handles all webserver related files like async webserver handling or splitting up the request</br>
io: Has tlifecycle input and output classes like Request and Response
# State of Development 
It still lacks some features like for example path parameters or websockets but i want to add those asap or as soon as i can wrap my head around this 