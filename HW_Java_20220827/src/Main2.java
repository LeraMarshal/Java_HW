public class Main2 {
    private static final int PENALTY_EUR_NUM = 0;
    private static final int DISQUALIFICATION_NUM = 1;

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

        printPenalty(calcPenalty(100, 100, false));
        printPenalty(calcPenalty(100, 109, true));

        printPenalty(calcPenalty(100, 110, false));
        printPenalty(calcPenalty(100, 119, true));

        printPenalty(calcPenalty(100, 120, false));
        printPenalty(calcPenalty(100, 129, true));

        printPenalty(calcPenalty(100, 130, false));
        printPenalty(calcPenalty(100, 139, true));
    }

    public static int[] calcPenalty(int speedLimit, int speed, boolean autobahn) {
        int[] penalties = new int[2];

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

        penalties[PENALTY_EUR_NUM] = penaltyEur;
        penalties[DISQUALIFICATION_NUM] = disqualificationMonths;

        System.out.println("Speed Limit = " + speedLimit);
        System.out.println("Speed = " + speed);
        System.out.println("Autobahn = " + autobahn);

        System.out.println("Speed Limit (110%) = " + speedLimit10);
        System.out.println("Speed Limit (120%) = " + speedLimit20);
        System.out.println("Speed Limit (130%) = " + speedLimit30);

        System.out.println("Penalty EUR = " + penaltyEur);
        System.out.println("Disqualification MON = " + disqualificationMonths);

        return penalties;
    }

    public static void printPenalty(int[] penalties) {
        int penaltyEur = penalties[PENALTY_EUR_NUM];
        int disqualificationMonths = penalties[DISQUALIFICATION_NUM];

        System.out.println("---------");

        if (penaltyEur == 0 && disqualificationMonths == 0) {
            System.out.println("Штраф отсутствует");
        } else if (penaltyEur > 0 && disqualificationMonths == 0) {
            System.out.println("Штраф " + penaltyEur + " euro");
        } else if (penaltyEur == 0 && disqualificationMonths > 0) {
            System.out.println("Лишение прав на" + disqualificationMonths + " мес.");
        } else {
            System.out.println("Штраф " + penaltyEur + " euro и лишение прав на " + disqualificationMonths + " мес.");
        }

        System.out.println();
    }
}
