package train.graph_station;

import java.util.Objects;

public class Station {

    public String name;

    public Station(String name) {
        this.name = name;
    }

    // Make stations are compared by name
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Station)) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                '}';
    }
}
