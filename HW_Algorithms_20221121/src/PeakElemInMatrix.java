public class PeakElemInMatrix {
    /*
    4* Найдите пиковый элемент в двумерном массиве

    Элемент является пиковым, если он больше или равен своим четырем соседям слева, справа, сверху и снизу.
    Например, соседями для A[i][j] являются A[i-1][j], A[i+1][j], A[i][j-1] и A[i][j+1 ].
    Для угловых элементов отсутствующие соседи считаются отрицательными бесконечными значениями.
    10 20 15
    21 30 14
     7 16 32

    Выход: 30
    30 — пиковый элемент, потому что все его
    соседи меньше или равны ему.
    32 также можно выбрать в качестве пика.

    note
    1 Смежная диагональ не считается соседней.
    2 Пиковый элемент не обязательно является максимальным элементом.
    3 Таких элементов может быть несколько.
    4 Всегда есть пиковый элемент.
     */

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                new int[]{10, 20, 15},
                new int[]{21, 30, 14},
                new int[]{7, 16, 32}
        };

        System.out.println(getPeakElemInMatrix(arr, 0, 0));
    }

    private static int getPeakElemInMatrix(int[][] arr, int i, int j) {
        int currentElem = getElem(arr, i, j);

        int topElem = getElem(arr, i - 1, j);
        int rightElem = getElem(arr, i, j + 1);
        int bottomElem = getElem(arr, i + 1, j);
        int leftElem = getElem(arr, i, j - 1);

        // Порядок обхода: вверх, вправо, вниз, влево
        if (topElem > currentElem) {
            // Вверху элемент больше, продолжаем обход вверх
            return getPeakElemInMatrix(arr, i - 1, j);
        } else if (rightElem > currentElem) {
            // Справа элемент больше, продолжаем обход вправо
            return getPeakElemInMatrix(arr, i, j + 1);
        } else if (bottomElem > currentElem) {
            // Снизу элемент больше, продолжаем обход вниз
            return getPeakElemInMatrix(arr, i + 1, j);
        } else if (leftElem > currentElem) {
            // Слева элемент больше, продолжаем обход влево
            return getPeakElemInMatrix(arr, i, j - 1);
        }

        // Наш элемент является пиковым
        return currentElem;
    }

    private static int getElem(int[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length) {
            return Integer.MIN_VALUE;
        }

        if (j < 0 || j >= arr[i].length) {
            return Integer.MIN_VALUE;
        }

        return arr[i][j];
    }
}
