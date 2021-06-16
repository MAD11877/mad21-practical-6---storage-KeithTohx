package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    ArrayList<User> userList;

    public SimpleAdapter(ArrayList<User> input){ userList = input; }

    @NonNull
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == 7) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.simplerecyclerview2, parent, false);
        }
        else{
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.simplerecyclerview, parent, false);
        }
        return new SimpleViewHolder(item);
    }

    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position){
        User userObj = userList.get(position);

        holder.txtN.setText(userObj.name);
        holder.txtD.setText(userObj.description);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Profile");
                builder.setMessage(userObj.name);
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(holder.img.getContext(), MainActivity.class);
//                        Bundle extras = new Bundle();
//                        extras.putString("userName", userObj.getName());
//                        extras.putString("userDesc", userObj.getDescription());
//                        extras.putBoolean("followStatus", userObj.isFollowed());
//                        intent.putExtras(extras);
                        intent.putExtra("id", position);
                        holder.img.getContext().startActivity(intent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public int getItemCount(){
        return userList.size();
    }

    @Override
    public int getItemViewType(int position){
        String uName = userList.get(position).name;
        int lastChar = Integer.parseInt(uName.substring(uName.length()-1));
        return lastChar;
    }
}
