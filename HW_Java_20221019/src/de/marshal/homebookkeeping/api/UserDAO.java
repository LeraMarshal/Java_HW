package de.marshal.homebookkeeping.api;

import de.marshal.homebookkeeping.dto.User;

public interface UserDAO {
    User getByID(long id);

    User getByName(String name);

    void add(User user);

    void update(User user);
}
