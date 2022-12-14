# Santa

A fun hack that makes Santa fly across the screen approximately once per 1-2 minutes.

## Setup

1. Install [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17) and make sure JAVA_HOME is set.

Tip: Add your +1 to https://github.com/gradle/gradle/issues/2508 to make even this unnecessary.

## Usage

1. From the project root, run `santa.sh` and minimize the terminal to hide your tracks
    * Or use `nohup santa.sh &` if you want to be really nefarious, which allows you to close the terminal to leave no trace.

## Known issues

* `santa.sh` obviously doesn't work on Windows. Need to move that into the Java code so everything's cross-platform.
