package ard.dev.ku2ba.Java.ModelJava;

public class ModelCrud {
    private int id;
    private String name;
    private String email;

    public ModelCrud(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public ModelCrud() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
