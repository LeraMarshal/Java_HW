public class HanoiRec2 {
    public static void main(String[] args) {
        hanoi(3, 1, 3, 2); // 3 диска, с 1 на 3, 2й как промежуточный
    }

    // q - количество дисков для перемещения
    // from -- с какого столбика перемещать
    // to -- на какой столбик перемещать
    // buf -- какой использовать в качестве промежуточного
    private static void hanoi(int q, int from, int to, int buf) {
        if (q == 0) {
            return;
        }

        hanoi(q - 1, from, buf, to);

        System.out.printf("Move disk %d from %d to %d\n", q, from, to);

        hanoi(q - 1, buf, to, from);
    }
}
