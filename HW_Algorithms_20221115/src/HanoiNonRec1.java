import java.util.Stack;

public class HanoiNonRec1 {
    public static void main(String[] args) {
        hanoi(3); // n дисков на первом столбике
    }

    // n - количество дисков на первом столбике
    private static void hanoi(int n) {
        Stack<Integer>[] stacks = new Stack[]{
                new Stack<Integer>(),
                new Stack<Integer>(),
                new Stack<Integer>()
        };

        // добавляем диски в первый стэк с 1 по n
        for (int i = 1; i <= n; i++) {
            stacks[0].add(i);
        }

        if (n % 2 == 0) {
            while(stacks[0].size() > 0) {
                move(stacks, 0, 1);
                move(stacks, 0, 2);
                move(stacks, 1, 2);
            }
        } else {
            while (stacks[0].size() > 0) {
                move(stacks, 0, 2);
                move(stacks, 0, 1);
                move(stacks, 1, 2);
            }
        }
    }

    // stacks - наши столбики
    // from - с какого
    // to - на какой
    private static void move(Stack<Integer>[] stacks, int from, int to) {
        // если задача выполнена, перемещений не делаем, даже если можем
        if (stacks[0].size() == 0 && stacks[1].size() == 0) {
            return;
        }

        // если нечего перемещать, то ничего не делаем
        if (stacks[from].size() == 0 && stacks[to].size() == 0) {
            return;
        }

        if (stacks[from].size() == 0 && stacks[to].size() > 0) {
            // to -> from
            doMove(stacks, to, from);
        } else if (stacks[from].size() > 0 && stacks[to].size() == 0) {
            // from -> to
            doMove(stacks, from, to);
        } else {
            Integer valFrom = stacks[from].peek();
            Integer valTo = stacks[to].peek();

            if (valFrom > valTo) {
                // from -> to
                doMove(stacks, from, to);
            } else {
                // to -> from
                doMove(stacks, to, from);
            }
        }
    }

    // stacks - наши столбики
    // from - с какого
    // to - на какой
    private static void doMove(Stack<Integer>[] stacks, int from, int to) {
        Integer elem = stacks[from].pop();
        stacks[to].push(elem);

        System.out.printf("Moving disk %d from %d to %d\n", elem, from, to);
    }
}
