

# R3 Coding Interview Submission
A game verifier for noughts and crosses built for a R3 coding interview.

# Prerequisites
This project was build for Java Development Kit version 15 or higher. To check, run java -version. You should see something like this:

```
❯ java -version
openjdk 15.0.1 2020-10-20
OpenJDK Runtime Environment (build 15.0.1+9)
OpenJDK 64-Bit Server VM (build 15.0.1+9, mixed mode, sharing)
```

## Project Structure
The major class of the submission: Board.java, and two enum classes: GameState and TileState are found in: 

```
r3_submission/src/main/java/submission/
```

The test cases are found in: 

```
r3_submission/src/test/java/submission/BoardTest.java
```

# Gradle
The build for this project is handled by Gradle.

## Test
To check the game verifier against the tests written for it, run the following code from inside the r3_submission folder containing build.gradle:

```
> gradle test
```

# Intellij

## Import Project
To set up the project in the Intellij IDE: 

1. Open Intellij and navigate to:
```
>File >New >Project from existing sources
```
2. Then select the r3_submission folder and open.
3. Select "Import project from external model" and choose Gradle.
4. Finally, press finish to import the project and open it in a development window.


