package train.priority;

import java.util.PriorityQueue;

public class PriorityTrainQueue {

    private PriorityQueue<TrainArrival> pq;

    //Comparator ensures lower number = higher priority.
    //PriorityQueue uses this to automatically sort the elements.

    public PriorityTrainQueue(){
        pq = new PriorityQueue<>(new PriorityComparator());
    }

    public void addTrain(TrainArrival t){
        pq.add(t);
    }

    // removes and returns the highest-priority train.

    public void processArrivals() {
        while (!pq.isEmpty()) {
            System.out.println("Processing: " + pq.poll());
        }
    }

    public static void main(String[] args) {
        PriorityTrainQueue arrivalQueue = new PriorityTrainQueue();
        arrivalQueue.addTrain(new TrainArrival("T001", "Express"));
        arrivalQueue.addTrain(new TrainArrival("T002", "Local"));
        arrivalQueue.addTrain(new TrainArrival("T003", "Express"));

        // if 1 == 1 → order remains based on insertion order

        arrivalQueue.processArrivals();

    }



}
