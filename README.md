


<h1 align="center">Java Ball Game</h1>

<p align="center">
  <img alt="Github top language" src="https://img.shields.io/github/languages/top/mitchellkolb/java-ball-game?color=E95420">

  <img alt="Github language count" src="https://img.shields.io/github/languages/count/mitchellkolb/java-ball-game?color=E95420">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/mitchellkolb/java-ball-game?color=E95420">

  <img alt="Github stars" src="https://img.shields.io/github/stars/mitchellkolb/java-ball-game?color=E95420" />
</p>

<p align="center">
<img
    src="https://img.shields.io/badge/Java-EB8F1C?style=for-the-badge&logo=java&logoColor=white"
    alt="Website Badge" />      
<img
    src="https://img.shields.io/badge/ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white"
    alt="Website Badge" />
</p>

While learning about programming language design I was taught the basics of Java and how it is a strictly object-oriented language with a garbage collector. To demonstrate what I learned I made a simple ball clicking game using the standard library graphics interface with arrays lists. 

![project image](resources/JavaBallGame2.gif)

<details>
<summary style="color:#5087dd">Watch the Full Video Demo Here</summary>

[![Full Video Demo Here](https://img.youtube.com/vi/DPazirTKoa0/0.jpg)](https://www.youtube.com/watch?v=DPazirTKoa0)

</details>

---


# Table of Contents
- [What I Learned](#what-i-learned-in-this-project)
- [Tools Used / Development Environment](#tools-used--development-environment)
- [Team / Contributors / Teachers](#team--contributors--teachers)
- [How to Set Up](#how-to-set-up)
- [Project Overview](#project-overview)
- [Project Details](#project-details)
    - [Technical Plan](#technical-plan)
    - [Implementation Details](#implementation-details)
    - [Files and Structure](#files-and-structure)
    - [Implementation](#implementation)
    - [Results and Observations](#results-and-observations)
- [Acknowledgments](#acknowledgments)

---

# What I Learned in this Project
- Programming syntax fundamentals for Java
- Java Libraries: Using standard libraries for graphics and I/O operations.
- Inheritance: Creating subclasses to extend base class functionality.
- Type Casting: Understanding Java's type system and performing type casting.
- Arrays and ArrayLists: Managing collections with arrays and ArrayLists.
- OOP Principles: Applying classes, inheritance, polymorphism, and encapsulation.


# Tools Used / Development Environment
- Java
- VS Code
- Terminal
- Ubuntu





# Team / Contributors / Teachers
- [Mitchell Kolb](https://github.com/mitchellkolb)
- Associate Professor. Jeremy E. Thompson





# How to Set Up
This project was implemented on our local machine inside of a virtual machine using:
- **Install Java Development Kit (JDK)**: Follow instructions from [OpenJDK](https://openjdk.java.net/install/) or [Oracle](https://www.java.com/en/download/help/develop.html).
- Clone this repository 
- Open terminal at the codebase `~.../java-ball-game/BallGame/`
- Use this command to compile the codebase
```zsh
javac *.java
```
- Use this command to run the program.
```zsh
java BallGame 1 basic 0.08 
```
- The following arguments will be passed to the game in the command line: 
`# of balls`,  `ball type`,  `ball radius` 
- ball type and  ball radius will be repeated for each ball. 

For example: 
`4 basic 0.10 bounce 0.05 shrink 0.13 split 0.05`




# Project Overview
This project is a simple ball-clicking game developed in Java to demonstrate various object-oriented programming concepts. The player scores points by clicking on moving balls before they exit the scene.

# Project Details

## Introduction
This project was assigned to me so I could apply Java's object-oriented principles with a simple game using standard libraries and array lists. The game includes different types of balls, each with unique behaviors and scoring mechanisms.

## Technical Plan
The project utilizes Java's object-oriented features, including class inheritance and polymorphism, to create different ball types with specific behaviors. The game maintains an array list of ball objects, updating their states and checking for user interactions.

## Implementation Details
The game supports multiple ball types:
- **BasicBall**: A simple ball that moves randomly.
- **ShrinkBall**: A ball that shrinks in size with each hit.
- **BounceBall**: A ball that bounces off the screen borders a limited number of times.
- **SplitBall**: A ball that splits into two smaller balls each time it is hit.

## Files and Structure
- `BallGame.java`: Main class that initializes the game and handles the game loop.
- `BasicBall.java`: Implements the basic ball class with methods to draw, move, and check interactions.
- `ShrinkBall.java`: Extends `BasicBall` to add shrinking behavior.
- `BounceBall.java`: Extends `BasicBall` to add bouncing behavior.
- `SplitBall.java`: Extends `BasicBall` to add splitting behavior.
- `Player.java`: Manages player information and scoring.

## Implementation
The game begins with a specified number of balls, which are managed in an array list. Each ball's behavior is determined by its type, and the player's score is updated based on successful hits.

## Results and Observations
When I was coding this I had various challenges that I encountered and addressed, such as managing ball interactions and ensuring smooth gameplay. One thing I would fix is that on the start of the game the most hit ball is stated as an error becuase no balls have been clicked. I would want to make this show something else as it is not an error that needs the big text of "ERROR" across the screen.








--- 
# Acknowledgments
This codebase and all supporting materials was made as apart of a course for my undergrad at WSU for CPTS 355 - Programming Language Design in the Summer of 2023. 

