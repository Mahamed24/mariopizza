import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.time.format.DateTimeFormatter;

public class Bestilling {
    private ArrayList<Pizza> pizzaer;
    private LocalDateTime bestillingsTidspunkt;
    private LocalDateTime afhentningsTidspunkt;
    private static int næsteOrdreNummer = 1; // Static counter to keep track of order numbers
    private int ordreNummer; // Unique order number for each order

    private static ArrayList<Bestilling> bestillinger = new ArrayList<>();


    public Bestilling(ArrayList<Pizza> pizzaer, LocalDateTime bestillingsTidspunkt, LocalDateTime afhentningsTidspunkt) {
        if (pizzaer == null || pizzaer.isEmpty()) {
            throw new IllegalArgumentException("Bestilling skal indeholde mindst én pizza.");
        }
        this.pizzaer = pizzaer;
        this.bestillingsTidspunkt = bestillingsTidspunkt;
        this.afhentningsTidspunkt = afhentningsTidspunkt;
        this.ordreNummer = næsteOrdreNummer++;
    }


    public static void tilføjBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    public static void fjernBestilling(int ordreNummer) {
        bestillinger.removeIf(bestilling -> bestilling.getOrdreNummer() == ordreNummer);
    }

    public int getOrdreNummer() {
        return ordreNummer;
    }

    // Sorteringsmetode
    public static void sorterBestillingerEfterAfhentning() {
        bestillinger.sort(Comparator.comparing(Bestilling::getAfhentningsTidspunkt));
    }

    public LocalDateTime getAfhentningsTidspunkt() {
        return afhentningsTidspunkt;
    }

    // Udskriv bestillinger i sorteret rækkefølge
    public static void udskrivBestillinger() {
        sorterBestillingerEfterAfhentning();
        System.out.println("Liste over bestillinger (sorteret efter afhentningstidspunkt):");
        for (Bestilling bestilling : bestillinger) {
            System.out.println(bestilling);
        }
    }



    public double beregnSamletBeløb() {
        double samletBeløb = 0;
        for (Pizza pizza : pizzaer) {
            samletBeløb += pizza.getPrice();
        }
        return samletBeløb;
    }

        public String toString () {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            StringBuilder sb = new StringBuilder("Ordre #" + ordreNummer + " | Bestilt: "
                    + bestillingsTidspunkt.format(formatter) + " | Afhentning: "
                    + afhentningsTidspunkt.format(formatter) + "\nPizzaer:\n");

            if (pizzaer.isEmpty()) {
                sb.append("Ingen pizzaer i denne bestilling.\n");
            } else {
                for (Pizza pizza : pizzaer) {
                    sb.append(" - ").append(pizza.toString()).append("\n");
                }
            }

            sb.append("Samlet beløb: ").append(beregnSamletBeløb()).append(" Kr");
            return sb.toString();
        }


    }

