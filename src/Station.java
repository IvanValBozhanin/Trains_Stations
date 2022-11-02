import java.util.Objects;

public class Station {
    private String name;
    private String type;

    /**
     * Constructor for Station object
     * @param name of the station
     * @param type of the station
     */
    public Station(String type, String name) {
        this.name = name;
        this.type = type;
    }

    /**
     * Checks if Station is equal to another object.
     * @param o - the to be checked object
     * @return true if equals; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name) && Objects.equals(type, station.type);
    }

    /**
     * Hashcode method for Train.
     * @return the hashcode in integer format of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    /**
     * Getter method of the name
     * @return the name of the station
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method of the type
     * @return the type of the station
     */
    public String getType() {
        return type;
    }
}
