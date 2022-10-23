package de.marshal.tickets;

public class Main {
    public static void main(String[] args) {
        /*
         1. Представьте, вы пишите программу для автопарка или, например, для авиакомпании.
         Вам необходимо  создать класс Ticket ,  который должен содержать следующие поля Route route,
         MyDateTime time, double price. Как вы догадываетесь, Route и MyDateTime тоже  классы:
         Route{String number, String  from, String destination, long distance}  MyDateTime (day,month,year,hour,min).

         Далее вам необходимо:
a)      создать несколько разных билетов, положить их в массив.
b)      Реализовать метод, который выводит информацию обо всех билетах
c)      Реализовать метод, который считает суммарную стоимость билетов.
d)      Необходимо посчитать суммарную дистанцию всех маршрутов
            (предположим, что у вас нет билетов с одним и тем же маршрутом,
            т.е. задача сводится к простому суммированию всех distance)
e)      Реализовать в билете метод изменения времени отправления.
         */

        Ticket[] tickets = {
                new Ticket(
                        new Route("1", "from1", "dest1", 1L),
                        new MyDateTime(1, 1, 1, 1, 1),
                        1.1
                ),
                new Ticket(
                        new Route("2", "from2", "dest2", 2L),
                        new MyDateTime(2, 2, 2, 2, 2),
                        2.2
                ),
                new Ticket(
                        new Route("3", "from3", "dest3", 3L),
                        new MyDateTime(3, 3, 3, 3, 3),
                        3.3
                ),
        };

        printTickets(tickets);

        System.out.println("Total ticket's price: " + sumPrice(tickets));
        System.out.println("Total distance: " + sumDistance(tickets));

        tickets[0].setTime(new MyDateTime(4,4,4,4,4));
        printTickets(tickets);
    }

    private static void printTickets(Ticket[] tickets){
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    private static double sumPrice(Ticket[] tickets){
        double sum = 0;
        for (Ticket ticket : tickets) {
            sum += ticket.getPrice();
        }
        return sum;
    }

    private static long sumDistance(Ticket[] tickets){
        long sum = 0;
        for (Ticket ticket : tickets) {
            sum += ticket.getRoute().getDistance();
        }
        return sum;
    }
}
