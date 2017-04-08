# n26Test
N26 home test without H2 database embedded.

Hi Guys!

I have started using H2 Database for store the Transactions, but how you didn't make any mention for that I changed for an ArrayList.

I didn't use the LinkedList because the chronological input was not relevant for test, because I always use the timestamp field for calculate if the Transaction was in the last 60 seconds.
