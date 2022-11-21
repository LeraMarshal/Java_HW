public class MergedArrayElemIndex {
    /*
    2. Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент,
    который будет находиться на k-й позиции в конечном отсортированном массиве.
        Массив 1 - 100 112 256 349 770
        Массив 2 - 72 86 113 119 265 445 892
        к = 7
        Вывод : 256

        Окончательный отсортированный массив - 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
        7-й элемент этого массива равен 256.
     */

    public static void main(String[] args) {
        int[] arr1 = new int[] {100, 112, 256, 349, 770};
        int[] arr2 = new int[] {72, 86, 113, 119, 265, 445, 892};

        System.out.println(getMergedArrayElemIndex(arr1, arr2, 7));
    }

    private static int getMergedArrayElemIndex(int[] arr1, int[] arr2, int k) {
        int totalLength = arr1.length + arr2.length;

        if (k < 1 || k > totalLength) {
            throw new IndexOutOfBoundsException("k must be in range of 1.." + totalLength);
        }

        int lpos = 0;
        int rpos = 0;
        int elem;

        do {
            if (lpos < arr1.length && rpos < arr2.length) {
                if (arr1[lpos] < arr2[rpos]) {
                    elem = arr1[lpos++];
                } else {
                    elem = arr2[rpos++];
                }
            } else if (lpos < arr1.length) {
                elem = arr1[lpos++];
            } else {
                elem = arr2[rpos++];
            }

            k -= 1;
        } while (k > 0);

        return elem;
    }
}
