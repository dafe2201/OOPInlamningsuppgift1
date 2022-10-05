package Greenest;

public class Carnivorous extends Plant {

    final protected double proteinNeeded = 0.1;

    public Carnivorous(String name, double height) {
        super(name, height);
        nutrition = NutritionEnum.PROTEIN;
    }

    @Override
    public double calculateNutrition() {
        return proteinNeeded + (0.2 * getHeight());
    }

    // Abstract Metod som är dynamisk på alla subklasser, returnerar Nutrition-typ.
    @Override
    public String getNutritionType() {
        return nutrition.toString().toLowerCase();
    }

    @Override
    public String getClassNameToReadable() {
        return "Köttätande växt";
    }


}
