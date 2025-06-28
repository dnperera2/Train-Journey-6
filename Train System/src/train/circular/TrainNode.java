package train.circular;

import train.Station;

import java.util.List;

public class TrainNode {
    public String trainID;
    List<Station> schedule ;
    public TrainNode next;

    public TrainNode(String trainID, List<Station> schedule) {
        this.trainID = trainID;
        this.schedule = schedule;
    }

    @Override
    public String toString() {

        //This avoids printing entire Station objects (which may cause infinite recursion or clutter).
        StringBuilder stationsStr = new StringBuilder("[");
        for (Station s : schedule) {
            stationsStr.append(s.getCode()).append(", ");
        }
        if (stationsStr.length() > 1) {
            stationsStr.setLength(stationsStr.length() - 2); // remove last comma
        }
        stationsStr.append("]");

        return "TrainNode{" +
                "trainID='" + trainID + '\'' +
                ", schedule=" + stationsStr +
                '}';
    }

}
