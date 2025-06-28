package train.graph_station;

import java.util.*;

public class StationGraph {
    public Map<Station, List<Station>> graph = new LinkedHashMap<>();

    public void addStation(String s)
    {
        Station station = new Station(s);
        graph.putIfAbsent(station, new ArrayList<>());
    }

    public void connectStation(String s1, String s2){

        Station station1 = new Station(s1);
        Station station2 = new Station(s2);

        graph.get(station1).add(station2);
        graph.get(station2).add(station1);

    }

    //print all the vertices connected to each node
    public void printAll(){
        for(Station st : graph.keySet()){
            System.out.println("Station => " + st + "connected with :");

            for (Station s : graph.get(st)){
                System.out.println(s);
            }
        }
    }

    public void bfs(String start){
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.println("BFS : ");
        while (!queue.isEmpty()){
            String curr = queue.poll();
            System.out.println(curr + " ");

            for (Station neighbor : graph.get(new Station(curr))){
                if (!visited.contains(neighbor.name)){
                    visited.add(neighbor.name);
                    queue.add(neighbor.name);
                }
            }
        }
        System.out.println();
    }

    public void dfs(String start){
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(start);

        System.out.println("DFS : ");

        while (!stack.isEmpty()){
            String curr = stack.pop();

            if(!visited.contains(curr)){
                visited.add(curr);
                System.out.println(curr);

                for (Station neighbor : graph.get(new Station(curr))){
                    stack.push(neighbor.name);
                }

            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        StationGraph graph = new StationGraph();

        // Add stations
        graph.addStation("Colombo");
        graph.addStation("Gampaha");
        graph.addStation("Kandy");
        graph.addStation("Matara");

        // Connect stations
        graph.connectStation("Colombo", "Gampaha");
        graph.connectStation("Colombo", "Kandy");
        graph.connectStation("Gampaha", "Matara");

        // Print connections
        graph.printAll();

        // Traverse
        graph.bfs("Colombo");
        graph.dfs("Colombo");
    }



}
