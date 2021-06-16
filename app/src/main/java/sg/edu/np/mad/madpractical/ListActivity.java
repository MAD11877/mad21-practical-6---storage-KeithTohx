package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "Activity List";
    static ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        DBHandler db = new DBHandler(this);

        userList = db.getUsers();

//        for(int i = 0; i < 20; i++){
//            int n = i %2;
//            User user;
//            if(n == 0){
//                user = new User(
//                        "Name" + new Random().nextInt(),
//                        "Description " + new Random().nextInt(),
//                        0,
//                        false
//                );
//            } else{
//                user = new User(
//                        "Name" + new Random().nextInt(),
//                        "Description " + new Random().nextInt(),
//                        0,
//                        true
//                );
//            }
//            userList.add(user);
//        }
//        ImageView image = findViewById(R.id.imageViewS);
//        ImageView imageLarge = findViewById(R.id.imageViewL);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        SimpleAdapter sAdapter = new SimpleAdapter(userList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);
    }
}