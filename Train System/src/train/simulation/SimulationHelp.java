package train.simulation;

import java.util.HashMap;

public class SimulationHelp {
    private HashMap<String, Double> timePerStation = new HashMap<>();
    private HashMap<String, Integer> passengerPerStation = new HashMap<>();


    public void recordStat(String station, Double time, Integer passengers){
        passengerPerStation.put(station,passengers);
        timePerStation.put(station,time);

    }

    public void calcStationInfo(){

        System.out.println("\n Journey Statistics Summary:");
        for (String station : passengerPerStation.keySet()){

            Integer count = passengerPerStation.get(station);
            double time = timePerStation.get(station);
            double avgTime = (count > 0) ? (time / count) : 0;


            //stats
            System.out.println("Station: " + station);
            System.out.println(" - Passengers Boarded: " + count);
            System.out.println(" - Total Boarding Time: " + time + " ms");
            System.out.println(" - Avg Time per Passenger: " + String.format("%.2f", avgTime) + " ms\n");

        }


    }


}
