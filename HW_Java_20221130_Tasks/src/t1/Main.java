package t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
        1. Есть два класса:
     - Address (с полями улица и номер дома) и
     - Person с полями (name and address).
     Нужно написать метод List<Address> getAddress(List<Person> persons).
     (по списку persons вернуть список их адресов).
     */
    public static void main(String[] args) {
        Address address1 = new Address("1", 1);
        Address address2 = new Address("2", 2);

        Person person1 = new Person("P1", address1);
        Person person2 = new Person("P2", address2);

        List<Person> persons = Arrays.asList(person1,person2);

        System.out.println(getAddress(persons));
    }

    private static List<Address> getAddress(List<Person> persons){
        List<Address> returnAddress = new ArrayList<>();

        for(Person p : persons){
            returnAddress.add(p.getAddress());
        }

        return returnAddress;
    }
}
