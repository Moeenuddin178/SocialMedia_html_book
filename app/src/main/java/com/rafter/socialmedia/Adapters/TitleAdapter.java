package com.rafter.socialmedia.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rafter.socialmedia.R;
import com.rafter.socialmedia.detail;

import java.util.ArrayList;
import java.util.Random;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.viewholder> {
    private Context mcontext;
    private ArrayList<String> titlelist;


    public TitleAdapter(Context mcontext, ArrayList<String> titlelist) {
        this.mcontext = mcontext;
        this.titlelist = titlelist;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_title, parent, false);
        final viewholder viewholder = new viewholder(view);
        return viewholder;
    }


    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, final int position) {
        holder.Title.setText(titlelist.get(position).replace("_", " "));


        holder.number.setText(String.valueOf(titlelist.get(position).charAt(0)));
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        // generate random color

        Random r = new Random();
        int red = r.nextInt(255 - 0 + position);
        int green = r.nextInt(255 - position + 1);
        int blue = r.nextInt(255 - 0 + (position + 1));
        shape.setColor(Color.rgb(red, green, blue));
        holder.circle.setBackground(shape);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, detail.class);
                //Log.d("tessst",titlelist.get(position).replace(" ","_"));
                intent.putExtra("title", titlelist.get(position).replace(" ", "_"));
                mcontext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return titlelist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView Title, number;
        CardView circle;
        ConstraintLayout constraintLayout;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.Title);
            number = itemView.findViewById(R.id.number);
            circle = itemView.findViewById(R.id.circle);
            constraintLayout = itemView.findViewById(R.id.item_tit);
        }
    }
}
