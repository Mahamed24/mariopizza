public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        // Udskriv alle pizzaerne
        for (Pizza pizza : menu.getPizzaer()) {
            System.out.println(pizza);
        }
    }
}
