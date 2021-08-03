package com.prabhakar.loadgithubprofilesinarecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GithubProfileAdapter extends RecyclerView.Adapter<GithubProfileViewHolder> {
    private ArrayList<ResponseModel> userLists;

    public GithubProfileAdapter(ArrayList<ResponseModel> userLists) {
        this.userLists = userLists;
    }

    @NotNull
    @Override
    public GithubProfileViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_layout, parent, false);
        return new GithubProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GithubProfileViewHolder holder, int position) {
        ResponseModel model = userLists.get(position);
        holder.setUserdata(model);
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }
}
