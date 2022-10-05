package Greenest;

public abstract class Plant implements NutritionCalculator {

    //Inkapsling.
    private String name;
    private double height;
    //Protected så att nutrition enkelt kan läggas i subklassernas konstruktor.
    protected NutritionEnum nutrition;

    public Plant() {
    }

    public Plant(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //Polymorfism.
    public abstract String getNutritionType();

    public abstract String getClassNameToReadable();

}
