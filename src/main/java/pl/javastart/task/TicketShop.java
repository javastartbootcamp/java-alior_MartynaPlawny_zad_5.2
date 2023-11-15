package pl.javastart.task;

public class TicketShop {

    public static void main(String[] args) {
        Ticket ticketOnline = new Ticket("koncert Madonny", "Warszawa", "Online", true);
        Ticket ticketStandard = new Ticket("sylwester z gwiazdami", "Kraków", "Standard", true);
        Ticket ticketGift = new Ticket("voucher do spa", "Krynica", "Gift", true);
        Ticket ticketDataFromUser = Utils.fetchDataFromUser();

        System.out.println("Bilety defaultowe:");
        Ticket[] tickets = {ticketOnline, ticketStandard, ticketGift};

        for (Ticket ticket : tickets) {
            Utils.showInfo(ticket);
        }

        System.out.println("\nBilet wczytany przez użytkownika:");
        Utils.showInfo(ticketDataFromUser);
    }
}
