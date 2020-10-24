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

## Task 4

Description

Task 4

Cost: 20 points.

Create simple object pool with support for multithreaded environment. No any extra inheritance, polymorphism or generics needed here, just implementation of simple class:

/** * Pool that block when it has not any items or it full */ public class BlockingObjectPool 
{ /** * Creates filled pool of passed size * * @param size of pool */ 
public BlockingObjectPool(int size) { ... } /** * Gets object from pool or blocks 
if pool is empty * * @return object from pool */ public Object get() { ... } /** * 
Puts object to pool or blocks if pool is full * * @param object to be taken back to pool 
*/ public void take(Object object) { ... } }

Use any blocking approach you like.