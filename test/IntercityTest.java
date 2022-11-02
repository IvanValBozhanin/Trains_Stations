import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class IntercityTest {

    private static TrainCatalog catalog;
    private static Intercity intercity;

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
        intercity = (Intercity) catalog.getTrains().get(0);
    }

    @Test
    void notice() {
        assertEquals("Intercity from Den-Haag-HS to Rotterdam-Centraal takes 20", intercity.notice());
    }

    @Test
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
                "---Rotterdam-Centraal\n", intercity.toString());
    }

    @Test
    void testEquals() {
        assertEquals(intercity, intercity);
    }

    @Test
    void testHashCode() {
        assertEquals(intercity.hashCode(), intercity.hashCode());
    }
}
