package Greenest;

import javax.swing.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Greenest {
    protected ArrayList<Plant> allPlants = new ArrayList<>();

    // Konstruktor
    public Greenest() {
        createListOfPlants();
        mainMenuInit();
    }

    //Går enkelt att lägga till fler växter utan att behöva göra ändringar på andra ställen i programmet.
    //Polymorfism.
    public void createListOfPlants() {
        allPlants.add(new Cactus("Igge", 0.2));
        allPlants.add(new PalmTree("Laura", 5));
        allPlants.add(new Carnivorous("Meatloaf", 0.7));
        allPlants.add(new PalmTree("Putte", 1));
    }

    String title = "Greenest växthotell";
    String[] mainMenuOptions = {"Visa alla växter", "sök växt", "Avbryt"};
    ImageIcon plantImage = new ImageIcon("src/Greenest/Images/planthotel.jpg");

    //Startar upp huvudmenyn.
    public void mainMenuInit() {
        int choice = JOptionPane.showOptionDialog(
                null,
                null,
                title,
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                plantImage,
                mainMenuOptions,
                null);

        mainMenuValidator(choice);
    }

    //Skickar användaren vidare beroende på vilken knapp man trycker på.
    public void mainMenuValidator(int choice) {
        while (true) {
            switch (choice) {
                case 0 -> displayPlantsMenu();
                case 1 -> searchMenuInit();
                case 2, -1 -> System.exit(0);
            }
        }

    }

    //startar meny som visar alla växter.
    public void displayPlantsMenu() {
        String info = getAllPlantsInfo(allPlants);
        JOptionPane.showMessageDialog(null, info, title, JOptionPane.INFORMATION_MESSAGE);

        mainMenuInit();
    }

    //Startar menyn som tillåter sökning efter växt.
    public void searchMenuInit() {
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Vilken växt söker du?",
                    title, JOptionPane.INFORMATION_MESSAGE);

            searchMenuShutOffValidator(input);
        }
    }

    //validator som skickar tillbaka användaren till huvudmenyn om man klickar "avbryt" eller "x".
    public void searchMenuShutOffValidator(String input) {
        if (input != null) {
            if (!input.isEmpty()) {
                inputHandler(input);
            }
        } else
            mainMenuInit();
    }

    //Visar resultatet av sökningen för användaren.
    public void inputHandler(String input) {

        try {
            Plant plant = getPlantThroughName(input);
            double value = plant.calculateNutrition();
            JOptionPane.showMessageDialog(null, plant.getName() + " behöver "
                    + value + " liter " + plant.getNutritionType() + ".");
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(null, "Växten finns ej!");
        }
    }

    //Letar igenom listan av växter och matchar med söksträngen.
    public Plant getPlantThroughName(String query) {
        for (Plant plant : allPlants) {
            if (plant.getName().equalsIgnoreCase(query)) {
                return plant;
            }
        }
        throw new NoSuchElementException();
    }

    //metod som visar alla växter i menyn.
    public String getAllPlantsInfo(ArrayList<Plant> allPlants) {
        StringBuilder builder = new StringBuilder();
        int counter = 1;

        for (Plant plant : allPlants) {
            builder.append(counter).append(". ").append(plant.getClassNameToReadable()).append(": ")
                    .append(plant.getName()).append("\n\n");
            counter++;

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // Skapar upp en instans av Greenest, utan referens, för vi kommer aldrig referera till den.
        new Greenest();
    }

}


