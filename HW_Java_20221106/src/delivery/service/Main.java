package delivery.service;

import java.util.Scanner;

public class Main {
    /*
    • Создать интерфейс MailDeliveryService с одним методом void sendMail().
    • Создайте класс DHL, который должен реализовать интерфейс MailDeliveryService.
            Его способ отправки почты — напечатать что-то вроде: «Положи письмо в конверт, поставь марку, отправь».
    • Создайте класс Email, который должен реализовать интерфейс MailDeliveryService.
            Его способ отправки почты - напечатать что-то вроде: «Отправить по Интернету».
    • Создайте класс Pigeon, который должен реализовать интерфейс MailDeliveryService.
            Его способ отправки почты — напечатать что-то вроде: «Голубь?! Серьезно!? в двадцать первом веке?!!! Ты сумасшедший! Я улетаю»
    • Создайте класс Sender. Реализуйте в нем метод send(), который в качестве аргумента MailDeliveryService и отправляет почту с помощью данной службы.
    • Реализуйте диалог с пользователем (использовать Scanner), как отправлять почту и отправлять ее с помощью Sender.
     */
    public static void main(String[] args) {
        Sender sender = new Sender();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите способ доставки:\n1. Pigeon\n2. Email\n3. DHL");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                sender.send(new Pigeon());
                break;
            case 2:
                sender.send(new Email());
                break;
            case 3:
                sender.send(new DHL());
                break;
            default:
                throw new IllegalArgumentException("Неверный способ доставки");

        }
    }
}
