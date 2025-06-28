package test;

import org.junit.jupiter.api.Test;
import train.passenger_queue.passenger;
import train.simulation.SimulationHelp;
import train.simulation.StationSim;

import static org.junit.jupiter.api.Assertions.*;

class StationSimTest {

    @Test
    void testAddPassenger() {
        StationSim station = new StationSim("Colombo");
        station.addPassenger(new passenger("Alice", 1));

        assertEquals(1, station.getPassengerCount());
    }

    @Test
    void testBoardPassengersAndStats() {
        StationSim station = new StationSim("Kandy");
        station.addPassenger(new passenger("Bob", 2));
        station.addPassenger(new passenger("Charlie", 3));

        SimulationHelp stats = new SimulationHelp();
        int boarded = station.boardPassengers(stats);

        assertEquals(2, boarded);
        assertEquals(0, station.getPassengerCount());

        // check statistics map is updated
        stats.calcStationInfo();
    }

    //zero edge case checked
    @Test
    void testEmptyStationBoarding() {
        StationSim station = new StationSim("Galle");

        SimulationHelp stats = new SimulationHelp();
        int boarded = station.boardPassengers(stats);

        assertEquals(0, boarded);
        stats.calcStationInfo();
    }
}
