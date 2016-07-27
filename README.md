# Java Mini Benchmarks
These are mini Java benchmarks we use in our research.

### Dependencies / Requirements
To build and run, you need:

1. [Java 1.8](http://openjdk.java.net/)
2. [Gradle 2.14.1](https://gradle.org/gradle-download/)

I'm trying to keep up with the latest versions so if you find the recommended
versions out of date, please send me a message.

### SimpleList benchmark

Running the following command prints out the command line usage:

```
$ java -jar simple_list-0.1.jar 
usage: number reps size

positional arguments:
    number             number of elements in LinkedList
    reps               number of repetitions of creating LinkedList
    size               size (in bytes) of a LinkedList Node
```
