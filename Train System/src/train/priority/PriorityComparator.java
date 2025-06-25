package train.priority;

import java.util.Comparator;

//Custom Comparator
public class PriorityComparator implements Comparator<TrainArrival> {

    @Override
    public int compare(TrainArrival o1, TrainArrival o2) {
        return Integer.compare(o1.priority, o2.priority);

        //Used to compare two trains based on their priority.
        //Lower priority number = comes earlier

        //-1 if t1.priority < t2.priority → t1 goes before t2
        //
        //0 if same priority
        //
        //1 if t1.priority > t2.priority → t2 goes before t1
    }
}