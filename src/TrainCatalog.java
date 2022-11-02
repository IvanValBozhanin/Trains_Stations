import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TrainCatalog {
    private ArrayList<Train> trains;

    /**
     * Default constructor for the TrainCatalog
     */
    public TrainCatalog() {
    }

    /**
     * Getter method for the list of trains
     * @return the list of trains in arraylist format
     */
    public ArrayList<Train> getTrains() {
        return trains;
    }

    /**
     * Method for reading from a given Scanner, which would be file
     * @param in - Scanner from where we are reading in
     */
    public void readData(Scanner in){
        trains = new ArrayList<>();
        in.useDelimiter("END");
        while(in.hasNext()){
            Scanner instance = new Scanner(in.next());
            Train train;
            instance.next();
            String type = instance.next();
            instance.next();
            double depart = Double.parseDouble(instance.next());
            instance.next();
            double arrives = Double.parseDouble(instance.next());
            ArrayList<Station> stations = new ArrayList<>();
            while(instance.hasNext()){
                Station station = new Station(instance.next(), instance.next());
                stations.add(station);
            }
            if(type.equals("INTERCITY")){
                train = new Intercity(arrives, depart, stations);
            } else {
                train = new Sprinter(arrives, depart, stations);
            }
            trains.add(train);
        }
    }

    /**
     * Option 3 of the menu given
     * @param station - the name of the station to be compared
     * @return String of every train that stops at the station
     */
    public String trainsOnStation(String station){
        return trains.stream()
                .filter(x -> (x instanceof Sprinter ?
                        x.getStations().contains(new Station( "IC-STATION:", station)) ||
                        x.getStations().contains(new Station("STATION:", station)) :
                        x.getStations().contains(new Station("IC-STATION:", station))))
                .map(Train::toString)
                .collect(Collectors.joining());
    }

    /**
     * Method for concise info for all trains
     * @return a string with that info
     */
    public String showConcise(){
        String out = "";
        for (Train train :
                trains) {
            out += train.notice() + "\n";
        }
        return out;
    }

    /**
     * Method for full description for all the trains.
     * @return a string with that info
     */
    public String showAll(){
        String out = new String();
        for (Train train :
                trains) {
            out += train.toString() + "\n";
        }
        return out;
    }

    /**
     * Method for full menu of options
     * @return a string with the menu
     */
    public static String menuString(){
        return "Please make your choice: \n" +
                "1 = Show all trains that are in the in-memory database on screen.\n" +
                "2 = Show the travel times of all train lines.\n" +
                "3 = Show all trains that stop at a given station.\n" +
                "4 = Stop the program";
    }

    /**
     * Checks if TrianCatalog is equals to another object.
     * @param o - the to be checked object
     * @return true if equals; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainCatalog)) return false;
        TrainCatalog catalog = (TrainCatalog) o;
        return Objects.equals(trains, catalog.trains);
    }

    /**
     * Hashcode method for Train.
     * @return the hashcode in integer format of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(trains);
    }
}
