package test;

import org.junit.jupiter.api.Test;
import train.priority.PriorityTrainQueue;
import train.priority.TrainArrival;

import static org.junit.jupiter.api.Assertions.*;

class PriorityTrainQueueTest {

    @Test
    void testPriorityOrder() {
        PriorityTrainQueue queue = new PriorityTrainQueue();

        TrainArrival express = new TrainArrival("T001", "Express");
        TrainArrival local = new TrainArrival("T002", "Local");

        queue.addTrain(local);
        queue.addTrain(express);

        // first poll should be express (priority 1 vs 3)
        TrainArrival first = queue.pq.poll();
        assertNotNull(first);
        assertEquals("T001", first.trainID);
    }

    @Test
    void testSamePriorityInsertionOrder() {
        PriorityTrainQueue queue = new PriorityTrainQueue();

        TrainArrival e1 = new TrainArrival("T001", "Express");
        TrainArrival e2 = new TrainArrival("T002", "Express");

        queue.addTrain(e1);
        queue.addTrain(e2);

        TrainArrival first = queue.pq.poll();
        TrainArrival second = queue.pq.poll();

        // they have same priority, so insertion order is preserved
        assertEquals("T001", first.trainID);
        assertEquals("T002", second.trainID);
    }

    @Test
    void testProcessingClearsQueue() {
        PriorityTrainQueue queue = new PriorityTrainQueue();
        queue.addTrain(new TrainArrival("T003", "Express"));

        queue.processArrivals();

        assertTrue(queue.pq.isEmpty());
    }
}