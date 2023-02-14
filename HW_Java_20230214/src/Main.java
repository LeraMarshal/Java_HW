public class Main {
    public static void main(String[] args) {
        /*
         Напишите класс, который реализует ограниченную коллекцию,
         где максимальное количество элементов может быть задано в конструкторе,
         и элементы могут быть любого типа.
         */

        GenericLimitedCollection<String> collection = new GenericLimitedCollection<>(3);

        for (int i = 'A'; i <= 'D'; i++) {
            try {
                collection.add(Character.toString(i));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println(collection.get(i));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
