package com.projects.sharath.readerprofileui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private ArrayList<BooksModel> booksModelArrayList;
    private Context context;

    public BooksAdapter(ArrayList<BooksModel> booksModelArrayList, Context context) {
        this.booksModelArrayList = booksModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_contents, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.ViewHolder holder, int position) {

        int settingImage = booksModelArrayList.get(position).getImage();
        holder.setImageView(settingImage);

        String settingName = booksModelArrayList.get(position).getName();
        holder.setName(settingName);

        String settingProgressNum = booksModelArrayList.get(position).getProgressnum();
        holder.setProgressNum(settingProgressNum + "% completed");

        int settingProgress = booksModelArrayList.get(position).getProgress();
        holder.setProgressBar(settingProgress);

    }

    @Override
    public int getItemCount() {
        return booksModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private ProgressBar progressBar;
        private TextView name, progressNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void setImageView(int iv) {
            imageView = itemView.findViewById(R.id.image_holder);
            imageView.setImageResource(iv);
        }

        void setName(String tv1) {
            name = itemView.findViewById(R.id.name_holder);
            name.setText(tv1);
        }

        void setProgressNum(String tv2) {
            progressNum = itemView.findViewById(R.id.progress_num);
            progressNum.setText(tv2);
        }

        void setProgressBar(int pg) {
            progressBar = itemView.findViewById(R.id.progress);
            progressBar.setProgress(pg);
        }
    }
}
