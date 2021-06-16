package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Create");

        Intent receiveData = getIntent();
        int value = receiveData.getIntExtra("id",0);
        user = ListActivity.userList.get(value);
//        String userName = receiveData.getStringExtra("userName");
//        String userDesc = receiveData.getStringExtra("userDesc");
//        boolean followStatus = receiveData.getBooleanExtra("followStatus", false);

//        User user = new User(
//                userName,
//                userDesc,
//                0,
//                followStatus
//        );

        TextView nameText = findViewById(R.id.name);
        TextView descText = findViewById(R.id.description);

        nameText.setText(user.name);
        descText.setText(user.description);
        setFollowBtn();
    }

    private void setFollowBtn() {
        Button followBtn = findViewById(R.id.follow);
        if(user.followed) {
            followBtn.setText("Unfollow");
        }
        else {
            followBtn.setText("Follow");
        }
    }

    public void onFollowClick(View v) {
        user.followed = !user.followed;
        if(user.followed)
            Toast.makeText(this, "Followed", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Unfollowed", Toast.LENGTH_SHORT).show();
        setFollowBtn();

        DBHandler db = new DBHandler(this);
        db.updateUser(user);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Stop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG, "Destroy");
    }
}