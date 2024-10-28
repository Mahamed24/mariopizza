import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bestilling {
    private Pizza pizza;
    private LocalDateTime bestillingsTidspunkt;
    private LocalDateTime afhentningsTidspunkt;

    // Liste til at holde alle bestillinger
    private static ArrayList<Bestilling> bestillinger = new ArrayList<>();

    // Konstruktor til en enkelt bestilling
    public Bestilling(Pizza pizza, LocalDateTime bestillingsTidspunkt, LocalDateTime afhentningsTidspunkt) {
        this.pizza = pizza;
        this.bestillingsTidspunkt = bestillingsTidspunkt;
        this.afhentningsTidspunkt = afhentningsTidspunkt;
    }

    // Tilføjer en bestilling til listen
    public static void tilføjBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    // Udskriver alle bestillinger
    public static void udskrivBestillinger() {
        System.out.println("Liste over bestillinger:");
        for (Bestilling bestilling : bestillinger) {
            System.out.println(bestilling);
        }
    }
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return pizza.toString() + " | Bestilt: " + bestillingsTidspunkt.format(formatter) + " | Afhentning: " + afhentningsTidspunkt.format(formatter);
    }
    }



