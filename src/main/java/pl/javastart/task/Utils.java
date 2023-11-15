package pl.javastart.task;

import java.util.Scanner;

public class Utils {
    public static double finalPrice(Ticket ticket) {
        double finalPrice;
        double onlinePrice = ticket.getBasePrice() - ticket.getBasePrice() * ticket.getDiscount();
        double standardPrice = onlinePrice + 5;
        double giftPrice = standardPrice + 0.05 * onlinePrice;

        finalPrice = switch (ticket.getTicketType()) {
            case "Online" -> onlinePrice;
            case "Standard" -> standardPrice;
            case "Gift" -> giftPrice;
            default -> throw new IllegalStateException("Niezdefiniowany typ biletu: " + ticket.getTicketType());
        };
        return finalPrice;
    }

    public static void showInfo(Ticket ticket) {
        String extendedDesc = switch (ticket.getTicketType()) {
            case "Online" -> "Bilet internetowy";
            case "Standard" -> "Bilet standardowy";
            case "Gift" -> "Bilet prezentowy";
            default -> throw new IllegalStateException("Niezdefiniowany typ biletu: " + ticket.getTicketType());
        };

        System.out.printf("Id biletu %d, Nazwa wydarzenia: %s, Miejsce wydarzenia: %s, %s: cena podstawowa %.2fzł, " +
                        "zniżka %.0f%%, cena finalna wyniesie %.2fzł\n", ticket.getId(), ticket.getEventName(),
                ticket.getPlace(), extendedDesc, ticket.getBasePrice(), ticket.getDiscount() * 100, finalPrice(ticket));
    }

    public static Ticket fetchDataFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwę wydarzenia: ");
        String eventName = scanner.nextLine();

        System.out.println("Podaj miejsce wydarzenia: ");
        String place = scanner.nextLine();

        System.out.println("Podaj typ biletu (dostępne: Online/Standard/Gift): ");
        String ticketType = scanner.nextLine();

        System.out.println("Czy przysługuje zniżka? (wpisz True/False) ");
        boolean discount = scanner.nextBoolean();

        return new Ticket(eventName, place, ticketType, discount);
    }
}
