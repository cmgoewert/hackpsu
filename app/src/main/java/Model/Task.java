package Model;

import java.util.ArrayList;

/**
 * Created by cmgoe on 11/4/2017.
 */

public class Task {
    private ArrayList<String> tags;
    private String shortDesc;
    private String description;

    public Task (ArrayList<String> tags, String shortDesc, String description) {
        this.setTags(tags);
        this.setShortDesc(shortDesc);
        this.setDescription(description);
    }

    public Task () {

    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
