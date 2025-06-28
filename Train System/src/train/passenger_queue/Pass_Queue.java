package train.passenger_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Pass_Queue {
    public Queue<passenger> queue;

    public Pass_Queue() {
        queue = new LinkedList<>();
    }

    public void boardPassenger(String name, int id){
        queue.add(new passenger(name,id));
    }

    public void returnTicket(int id){

        boolean found = false;
        //have to use iterator since we can not remove while looping a collection
        Iterator<passenger> itr = queue.iterator();
        while(itr.hasNext()){
            passenger p = itr.next();

            if (p.getTicketID() == id){
                found = true;
                itr.remove();
            }
        }
        if(!found){
            System.out.println("No entries found");
        }

    }

    public void printBoardList(){
        Queue<passenger> q = queue;
        System.out.println("Onboarding List is: ");
        while (!q.isEmpty()){
            System.out.println(q.poll());
        }
    }


    public static void main(String[] args) {
        Pass_Queue pq = new Pass_Queue();
        pq.boardPassenger("Alice", 1);
        pq.boardPassenger("Bob", 2);
        pq.boardPassenger("Bobby", 5);
        pq.boardPassenger("Nim", 3);
        pq.returnTicket(2);
        pq.printBoardList();

    }


}
