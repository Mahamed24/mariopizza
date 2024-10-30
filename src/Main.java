public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        boolean running = true; // Når denne bliver falsk stopper loopet med at køre og programmer slutter.

        while (running) {

            System.out.println();
            System.out.println("-----Marios Pizzabar-----");
            System.out.println("Tast 1 for at se menukort.");
            System.out.println("Tast 2 for at lave en ny bestilling");
            System.out.println("Tast 3 for at se alle bestillinger");
            System.out.println("Tast 4 for at fjerne en bestilling");
            System.out.println("Tast 5 for at afslutte programmet");
            System.out.println("Vælg en mulighed");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("----Menukort----");
                    for (Pizza pizza : menu.getPizzaer()) {
                        System.out.println(pizza);
                    }
                    break;

                case 2:
                    ArrayList<Pizza> valgtePizzaer = new ArrayList<>();

                    boolean flerePizzaer = true;
                    while (flerePizzaer) {
                        System.out.println("Indtast pizza nummer (eller 0 for at afslutte valg):");
                        int pizzaNummer = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (pizzaNummer == -1) { // Bruger indtaster 0 for at afslutte valg
                            flerePizzaer = false;
                        } else if (pizzaNummer >= 0 && pizzaNummer < menu.getPizzaer().size()) {
                            Pizza valgtPizza = menu.getPizzaer().get(pizzaNummer);
                            valgtePizzaer.add(valgtPizza);
                            System.out.println("Tilføjet: " + valgtPizza);
                        } else {
                            System.out.println("Ugyldigt pizza nummer, prøv igen.");
                        }
                    }

                    if (!valgtePizzaer.isEmpty()) {
                        LocalDateTime bestillingsTidspunkt = LocalDateTime.now();


                        System.out.println("Indtast afhentningstidspunkt (TT MM):");
                        int afhentningTime = scanner.nextInt();
                        int afhentningMinut = scanner.nextInt();
                        scanner.nextLine();

                        LocalDateTime afhentningsTidspunkt = LocalDateTime.of(
                                bestillingsTidspunkt.getYear(),
                                bestillingsTidspunkt.getMonth(),
                                bestillingsTidspunkt.getDayOfMonth(),
                                afhentningTime,
                                afhentningMinut
                        );

                        Bestilling nyBestilling = new Bestilling(valgtePizzaer, bestillingsTidspunkt, afhentningsTidspunkt);
                        Bestilling.tilføjBestilling(nyBestilling);

                        System.out.println("Bestilling tilføjet: " + nyBestilling);
                    } else {
                        System.out.println("Ingen pizzaer valgt til bestillingen.");
                    }
                    break;

                case 3:
                    System.out.println();
                    Bestilling.udskrivBestillinger(); // Kalder metoden som sorterer og udskriver bestillingerne
                    break;

                case 4:
                    System.out.println("Indtast ordre nummer på bestillingen, der skal fjernes:");
                    int ordreNummer = scanner.nextInt();
                    scanner.nextLine(); // Clear newline
                    Bestilling.fjernBestilling(ordreNummer);
                    System.out.println("Bestilling fjernet hvis den eksisterede.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Programmet afsluttes");
                    break;

                default:
                    System.out.println("Ugyldig indtastning, prøv igen.");
            }
        }
        scanner.close();
    }
}
