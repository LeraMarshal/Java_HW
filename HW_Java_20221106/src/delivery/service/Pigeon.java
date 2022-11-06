package delivery.service;

public class Pigeon implements MailDeliveryService {
    @Override
    public void sendMail() {
        System.out.println("Голубь?! Серьезно!? в двадцать первом веке?!!! Ты сумасшедший! Я улетаю.");
    }
}
