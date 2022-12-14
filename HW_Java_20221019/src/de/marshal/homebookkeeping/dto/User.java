package de.marshal.homebookkeeping.dto;

public class User {
    private Long id;
    private String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this(null, name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (this.id != null){
            throw new IllegalStateException("Cannot change id on existing user");
        }

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
