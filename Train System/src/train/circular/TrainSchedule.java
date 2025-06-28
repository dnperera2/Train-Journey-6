package train.circular;
import train.Station;
import java.util.ArrayList;

public class TrainSchedule {
    public TrainNode head;

    public void addNode(TrainNode node){

        if(head == null){
            head = node;
            node.next = head;
        }
        else{
            TrainNode tem = head;
            while (tem.next != head){
                tem = tem.next;
            }
            tem.next = node;
            node.next = head;
            head = node;

        }

    }

    public void printSchedule(){
        if (head == null) {
            System.out.println("No trains scheduled.");
            return;
        }

        TrainNode tem = head;
        do {
            System.out.println(tem);
            tem = tem.next;
        }
        while(tem != head);
    }


    public static void main(String[] args) {

                ArrayList<Station> a1 = new ArrayList<>();
                Station b1 = new Station("CMB", "Colombo", 0,new ArrayList<>());
                Station b2 = new Station("KND", "Kandy", 100,new ArrayList<>());

                a1.add(b1);
                a1.add(b2);

                TrainNode t1 = new TrainNode("a13", a1);
                TrainNode t2 = new TrainNode("a22", a1);
                TrainSchedule sch = new TrainSchedule();
                sch.addNode(t1);
                sch.addNode(t2);
                sch.printSchedule();



    }
}
