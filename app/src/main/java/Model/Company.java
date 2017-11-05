package Model;

import java.util.ArrayList;

/**
 * Created by cmgoe on 11/4/2017.
 */

public class Company {
    private ArrayList<Task> tasks;
    private String name;
    private String description;
    private String contact;

    public Company() {

    }

    public Company (String name, String description, String contact, ArrayList<Task> tasks) {
        this.setTasks(tasks);
        this.setName(name);
        this.setDescription(description);
        this.setContact(contact);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
