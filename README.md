# Java_Concurrency

## Source links

Documentation:

https://docs.oracle.com/javase/tutorial/essential/concurrency/

References:

<a href="https://shipilev.net/blog/2014/jmm-pragmatics/">JMM от Шипилева</a>

<a href="https://habr.com/post/133981/">Короткая статья про JMM от Глеба Смирнова</a>

[Ru] Как работает многопоточность от Глеба Смирнова (<a href="https://habr.com/post/143237/">1</a>, <a href="https://habr.com/post/209128/">2</a>)

<a href="https://habr.com/post/352374/">Милая статья от коллеги по цеху про Producer/Consumer</a>

Additional links to conference presentation or popular education videos:

<a href="https://www.youtube.com/watch?v=mf4lC6TpclM">[Ru] Теория и терминология многопоточности</a>

<a href="https://www.youtube.com/watch?v=8piqauDj2yo">[Ru] Прикладная многопоточность</a>

<a href="https://www.youtube.com/watch?v=noDnSV7NCtw">Java Memory Model Pragmatics (Aleksey Shipilёv), part 1</a>

<a href="https://www.youtube.com/watch?v=Ky1_5mabd18">Java Memory Model Pragmatics (Aleksey Shipilёv), part 2</a>

Books:

<a href="https://www.amazon.com/Java-Concurrency-Practice-Brian-Goetz/dp/0321349601">Java-Concurrency-Practice-Brian-Goetz</a>

<a href="https://www.amazon.com/Art-Multiprocessor-Programming-Revised-Reprint/dp/0123973376">Art-Multiprocessor-Programming</a>

## Task 6

Description

Task 6

Cost: 20 points.

Create a multi-threading console application that starts two threads for producer and consumer respectively. It does not matter what kind of data it produces/consumes (e.g. producer could generate random numbers and consumer could calculate their total average). There must be a graceful shutdown (use Runtime.getRuntime().addShutdownHook(), Object's join()/interrupt() methods) to allow threads to correctly finish their work. When both producer and consumer are stopped print to console how many operations were performed per second (ops/sec).

This task should be implemented using two approaches:

1. Classic model: use non-blocking Queue implementation (e.g. LinkedList) to share data between producer and consumer threads use synchronized block, wait()/notify() methods to guard the queue from simultaneous access.
2. Concurrency use classes from java.util.concurrent package for synchronization (BlockingQueue, locks, etc.).

When both versions are done compare their performance (ops/sec).