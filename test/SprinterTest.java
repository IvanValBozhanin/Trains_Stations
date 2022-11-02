import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SprinterTest {

    TrainCatalog catalog = new TrainCatalog();
    Sprinter sprinter;

    @BeforeEach
    void setUp(){
        catalog = new TrainCatalog();
        catalog.readData(new Scanner("TRAIN: SPRINTER\n" +
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
        sprinter = (Sprinter) catalog.getTrains().get(0);
    }

    @Test
    void testToString() {
        assertEquals("Sprinter from Den-Haag-HS to Rotterdam-Centraal\n" +
                "Departure: 14.32\n" +
                "Arrival: 15.0\n" +
                "---Den-Haag-HS\n" +
                "---Den-Haag-Moerwijk\n" +
                "---Rijswijk\n" +
                "---Delft\n" +
                "---Delft-Campus\n" +
                "---Schiedam-Centrum\n" +
                "---Rotterdam-Centraal\n", sprinter.toString());
    }

    @Test
    void notice() {
        assertEquals("Sprinter from Den-Haag-HS to Rotterdam-Centraal takes 28", sprinter.notice());
    }

    @Test
    void testEquals() {
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
        assertEquals(catalog1.getTrains().get(0), sprinter);
    }

    @Test
    void testHashCode() {
        assertEquals(sprinter.hashCode(), sprinter.hashCode());
    }
}