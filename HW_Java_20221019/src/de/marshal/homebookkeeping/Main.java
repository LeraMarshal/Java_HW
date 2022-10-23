package de.marshal.homebookkeeping;

import de.marshal.homebookkeeping.api.UserDAO;
import de.marshal.homebookkeeping.dao.MemoryUserDAO;
import de.marshal.homebookkeeping.dto.User;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new MemoryUserDAO();

        System.out.println(userDAO.getByID(1L));

        User jack = new User("Jack");
        userDAO.add(jack);
        System.out.println(jack.getId());

        jack.setName("John");
        userDAO.update(jack);

        System.out.println(userDAO.getByID(1L));

        userDAO.add(new User("Jack"));
        System.out.println(userDAO.getByID(2L));
    }
}
