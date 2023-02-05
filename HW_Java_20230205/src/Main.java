import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        /*
        Создайте файл, используя FileOutputStream, с текстом:
        "This is my first experience when I myself work with IO API. I can do everything!"
         */

        try (FileOutputStream fileOutputStream = new FileOutputStream("myFirstExp.txt")) {
            fileOutputStream.write("This is my first experience when I myself work with IO API. I can do everything!".getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
