package train;

import java.util.ArrayList;

public class TrainJourney {

    private DoublyList track;

    public TrainJourney(DoublyList track) {
        this.track = track;
    }

    // bidirectional representation
    public void representTrack(String start, String end){

        boolean validity = false;
        int direction;

        TrackNode sNode = track.findbyCode(start);
        TrackNode eNode = track.findbyCode(end);

        if (sNode.equals(null) || eNode.equals(null)){
                System.out.println("Invalid Station Code !");
                return;
        }

        int sIndex = track.indexOf(sNode);
        int eIndex = track.indexOf(eNode);

        direction = eIndex - sIndex;
        TrackNode curr = sNode;
        System.out.println("Start from : " + sNode.station);
        if(direction >= 0){
            while (!curr.equals(eNode)){
                //System.out.println("Train Track :\n");
                System.out.println(curr.station);
                curr = curr.next;
            }
        }

        else if (direction<0) {
            while (!curr.equals(eNode)){
                //System.out.println("Train Track :\n");
                System.out.println(curr.station);
                curr = curr.prev;
            }
        }

        System.out.println("Destination : " + eNode.station);
        System.out.println("==============================================================");


    }


    public static void main(String[] args) {


        DoublyList track = new DoublyList();
        ArrayList<Station> a1 = new ArrayList<>();

        Station b1 = new Station("CMB", "Colombo", 0,a1);
        Station b2 = new Station("KND", "Kandy", 100,a1);
        track.addLastNode(b1);
        track.addLastNode(b2);

        track.addLastNode(new Station("JFN", "Jaffna", 300,a1));

        TrainJourney journey = new TrainJourney(track);

// Forward travel: Colombo -> Jaffna
        journey.representTrack("CMB", "JFN");

// Reverse travel: Jaffna -> Colombo
        journey.representTrack("JFN", "CMB");

    }


}
