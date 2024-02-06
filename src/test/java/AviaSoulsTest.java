import org.junit.jupiter.api.Test;
import ru.netology.zadanie.AviaSouls;
import ru.netology.zadanie.Ticket;
import ru.netology.zadanie.TicketTimeComparator;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AviaSoulsTest {
    @Test
    public void ticketCompareTo() {
        Ticket ticket1 = new Ticket("Самара", "Москва", 10_000, 11, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 12_500, 12, 13);
        Ticket ticket3 = new Ticket("Санкт-Петербург", "Самара", 15_000, 13, 15);
        assertTrue(ticket1.compareTo(ticket2) < 0);
        assertTrue(ticket2.compareTo(ticket3) < 0);
        assertTrue(ticket1.compareTo(ticket3) < 0);
        System.out.println("Тест №1 - сравнение");
    }

    @Test
    public void ticketSearch() {
        Ticket ticket1 = new Ticket("Самара", "Москва", 10_000, 11, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 12_500, 12, 13);
        Ticket ticket3 = new Ticket("Санкт-Петербург", "Самара", 15_000, 13, 15);
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        Ticket[] searchResult = manager.search("Самара", "Москва");
        assertArrayEquals(new Ticket[]{ticket1}, searchResult);
        System.out.println("Тест №2 - поиск");
    }

    @Test
    public void ticketTimeComparator() {
        Ticket ticket1 = new Ticket("Самара", "Москва", 10_000, 11, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 12_500, 12, 13);
        Ticket ticket3 = new Ticket("Санкт-Петербург", "Самара", 15_000, 13, 15);
        Ticket[] tickets = {ticket1, ticket2, ticket3};
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Arrays.sort(tickets, timeComparator);
        assertArrayEquals(new Ticket[]{ticket1, ticket2, ticket3}, tickets);
        System.out.println("Тест №3 - время");
    }

    @Test
    public void logicComparator() {
        Ticket ticket1 = new Ticket("Санкт-Петербург", "Самара", 10_000, 11, 12);
        Ticket ticket2 = new Ticket("Санкт-Петербург", "Самара", 12_500, 12, 13);
        Ticket ticket3 = new Ticket("Санкт-Петербург", "Самара", 15_000, 13, 15);
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        Comparator<Ticket> ticketComparator = new TicketTimeComparator();
        Ticket[] searchResult = manager.searchAndSortBy("Санкт-Петербург", "Самара", ticketComparator);
        assertArrayEquals(new Ticket[]{ticket1, ticket2, ticket3}, searchResult);
        System.out.println("Тест №4 - компаратор");
    }
}
