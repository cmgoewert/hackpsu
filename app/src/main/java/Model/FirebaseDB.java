package Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by cmgoe on 11/4/2017.
 */

public class FirebaseDB {
    private ArrayList<Company> companies;
    private DatabaseReference mDatabase;

    public FirebaseDB () {
        createDummyData();
        mDatabase = FirebaseDatabase.getInstance().getReference();

    }

    public void createDummyData(){
        companies = new ArrayList<Company>();
        companies.add(new Company("Company1", "This is the first demo company", "Mr. John@gmail.com"));
        companies.add(new Company("Company2", "This is the second demo company", "Mr. Joe@gmail.com"));
    }

}
