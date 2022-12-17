public class Main {
    /*
     1 lvl. Реализовать динамический массив, который при добавлении элементов увеличивает свой размера в 2 раза,
     если места для добавления элемента оказывается недостаточно.

     У динамического массива должны быть следующие методы:

 *   - add(int value): void | Добавляет элемент в конец
 *   - addAt(int index, int value) : void | Добавляет элемент по индексу со сдвигом всех элементов начиная с текущего и до последнего на 1
 *   - get(int index): int | Возвращает элемент по индексу
 *   - remove(): void | Удаляет последний элемент
 *   - removeAt(int index): void | Удаляет элемент по индексу
 *   - set(int index, int value): void | Меняет значение элемента по индексу на указанное
 *   - contains(int value): boolean | Проверяет, присутствует ли указанный элемент в списке
 *   - size(): int | Возвращает размер списка
 *   - shrinkSize(): void | Уменьшает массив до размера, равного количеству элементов в нем
 *   - clear(): void | Удаляет все элементы из списка, размер списка становится изначальным

    2 lvl. Для тех, кто уже реализовывал динамический массив, или просто хочет дополнительное задание:

       Написать метод, который принимает количество добавляемых в список элементов, и возвращающий количество
       необходимых для этого операций (элементы добавляются по одному, в конец списка).

       Массив имеет начальную длину 8 и увеличивается в два раза при необходимости.
     */

    public static void main(String[] args) {
        // 1 lvl
        ArrayListImpl<String> list = new ArrayListImpl<>();

        list.add("1"); // [1, null, null, null, null, null, null, null]
        list.add("3"); // [1, 3, null, null, null, null, null, null]
        list.add("4"); // [1, 3, 4, null, null, null, null, null]
        list.add("5"); // [1, 3, 4, 5, null, null, null, null]

        list.addAt(1,"2"); // [1, 2, 3, 4, 5, null, null, null]

        System.out.println(list.get(2)); // 3

        list.remove(); // [1, 2, 3, 4, null, null, null, null]

        list.removeAt(0); // [2, 3, 4, null, null, null, null, null]
        list.removeAt(1); // [2, 4, null, null, null, null, null, null]
        list.removeAt(1); // [2, null, null, null, null, null, null, null]

        System.out.println(list.contains("3")); // false
        System.out.println(list.contains("2")); // true

        System.out.println(list.size()); // 1

        list.clear();

        list.shrinkSize(); // []

        list.add("1"); // [1]
        list.add("2"); // [1, 2]
        list.add("3"); // [1, 2, 3, null]

        System.out.println(list);

        // 2 lvl
        System.out.println(countOperations(3)); // 3
        System.out.println(countOperations(8)); // 8
        System.out.println(countOperations(9)); // 17
    }

    public static int countOperations(int elemsToAdd){
        int len = 8;
        int size = 0;
        int count = 0;

        for (int i = 0; i < elemsToAdd; i++) {
            if (size < len){
                count += 1;
            }else {
                count += size + 1;
                len *= 2;
            }
            size += 1;
        }

        return count;
    }
}
