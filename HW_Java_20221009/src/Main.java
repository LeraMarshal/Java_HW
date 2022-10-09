public class Main {
    public static void main(String[] args) {
        String[] students = {"a", "b", "c", "d", "e", "f", "g", "h",};
        double[] points = {4.2, 5.0, 3.7, 4.4, 4.9, 3.8, 4.1, 4.8};

        System.out.println(nameOfTheBestStudent(students, points));

        System.out.println(filterStudentsToString(students, points, 4.1));
    }

    /*
    Дано 2 массива. Первый массив String[] содержит имена студентов.
    Второй массив double[] содержит средний балл  студентов.
    i-й элемент первого массива соответствует i-элементу второго массива.
    Длины массивов равны. Необходимо написать метод, который возвращает имя самого успешного студена.
    В данной задаче, если 2 и более студента имеют лучший бал, метод может вернуть имя любого из них.
     */
    private static String nameOfTheBestStudent(String[] students, double[] points) {
        if (students.length == 0){
            return null;
        }

        double maxPoint = points[0];
        int maxPointIndex = 0;

        for (int i = 1; i < points.length; i++) {
            if (maxPoint < points[i]) {
                maxPoint = points[i];
                maxPointIndex = i;
            }
        }

        return students[maxPointIndex];
    }

    /*
    Исходные условия как у предыдущей задачи, т.е. дано два массива один с именами другой с средним баллом,
    но ваш метод должен выдавать строку вида имя1 - балл1:имя2 - балл2:имя3 - балл3 ….для всех студентов,
    чей балл выше заданного значения.
    Например:
    {“Jack”, “John”, “Stan”, “Ed”}, {3.5, 4.2, 4.8, “4.1”}, 4.0 ->
    “John - 4.2:Stan - 4.8:Ed - 4.1”
     */
    private static String filterStudentsToString (String[] students, double[] points, double border){
        String res = "";

        for (int i = 0; i < points.length; i++) {
            if (points[i] > border){
                if (res.length() > 0) {
                    res += ":";
                }

                res += students[i] + " - " + points[i];
            }
        }

        return res;
    }
}