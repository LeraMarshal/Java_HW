package de.marshal.homebookkeeping.dao;

import de.marshal.homebookkeeping.api.UserDAO;
import de.marshal.homebookkeeping.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemoryUserDAO implements UserDAO {
    private static List<DBUser> USERS = new ArrayList<>();

    private class DBUser {
        public long id;
        public String name;
    }

    @Override
    public User getByID(long id) {
        for (DBUser dbUser : USERS) {
            if (id == dbUser.id) {
                return new User(dbUser.id, dbUser.name);
            }
        }

        return null;
    }

    @Override
    public User getByName(String name){
        for (DBUser dbUser : USERS) {
            if (dbUser.name.equals(name)){
                return new User(dbUser.id, dbUser.name);
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        Objects.requireNonNull(user);
        Objects.requireNonNull(user.getName());

        if (user.getId() != null) {
            throw new IllegalArgumentException("User id must be null");
        }

        if (getByName(user.getName()) != null) {
            throw new IllegalArgumentException("User with this name already exists");
        }

        long maxID = 0;
        for (DBUser dbUser : USERS) {
            if (dbUser.id > maxID){
                maxID = dbUser.id;
            }
        }

        DBUser dbUser = new DBUser();
        dbUser.id = maxID + 1;
        dbUser.name = user.getName();

        USERS.add(dbUser);

        user.setId(dbUser.id);
    }

    @Override
    public void update(User user) {
        Objects.requireNonNull(user);

        long id = Objects.requireNonNull(user.getId());
        String name = Objects.requireNonNull(user.getName());

        User existingUser = getByName(name);
        if (existingUser != null && existingUser.getId() != id) {
            throw new IllegalArgumentException("User with this name already exists");
        }

        for (DBUser dbuser : USERS) {
            if (dbuser.id == id){
                dbuser.name = name;
                break;
            }
        }
    }
}
