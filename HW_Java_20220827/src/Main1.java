public class Main1 {
    public static void main(String[] args) {
        /*
        Second level: Представьте, Вы пишите программу  для расчета штрафов за превышение скорости.
        В качестве исходных данных у вас: ограничение скорости на данном участке дороги, скорость,
        с которой двигался автомобиль и признак того, что нарушение было совершено на автобане.
        Естественно, все три значения заданы переменными. Таблица штрафов такая:
            превышение менее 10% от скоростного ограничения – не штрафуется
            10% - менее 20%   от скоростного ограничения – 50 евро
            20% - менее 30%   от скоростного ограничения – 150 евро не на автобане, и 200 на автобане
            от 30% и выше  - 500евро плюс, если нарушение на автобане, лишение прав на 3 месяца.
        Реализуйте программу, которая рассчитывает штраф и выводит соответствующее сообщение на экран.
        */

        int speedLimit = 100;    // км/ч
        int speed = 140;         // км/ч
        boolean autobahn = true; // Нарушение на автобане или нет.

        int speedLimit10 = Math.round(speedLimit * 1.10f); // скорость, с которой начинается ее превышение на 10%
        int speedLimit20 = Math.round(speedLimit * 1.20f); // скорость, с которой начинается ее превышение на 20%
        int speedLimit30 = Math.round(speedLimit * 1.30f); // скорость, с которой начинается ее превышение на 30%

        int penaltyEur;
        int disqualificationMonths;

        if (speed < speedLimit10) {
            penaltyEur = 0;
            disqualificationMonths = 0;
        } else if (speed < speedLimit20) {
            penaltyEur = 50;
            disqualificationMonths = 0;
        } else if (speed < speedLimit30) {
            penaltyEur = (autobahn) ? 200 : 150;
            disqualificationMonths = 0;
        } else {
            penaltyEur = 500;
            disqualificationMonths = (autobahn) ? 3 : 0;
        }

        System.out.println("Speed Limit = " + speedLimit);
        System.out.println("Speed = " + speed);
        System.out.println("Autobahn = " + autobahn);

        System.out.println("Speed limit (110%) = " + speedLimit10);
        System.out.println("Speed limit (120%) = " + speedLimit20);
        System.out.println("Speed limit (130%) = " + speedLimit30);

        if (penaltyEur == 0 && disqualificationMonths == 0) {
            System.out.println("Штраф отсутствует");
        } else if (penaltyEur > 0 && disqualificationMonths == 0) {
            System.out.println("Штраф " + penaltyEur + " euro");
        } else if (penaltyEur == 0 && disqualificationMonths > 0) {
            System.out.println("Лишение прав на" + disqualificationMonths + " мес.");
        } else {
            System.out.println("Штраф " + penaltyEur + " euro и лишение прав на " + disqualificationMonths + " мес.");
        }
    }
}
