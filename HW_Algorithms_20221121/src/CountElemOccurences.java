public class CountElemOccurences {
    /*
    3. Имея отсортированный массив arr[] и число x, напишите функцию, которая подсчитывает
    вхождения x в arr[]. Ожидаемая временная сложность O(Log n)

    arr[] = {1, 1, 2, 2, 2, 2, 3}
    x = 2
    Вывод: 4 раза
     */

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 2, 3};

        System.out.println(countElemOccurences(arr, 2)); // 4
        System.out.println(countElemOccurences(arr, 1)); // 2
        System.out.println(countElemOccurences(arr, 3)); // 1
        System.out.println(countElemOccurences(arr, 4)); // 0

        System.out.println(countElemOccurences(new int[]{}, 1)); // 0
        System.out.println(countElemOccurences(new int[]{1}, 1)); // 1
        System.out.println(countElemOccurences(new int[]{1, 1}, 1)); // 2
        System.out.println(countElemOccurences(new int[]{2, 2}, 1)); // 0
        System.out.println(countElemOccurences(new int[]{1, 1, 1}, 1)); // 3
        System.out.println(countElemOccurences(new int[]{2, 2, 2}, 1)); // 0
    }

    private static int countElemOccurences(int[] arr, int x) {
        if (arr.length == 0) {
            return 0;
        }

        int lposL = 0;
        int lposR = arr.length - 1;

        while (lposL <= lposR) {
            int middle = (lposL + lposR) / 2;

            if (arr[middle] == x) {
                lposR = middle - 1;
            } else if (arr[middle] > x) {
                lposR = middle - 1;
            } else {
                lposL = middle + 1;
            }
        }

        int rposL = 0;
        int rposR = arr.length - 1;

        while (rposL <= rposR) {
            int middle = (rposL + rposR) / 2;

            if (arr[middle] == x) {
                rposL = middle + 1;
            } else if (arr[middle] < x) {
                rposL = middle + 1;
            } else {
                rposR = middle - 1;
            }
        }

        return rposL - lposR - 1;
    }
}
