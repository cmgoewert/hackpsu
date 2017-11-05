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
        this.tags = tags;
        this.shortDesc = shortDesc;
        this.description = description;
    }

}
