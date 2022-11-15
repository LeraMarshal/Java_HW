import java.util.Stack;

public class HanoiNonRec2 {
    public static void main(String[] args) {
        hanoi(3); // n дисков на 1м столбике
    }

    // как мы знаем, любая рекурсивная задача может быть сведена к итеративной
    // так что возьмем и сделаем рекурсию без рекурсии :)
    private static void hanoi(int n) {
        Stack<Task> tasks = new Stack<>();

        tasks.push(new HanoiTask(n, 1, 3, 2));

        // цикл пока очередь задач не пуста
        while (tasks.size() > 0) {
            Task task = tasks.pop();

            if (task instanceof HanoiTask) {
                // основная задача
                HanoiTask hanoiTask = (HanoiTask) task;

                if (hanoiTask.q == 0) {
                    // базовый случай
                    continue;
                }

                // задачи добавляем в обратном порядке
                tasks.push(new HanoiTask(hanoiTask.q - 1, hanoiTask.buf, hanoiTask.to, hanoiTask.from));
                tasks.push(new MoveTask(hanoiTask.q, hanoiTask.from, hanoiTask.to));
                tasks.push(new HanoiTask(hanoiTask.q - 1, hanoiTask.from, hanoiTask.buf, hanoiTask.to));
            } else if (task instanceof MoveTask) {
                // перемещение
                MoveTask moveTask = (MoveTask) task;
                System.out.printf("Moving disk %d from %d to %d\n", moveTask.q, moveTask.from, moveTask.to);
            }
        }
    }

    private static abstract class Task {
    }

    private static class HanoiTask extends Task {
        // q - количество дисков для перемещения
        int q;

        // from -- с какого столбика перемещать
        int from;

        // to -- на какой столбик перемещать
        int to;

        // buf -- какой использовать в качестве промежуточного
        int buf;

        public HanoiTask(int q, int from, int to, int buf) {
            this.q = q;
            this.from = from;
            this.to = to;
            this.buf = buf;
        }
    }

    private static class MoveTask extends Task {
        // какой диск перемещаем
        int q;

        // откуда
        int from;

        // куда
        int to;

        public MoveTask(int q, int from, int to) {
            this.q = q;
            this.from = from;
            this.to = to;
        }
    }
}