package train;

import java.util.List;

public class Station {
    private String code;
    private String name;
    private double distanceFromStart;
    private List<Station> connectedStations;


    public Station(String code, String name, double distanceFromStart, List<Station> connectedStations) {
        this.code = code;
        this.name = name;
        this.distanceFromStart = distanceFromStart;
        this.connectedStations = connectedStations;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistanceFromStart() {
        return distanceFromStart;
    }

    public void setDistanceFromStart(double distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }

    public List<Station> getConnectedStations() {
        return connectedStations;
    }

    public void setConnectedStations(List<Station> connectedStations) {
        this.connectedStations = connectedStations;
    }

    @Override
    public String toString() {
        return "Station{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", distanceFromStart=" + distanceFromStart +
                ", connectedStations=" + connectedStations +
                '}';
    }
}
