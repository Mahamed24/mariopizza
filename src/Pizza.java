public class Pizza {
    private String name;
    private String ingredients;
    private double price;


    public Pizza(String name, String ingredients, double price) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;

    }


    public String toString() {
        return name + " - " + ingredients + " - " + price + " Kr";

    }
}
