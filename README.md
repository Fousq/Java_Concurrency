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

## Task 3

Description

Task 3 - Where’s Your Bus, Dude?

Cost: 20 points.

Implement message bus using Producer-Consumer pattern.

1. Implement asynchronous message bus. Do not use queue implementations from java.util.concurrent.
2. Implement producer, which will generate and post randomly messages to the queue.
3. Implement consumer, which will consume messages on specific topic and log to the console message payload.
4. (Optional) Application should create several consumers and producers that run in parallel.