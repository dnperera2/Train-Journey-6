package train;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TrainGraph {
    public static void dijkstra(Map<String,Map<String,Integer>> graph, String startStation){

        //store shortest distance
        Map<String, Integer> distances = new HashMap<>();

        //keep track of visited
        Set<String> visited = new HashSet<>();

        //Set all distances to infinity initially
        for (String station : graph.keySet()){
            distances.put(station, Integer.MAX_VALUE);
        }

        //start has distance 0
        distances.put(startStation, 0);

        //===============================================================================================
        //looping until all stations are visited
        while(true){
            String closestStation = null;
            int shortestDis = Integer.MAX_VALUE;

            //find closest unvisited station
            for(String station : graph.keySet()){
                if(!visited.contains(station) && distances.get(station) < shortestDis){
                    shortestDis = distances.get(station);
                    closestStation = station;
                }
            }

            // If there is no unvisited then break the loop
            if(closestStation == null){
                break;
            }

            // Mark chosen as visited
            visited.add(closestStation);



            //=============================================================================================
            //update distance for neighboring stations
            Map<String, Integer> neighbours = graph.get(closestStation);
            for (String neighbor : neighbours.keySet()){
                if(!visited.contains(neighbor)){
                    int newDistance = distances.get(closestStation) + neighbours.get(neighbor);

                    //if we found a shorter path to neighbour then update it

                    if(newDistance< distances.get(neighbor)){
                        distances.put(neighbor, newDistance);
                    }
                }
            }


        }

        System.out.println("Shortest path from + " + startStation +":");
        for (String s : distances.keySet()){
            System.out.println(" -> to "+ s + "= " + distances.get(s) + "km");
        }

    }

    public static void main(String[] args) {
        Map<String, Map<String,Integer>> graph = new HashMap<>();

        Map<String, Integer> col = new HashMap<>();
        col.put("Gampaha", 20);
        col.put("Kandy", 100);
        graph.put("Colombo",col);

        Map<String, Integer> gam = new HashMap<>();
        gam.put("Colombo", 20);
        gam.put("Kurunagala", 50);
        graph.put("Gampaha",gam);


        Map<String, Integer> kan = new HashMap<>();
        kan.put("Colombo", 100);
        kan.put("Kurunagala", 60);
        kan.put("Badulla", 150);
        graph.put("Kandy",kan);

        Map<String, Integer> kur = new HashMap<>();
        kur.put("Gampaha", 50);
        kur.put("Kandy", 60);
        kur.put("Badulla", 100);
        graph.put("Kurunagala",kur);

        Map<String, Integer> bad = new HashMap<>();
        bad.put("Kurunagala", 100);
        bad.put("Kandy", 150);
        graph.put("Badulla",bad);


        dijkstra(graph, "Colombo");



    }

}
