import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * Main method that executes the program
     * @param args - array of strings that takes as parameters
     */
    public static void main(String[] args) {
        Scanner file = new Scanner(System.in);
        System.out.println("Enter resource file: ");
        String fileName = file.next();
        try(Scanner in = new Scanner(new File(fileName))){
            TrainCatalog catalog = new TrainCatalog();
            catalog.readData(in);
            while (true) {
                System.out.println(TrainCatalog.menuString());
                Scanner command = new Scanner(System.in);
                switch (command.nextInt()) {
                    case 1 -> System.out.println(catalog.showAll());
                    case 2 -> System.out.println(catalog.showConcise());
                    case 3 -> {
                        System.out.println("Which station: ");
                        System.out.println(catalog.trainsOnStation(command.next()));
                    }
                    case 4 -> System.exit(0);
                }
            }
        } catch (IOException ignored){}
    }
}
