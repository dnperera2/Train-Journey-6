package train.simulation;

import train.passenger_queue.passenger;

import java.util.LinkedList;
import java.util.Queue;

public class StationSim {
    String name;
    Queue<passenger> queue ;

    public StationSim(String name) {
        this.name = name;
        queue = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addPassenger(passenger p){
        queue.add(p);
    }

    public int getPassengerCount(){
       return queue.size();
    }


    public int boardPassengers(SimulationHelp stats){

        int boarded = 0;
        long startTime = System.currentTimeMillis();

        while (!queue.isEmpty()){

            passenger p = queue.poll();
            System.out.println("Boarding " + p.getName() + " at " + name);
            boarded++;

            try
            {
                Thread.sleep(100); //Artificial delay to simulate time
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        long endTime = System.currentTimeMillis();

        Double duration = (double) (endTime - startTime);

        Integer count = boarded;

        stats.recordStat(name, duration, count);
        return boarded;

    }


    public static void main(String[] args) {
        // Create stations
        StationSim colombo = new StationSim("Colombo");
        StationSim kandy = new StationSim("Kandy");

        // Add passengers to stations
        colombo.addPassenger(new passenger("Alice",23));
        colombo.addPassenger(new passenger("Bob",43));
        colombo.addPassenger(new passenger("Charlie",26));

        kandy.addPassenger(new passenger("David",75));
        kandy.addPassenger(new passenger("Eva",89));

        // Stats collector
        SimulationHelp stats = new SimulationHelp();

        // Simulate boarding at each station
        System.out.println(" Starting Train Journey...\n");

        System.out.println("➡ At Colombo Station");
        colombo.boardPassengers(stats);

        System.out.println("➡ At Kandy Station");
        kandy.boardPassengers(stats);

        // Display final stats
        stats.calcStationInfo();
    }





}
