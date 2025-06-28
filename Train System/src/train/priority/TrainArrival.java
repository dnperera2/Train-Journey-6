package train.priority;

import java.util.Comparator;

public class TrainArrival {
    public String trainID;
    String type;
    int priority;

    public TrainArrival(String trainID, String type) {
        this.trainID = trainID;
        this.type = type;
        this.priority = (type.equals("Express") || type.equals("express")) ? 1 : 3;
    }

    @Override
    public String toString() {
        return "TrainArrival{" +
                "trainID='" + trainID + '\'' +
                ", type='" + type + '\'' +

                '}';
    }





}
