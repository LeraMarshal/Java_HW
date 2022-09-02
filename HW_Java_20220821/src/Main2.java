public class Main2 {
    public static int N = 3;
    public static int T_MAX = 200;
    public static int T_LOW = 100;
    public static int T_HIGH = 150;
    public static int T_SUM = 250;

    public static void main(String[] args) {
        // Решение second level в общем случае (при N колб).

        int[] flasks = new int[N];

        for (int i = 0; i < N; i = i + 1) {
            flasks[i] = Main.getRandomTemperature(T_MAX);
        }

        int numOfFlasksWithTempGreaterThanTHigh = 0;
        int numOfFlasksWithTempLowerThanTLow = 0;
        int sumOfFlaskTemps = 0;

        for (int i = 0; i < N; i = i + 1) {
            sumOfFlaskTemps = sumOfFlaskTemps + flasks[i];

            if (flasks[i] > T_HIGH) {
                numOfFlasksWithTempGreaterThanTHigh = numOfFlasksWithTempGreaterThanTHigh + 1;
            }

            if (flasks[i] < T_LOW) {
                numOfFlasksWithTempLowerThanTLow = numOfFlasksWithTempLowerThanTLow + 1;
            }
        }

        boolean isRunningCorrectly = numOfFlasksWithTempGreaterThanTHigh == 1
                && numOfFlasksWithTempLowerThanTLow == N - 1
                && sumOfFlaskTemps <= T_SUM;

        for (int i = 0; i < N; i = i + 1) {
            System.out.println("Flask " + i + " = " + flasks[i]);
        }

        System.out.println("Is running correctly: " + isRunningCorrectly);
    }
}
