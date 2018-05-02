package app.forge.twice.animationtest.models;

public class Contact {
    public Contact() {
    }

    public Contact(String name) {
        this.name = name;
    }

    public String name;

    @Override
    public String toString() {
        return name;
    }
}
