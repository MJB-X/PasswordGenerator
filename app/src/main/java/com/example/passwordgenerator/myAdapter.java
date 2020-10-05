package com.example.passwordgenerator;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.innerclass> {
    ArrayList<String > passwords;





    public myAdapter(ArrayList passwords) {
        this.passwords = passwords;

    }

    @NonNull
    @Override
    public innerclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new innerclass(LayoutInflater.from(parent.getContext()).inflate(R.layout.iteam,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull innerclass holder, int position) {
        holder.panelist.setText(passwords.get(position));
        



    }

    @Override
    public int getItemCount() {
        return passwords.size();
    }

    public class innerclass extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView panelist;
        ImageView delete;


        public innerclass(@NonNull View itemView) {
            super(itemView);
            panelist = itemView.findViewById(R.id.passlist);
            delete = itemView.findViewById(R.id.delete);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    passwords.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return true;
                }
            });
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), passwords.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}
