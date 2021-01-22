package com.niajmahmud.LearnProgrammingBD;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.niajmahmud.LearnProgrammingBD.model.ProgrammingLanguage;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder> {
    ArrayList<ProgrammingLanguage> listData;
    LayoutInflater mInflater = null;
    Context mContext = null;


    MyListAdapter(Context context, ArrayList<ProgrammingLanguage> data) {
        mContext = context;
        this.listData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_single, parent, false);
        return new MyViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProgrammingLanguage pl = listData.get(position);
        holder.myTextView.setText(pl.getLanguageTitle());
        holder.myTextViewUrl.setText("URL: " + pl.getTutorialURL());
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView;
        public TextView myTextViewUrl;
        public Context context;

        MyViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            myTextView = itemView.findViewById(R.id.textView);
            myTextViewUrl = itemView.findViewById(R.id.textViewUrl);
            itemView.setOnClickListener(this);
        }
        
        @Override
        public void onClick(View v) {
            //Toast.makeText(this.context, listData.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mContext, DetailsActivity.class);
            int position = getAdapterPosition();
            intent.putExtra("URL", listData.get(position).getTutorialURL());
            intent.putExtra("TITLE", listData.get(position).getLanguageTitle());
            mContext.startActivity(intent);
        }
    }
}
