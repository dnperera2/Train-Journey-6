package test;

import org.junit.jupiter.api.Test;
import train.graph_station.Station;
import train.graph_station.StationGraph;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StationGraphTest {

    @Test
    void testBfsAndDfsOrder() {
        StationGraph graph = new StationGraph();

        graph.addStation("Colombo");
        graph.addStation("Kandy");
        graph.addStation("Galle");
        graph.addStation("Matara");

        graph.connectStation("Colombo", "Kandy");
        graph.connectStation("Colombo", "Galle");
        graph.connectStation("Kandy", "Matara");

        // BFS order
        List<String> bfsVisited = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add("Colombo");
        visited.add("Colombo");

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            bfsVisited.add(curr);

            for (Station neighbor : graph.graph.get(new Station(curr))) {
                if (!visited.contains(neighbor.name)) {
                    visited.add(neighbor.name);
                    queue.add(neighbor.name);
                }
            }
        }


        List<String> expectedBfs = Arrays.asList("Colombo", "Kandy", "Galle", "Matara");
        assertEquals(expectedBfs, bfsVisited);

        // DFS order
        List<String> dfsVisited = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Set<String> visitedDfs = new HashSet<>();
        stack.push("Colombo");

        while (!stack.isEmpty()) {
            String curr = stack.pop();
            if (!visitedDfs.contains(curr)) {
                dfsVisited.add(curr);
                visitedDfs.add(curr);

                // to get deterministic order:
                // push neighbors in reverse
                List<Station> neighbors = graph.graph.get(new Station(curr));
                ListIterator<Station> itr = neighbors.listIterator(neighbors.size());
                while (itr.hasPrevious()) {
                    stack.push(itr.previous().name);
                }
            }
        }


        List<String> expectedDfs = Arrays.asList("Colombo", "Kandy", "Matara", "Galle");
        assertEquals(expectedDfs, dfsVisited);
    }

}