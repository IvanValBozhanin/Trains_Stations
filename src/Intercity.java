import java.util.ArrayList;

public class Intercity extends Train{

    /**
     * Constructor for the Intercity object
     * @param arrival - the time of arrival
     * @param departure the time of departure
     * @param stations the list of all stations
     */
    public Intercity(double arrival, double departure, ArrayList<Station> stations) {
        super(arrival, departure, stations);
    }

    /**
     * Method for concise info for the train
     * @return a string with that info
     */
    @Override
    public String notice() {
        String out = "Intercity from " + stations.get(stations.size() - 1).getName()
                + " to " + super.getStations().get(0).getName() + " takes ";
        int minutes = (int) (arrival*100 - departure*100);
        minutes += 60 * (Math.round(arrival - departure));
        out += minutes;
        return out;
    }

    /**
     * Method for full description for  the train.
     * @return a string with that info
     */
    @Override
    public String toString() {
        String out = "Intercity from " + stations.get(stations.size() - 1).getName()
                + " to " + super.getStations().get(0).getName() + "\n";
        out += "Departure: " + departure;
        out += "\nArrival: " + arrival;
        for(int i = stations.size()-1 ; i >= 0 ;--i){
            if(stations.get(i).getType().equals("IC-STATION:")){
                out += "\n---" + stations.get(i).getName();
            } else {
                out += "\n-----(" + stations.get(i).getName() + ")";
            }
        }
        return out+ "\n";
    }

    /**
     * Checks if Intercity is equals to another object.
     * @param o - the to be checked object
     * @return true if equals; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Intercity && super.equals(o);
    }

    /**
     * Hashcode method for Train.
     * @return the hashcode in integer format of the object.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
