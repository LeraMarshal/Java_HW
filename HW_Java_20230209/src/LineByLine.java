import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineByLine {
    // Начинается с FN: захватывает группу () из 1 и более .+ до конца строки $
    private static final Pattern FN_PATTERN = Pattern.compile("^FN:(.+)$");

    // Захватывает 3 группы: поле (TEL, ADDRESS, ...), тип (TYPE=...) и значение
    private static final Pattern FIELD_PATTERN = Pattern.compile("^(.+?)[;:]TYPE=(.+?):\\s*(.+)$");

    public static void main(String[] args) throws Exception {
        /*
        Описание занятия:
        - распарсить файл inputbuisnesscard.txt
        - создать класс типа Contact и сопутствующие классы при необходимости
        - заполнить обьекты типа Contact данными из файла
            (
            Имя \ Фамилия
            Телефон
            Адрес
            Е-мэйл
            Вебсайт
            )
         */

        // Вывести в консоль список контактов, отсортированных по № телефона
        List<Contact> contactList = getContactsFromFile("inputbuisnesscard.txt");

        contactList.stream()
                .sorted(Comparator.comparing(c -> c.getPhones().stream().findFirst().orElse("")))
                .forEach(System.out::println);

        // Используя интерфейс Serializable сохранить обьекты типа Contact в файл
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("contacts.txt"))){
            objectOutputStream.writeObject(contactList);
        }

        // реализовать считывание и выдачу в консоль сохраненных обьектов
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("contacts.txt"))){
            System.out.println(objectInputStream.readObject());
        }
    }

    // Напишем метод, который принимает на вход имя файла и возвращает на выход список контактов из этого файла
    public static List<Contact> getContactsFromFile(String fileName) throws IOException {
        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            String line1;

            while ((line1 = bufferedReader.readLine()) != null) {
                if ("BEGIN:VCARD".equals(line1)) {
                    Contact contact = new Contact();

                    String line2;
                    while ((line2 = bufferedReader.readLine()) != null) {
                        if ("END:VCARD".equals(line2)) {
                            contacts.add(contact);
                            break;
                        }

                        Matcher matcher1 = FN_PATTERN.matcher(line2);
                        if (matcher1.matches()) { // Если строка целиком попадает под регулярное выражение
                            contact.setFullName(matcher1.group(1));
                        } else {
                            Matcher matcher2 = FIELD_PATTERN.matcher(line2);
                            if (matcher2.matches()) {
                                String field = matcher2.group(1);
                                String type = matcher2.group(2);
                                String value = matcher2.group(3);

                                contact.addData(field, type, value);
                            }
                        }
                    }
                }
            }
        }

        return contacts;
    }
}
