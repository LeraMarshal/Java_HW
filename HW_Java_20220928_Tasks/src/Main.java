public class Main {
    public static void main(String[] args) {

        /*
        First level: Дан массив целых чисел (не пустой).
        Написать метод, возвращающий наибольший элемент этого массива .

        { 5,2,9,1} -> 9
         */

        int[] arr = new int[] { 5, 2, 9, 1};

        System.out.println(findMaxElem(arr));
        System.out.println(getMaxMinDiff(arr));
    }

    private static int findMaxElem(int[] arr){
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }

    private static int getMaxMinDiff(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }

        return max - min;
    }
}