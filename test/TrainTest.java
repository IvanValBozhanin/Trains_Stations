import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

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

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("Intercity from Den-Haag-HS to Rotterdam-Centraal\n" +
                "Departure: 14.28\n" +
                "Arrival: 14.48\n" +
                "---Den-Haag-HS\n" +
                "-----(Den-Haag-Moerwijk)\n" +
                "-----(Rijswijk)\n" +
                "---Delft\n" +
                "-----(Delft-Campus)\n" +
                "---Schiedam-Centrum\n" +
                "---Rotterdam-Centraal\n", catalog.getTrains().get(0).toString());
    }

    @org.junit.jupiter.api.Test
    void notice() {
        assertEquals("Intercity from Den-Haag-HS to Rotterdam-Centraal takes 20", catalog.getTrains().get(0).notice());
    }

    @org.junit.jupiter.api.Test
    void getStations() {
        assertEquals(catalog.getTrains().get(0).getStations(), catalog.getTrains().get(0).getStations());
    }

    @org.junit.jupiter.api.Test
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
        assertEquals(catalog1.getTrains().get(0), catalog.getTrains().get(0));
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        assertEquals(catalog.getTrains().get(0).hashCode(), catalog.getTrains().get(0).hashCode());
    }
}