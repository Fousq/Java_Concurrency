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

## Task 1

Description
Task 1 - Das Experiment

Cost: 20 points.

Create HashMap<Integer, Integer>. The first thread adds elements into the map, the other go along the given map and sum the values. 
Threads should work before catching ConcurrentModificationException. Try to fix the problem with ConcurrentHashMap and Collections.synchronizedMap(). 
What has happened after simple Map implementation exchanging? How it can be fixed in code? Try to write your custom ThreadSafeMap with synchronization and without. 
Run your samples with different versions of Java (6, 8, and 10, 11) and measure the performance. Provide a simple report to your mentor.