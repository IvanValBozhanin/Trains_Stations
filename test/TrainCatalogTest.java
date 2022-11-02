import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TrainCatalogTest {

    private static TrainCatalog catalog;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        catalog = new TrainCatalog();
        catalog.readData(new Scanner("TRAIN: INTERCITY\n" +
                "DEPARTS: 14.28\n" +
                "ARRIVES: 14.48\n" +
                "IC-STATION: Rotterdam-Centraal\n" +
                "IC-STATION: Schiedam-Centrum\n" +
                "STATION: Delft-Campus\n" +
                "IC-STATION: Delft\n" +
                "STATION: Rijswijk\n" +
                "STATION: Den-Haag-Moerwijk\n" +
                "IC-STATION: Den-Haag-HS\n" +
                "END"));
    }

    @Test
    void trainsOnStation() {
        assertEquals("Intercity from Den-Haag-HS to Rotterdam-Centraal\n" +
                "Departure: 14.28\n" +
                "Arrival: 14.48\n" +
                "---Den-Haag-HS\n" +
                "-----(Den-Haag-Moerwijk)\n" +
                "-----(Rijswijk)\n" +
                "---Delft\n" +
                "-----(Delft-Campus)\n" +
                "---Schiedam-Centrum\n" +
                "---Rotterdam-Centraal\n", catalog.trainsOnStation("Delft"));
        TrainCatalog catalog1 = new TrainCatalog();
        catalog1.readData(new Scanner("TRAIN: SPRINTER\n" +
                "DEPARTS: 14.32\n" +
                "ARRIVES: 15.00\n" +
                "IC-STATION: Rotterdam-Centraal\n" +
                "IC-STATION: Schiedam-Centrum\n" +
                "STATION: Delft-Campus\n" +
                "IC-STATION: Delft\n" +
                "STATION: Rijswijk\n" +
                "STATION: Den-Haag-Moerwijk\n" +
                "IC-STATION: Den-Haag-HS\n" +
                "END"));
        assertEquals("Sprinter from Den-Haag-HS to Rotterdam-Centraal\n" +
                "Departure: 14.32\n" +
                "Arrival: 15.0\n" +
                "---Den-Haag-HS\n" +
                "---Den-Haag-Moerwijk\n" +
                "---Rijswijk\n" +
                "---Delft\n" +
                "---Delft-Campus\n" +
                "---Schiedam-Centrum\n" +
                "---Rotterdam-Centraal\n", catalog1.trainsOnStation("Delft"));
        TrainCatalog catalog2 = new TrainCatalog();
        catalog2.readData(new Scanner("TRAIN: SPRINTER\n" +
                "DEPARTS: 14.28\n" +
                "ARRIVES: 14.48\n" +
                "IC-STATION: Rotterdam-Centraal\n" +
                "IC-STATION: Schiedam-Centrum\n" +
                "STATION: Delft-Campus\n" +
                "STATION: Delft\n" +
                "STATION: Rijswijk\n" +
                "STATION: Den-Haag-Moerwijk\n" +
                "IC-STATION: Den-Haag-HS\n" +
                "END"));
        assertEquals("Sprinter from Den-Haag-HS to Rotterdam-Centraal\n" +
                "Departure: 14.28\n" +
                "Arrival: 14.48\n" +
                "---Den-Haag-HS\n" +
                "---Den-Haag-Moerwijk\n" +
                "---Rijswijk\n" +
                "---Delft\n" +
                "---Delft-Campus\n" +
                "---Schiedam-Centrum\n" +
                "---Rotterdam-Centraal\n",  catalog2.trainsOnStation("Delft"));
    }

    @Test
    void showConcise() {
        assertEquals("Intercity from Den-Haag-HS to Rotterdam-Centraal takes 20\n", catalog.showConcise());
    }

    @Test
    void showAll() {
        assertEquals("Intercity from Den-Haag-HS to Rotterdam-Centraal\n" +
                "Departure: 14.28\n" +
                "Arrival: 14.48\n" +
                "---Den-Haag-HS\n" +
                "-----(Den-Haag-Moerwijk)\n" +
                "-----(Rijswijk)\n" +
                "---Delft\n" +
                "-----(Delft-Campus)\n" +
                "---Schiedam-Centrum\n" +
                "---Rotterdam-Centraal\n" +
                "\n", catalog.showAll());
    }

    @Test
    void menuString() {
        assertEquals("Please make your choice: \n" +
                "1 = Show all trains that are in the in-memory database on screen.\n" +
                "2 = Show the travel times of all train lines.\n" +
                "3 = Show all trains that stop at a given station.\n" +
                "4 = Stop the program", TrainCatalog.menuString());
    }

    @Test
    void testEquals() {
        TrainCatalog catalog1 = new TrainCatalog();
        catalog1.readData(new Scanner("TRAIN: INTERCITY\n" +
                "DEPARTS: 14.28\n" +
                "ARRIVES: 14.48\n" +
                "IC-STATION: Rotterdam-Centraal\n" +
                "IC-STATION: Schiedam-Centrum\n" +
                "STATION: Delft-Campus\n" +
                "IC-STATION: Delft\n" +
                "STATION: Rijswijk\n" +
                "STATION: Den-Haag-Moerwijk\n" +
                "IC-STATION: Den-Haag-HS\n" +
                "END"));
        assertEquals(catalog, catalog1);
    }

    @Test
    void testHashCode() {
        assertEquals(catalog.hashCode(), catalog.hashCode());

    }
}