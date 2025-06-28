package test;


import org.junit.jupiter.api.Test;
import train.Station;
import train.circular.TrainNode;
import train.circular.TrainSchedule;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TrainScheduleTest {

    @Test
    void testAddAndPrintSchedule() {
        TrainSchedule schedule = new TrainSchedule();

        Station s1 = new Station("CMB", "Colombo", 0, new ArrayList<>());
        Station s2 = new Station("KND", "Kandy", 100, new ArrayList<>());

        ArrayList<Station> route = new ArrayList<>();
        route.add(s1);
        route.add(s2);

        //case like both train having same route since the time realization is ignored

        TrainNode t1 = new TrainNode("T001", route);
        TrainNode t2 = new TrainNode("T002", route);

        schedule.addNode(t1);
        schedule.addNode(t2);

        // Check circular structure manually
        assertNotNull(schedule);
        assertEquals(schedule.head.trainID, "T002");
        assertEquals(schedule.head.next.trainID, "T001");
        assertEquals(schedule.head.next.next.trainID, "T002"); // looped
    }
}