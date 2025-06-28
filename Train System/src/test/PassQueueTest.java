package test;

import org.junit.jupiter.api.Test;
import train.passenger_queue.Pass_Queue;

import static org.junit.jupiter.api.Assertions.*;

public class PassQueueTest {
    @Test
    void testBoardPassengerAndPrint() {
        Pass_Queue pq = new Pass_Queue();
        pq.boardPassenger("Alice", 1);
        pq.boardPassenger("Bob", 2);

        assertEquals(2, pq.queue.size());
        assertEquals("Alice", pq.queue.peek().getName()); // FIFO
    }

    @Test
    void testReturnTicketSuccess() {
        Pass_Queue pq = new Pass_Queue();
        pq.boardPassenger("Alice", 1);
        pq.boardPassenger("Bob", 2);

        pq.returnTicket(2);

        assertEquals(1, pq.queue.size());
        assertEquals(1, pq.queue.peek().getTicketID());
    }

    @Test
    void testReturnTicketNonExistent() {
        Pass_Queue pq = new Pass_Queue();
        pq.boardPassenger("Alice", 1);

        pq.returnTicket(99); // no such ticket
        assertEquals(1, pq.queue.size()); // unchanged
    }

    @Test
    void testMultipleBoardingAndOrder() {
        Pass_Queue pq = new Pass_Queue();
        pq.boardPassenger("Alice", 1);
        pq.boardPassenger("Bob", 2);
        pq.boardPassenger("Charlie", 3);

        // Check boarding order is maintained
        assertEquals("Alice", pq.queue.peek().getName());
    }
}
