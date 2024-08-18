# Vocabulary Control Center

## Overview

The Vocabulary Control Center is a Java-based application that allows users to create and manage a navigable database of topics and associated vocabulary. This application is designed to help users organize and modify vocabulary lists efficiently.

## Features

- **Browse Topics**: View all existing topics and their associated vocabulary.
- **Insert New Topics**: Add new topics before or after existing topics.
- **Remove Topics**: Remove topics from the list.
- **Modify Topics**: Add, remove, or change vocabulary words within a topic.
- **Search Vocabulary**: Search for a word across all topics or find words starting with a specific letter.
- **Load/Save Data**: Load vocabulary data from a file or save the current list to a file.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A compatible IDE or text editor

### Installation

1. Clone the repository:

```bash
git clone https://github.com/SohaibDM/VocabLibrary.git
```
2. Navigate to the project directory:

```bash
cd VocabLibrary
```
3. Compile the Java files:

```bash
javac Driver.java DoublyLinkedList.java SinglyLinkedList.java Vocab.java
```
Running the Application
1. Run the Driver class:

```bash
java Driver
```
2. Follow the on-screen prompts to use the application.

Usage
Main Menu
1: Browse a topic
2: Insert a new topic before another one
3: Insert a new topic after another one
4: Remove a topic
5: Modify a topic
6: Search topics for a word
7: Load from a file
8: Show all words starting with a given letter
9: Save to file
0: Exit
File Format
When loading or saving data, the file should be in the following format:

Topics are preceded by a # character.
Each topic is followed by its vocabulary list, with each word on a new line.
Example:

```bash
Copy code
#Topic1
word1
word2

#Topic2
wordA
wordB
