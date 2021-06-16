package sg.edu.np.mad.madpractical;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    TextView txtN, txtD;
    ImageView img;

    public SimpleViewHolder(View itemView){
        super(itemView);
        txtN = itemView.findViewById(R.id.nameText2);
        txtD = itemView.findViewById(R.id.descText2);
        img = itemView.findViewById(R.id.imageViewS);
    }
}
