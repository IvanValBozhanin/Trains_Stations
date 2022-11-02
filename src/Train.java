import java.util.ArrayList;
import java.util.Objects;

public abstract class Train {
    protected double arrival;
    protected double departure;
    protected ArrayList<Station> stations;

    /**
     * Constructor for the Train object
     * @param arrival - the time of arrival
     * @param departure the time of departure
     * @param stations the list of all stations
     */
    public Train(double arrival, double departure, ArrayList<Station> stations) {
        this.arrival = arrival;
        this.departure = departure;
        this.stations = stations;
    }

    /**
     * ToString method for the Train object
     * @return a human friendly String of the object
     */
    @Override
    public abstract String toString();

    /**
     * Method for the concise information of the object
     * @return short description of the object
     */
    public abstract String notice();

    /**
     * Getter for the list of stations
     * @return the list of stations
     */
    public ArrayList<Station> getStations() {
        return stations;
    }

    /**
     * Checks if Train is equal to another object.
     * @param o - the to be checked object
     * @return true if equals; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train train)) return false;
        return Double.compare(train.arrival, arrival) == 0 && Double.compare(train.departure,
                departure) == 0 && Objects.equals(stations, train.stations);
    }

    /**
     * Hashcode method for Train.
     * @return the hashcode in integer format of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(arrival, departure, stations);
    }
}
