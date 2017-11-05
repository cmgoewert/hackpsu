package Model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cmgoe on 11/4/2017.
 */

public class FirebaseDB {
    private ArrayList<Company> companies;
    private DatabaseReference mDatabase;

    public FirebaseDB () {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        createDummyData();
    }


    public void write(ArrayList<Company> companies){
        this.setCompanies(companies);
        mDatabase.child("companies").setValue(companies);
    }

    public ArrayList<Company> read(){
        DatabaseReference companyRef = mDatabase.child("companies");
        companyRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                ArrayList<Company> readComp = new ArrayList<>();
                for(DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()){
                    Company company = noteDataSnapshot.getValue(Company.class);
                    readComp.add(company);
                }
                setCompanies(readComp);
            }
            @Override
            public void onCancelled(DatabaseError error){

            }
        });
        return getCompanies();
    }

    public void createDummyData(){
        setCompanies(new ArrayList<Company>());
        getCompanies().add(new Company("Company1", "This is the first demo company", "Mr. John@gmail.com",
                new ArrayList<Task>(Arrays.asList(new Task(new ArrayList<String>(Arrays.asList("tag1","tag2","tag3")),"Here is a short description of the first task.",
                        "Task number 1"),new Task(new ArrayList<String>(Arrays.asList("tag1","tag2","tag3")),"Here is a short description of the second task.",
                        "Task number 2")))));
        getCompanies().add(new Company("Company2", "This is the second demo company", "Mr. Joe@gmail.com",
                new ArrayList<Task>(Arrays.asList(new Task(new ArrayList<String>(Arrays.asList("tag1","tag2","tag3")),"Here is a short description of the first task.",
                        "Task number 1"),new Task(new ArrayList<String>(Arrays.asList("tag1","tag2","tag3")),"Here is a short description of the second task.",
                        "Task number 2")))));
        ArrayList<Task> tasks = new ArrayList<>();
        for(int i = 0; i < 30; i ++){
            tasks.add(new Task(new ArrayList<String>(Arrays.asList("tag1","tag2","tag3")),"Here is a short description of the "+i+" task.",
                    "Task number "+i));
        }
        getCompanies().get(0).setTasks(tasks);

        mDatabase.child("companies").setValue(getCompanies());
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }
}
