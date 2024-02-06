package ru.netology.zadanie;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        // ваш код
        int comparison1 = t1.getTimeTo() - t1.getTimeFrom();
        int comparison2 = t2.getTimeTo() - t2.getTimeFrom();
        return Integer.compare(comparison1, comparison2);
    }
}
