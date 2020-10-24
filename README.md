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

## Task 5

Description

Task 5

Cost: 30 points.

Make an application that contains business logic for making exchange operations between different currencies.

1. Create models for dealing with currencies, user accounts and exchange rates. One account can have multiple currency values. Use BigDecimal for performing of exchange calculations.
2. Data with user accounts should be stored as files (one file per account).
3. Separate application functionality to DAO, service and utilities.
4. Create module which will provide high-level operations (manage accounts, currencies, exchange rates).
5. Create sample accounts and currencies. Define sample exchange rates.
6. Provide concurrent data access to user accounts. Simulate simultaneous currency exchanges for single account by multiple threads and ensure that all the operations are thread-safe.
7. Use ExecutorService to manage threads.
8. Make custom exceptions to let user to know the reason of error. Do not handle runtime exceptions.
9. Validate inputs such an account existence, sufficiency of currency amount, etc.
10. Log information about what is happening on different application levels and about conversion results. Use Logger for that.