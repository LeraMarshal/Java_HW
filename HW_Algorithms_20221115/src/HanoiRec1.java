public class HanoiRec1 {
    public static void main(String[] args) {
        hanoi(6, 1, 3); // 6 дисков, с 1 столбика на 3
    }

    // q - количество дисков для перемещения
    // from -- с какого столбика перемещать
    // to -- на какой столбик перемещать
    private static void hanoi(int q, int from, int to) {
        if (q == 1) { // крайний случай
            System.out.printf("Move disk 1 from %d to %d\n", from, to);
        } else { // рекурентный случай для всех q != 1
            int buf = 6 - from - to; // столбик, который используется в качестве временного

            hanoi(q - 1, from, buf); // что перекладывать, с какого, на какой (q-1 на временный)

            System.out.printf("Move disk %d from %d to %d\n", q, from, to);    // (q на нужный)

            hanoi(q - 1, buf, to);
        }
    }
}
