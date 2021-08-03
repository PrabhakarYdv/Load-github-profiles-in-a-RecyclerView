package com.prabhakar.loadgithubprofilesinarecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class GithubProfileViewHolder extends RecyclerView.ViewHolder {
    private ImageView profileImage;
    private TextView profileName, profileLogin;

    public GithubProfileViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        profileImage = itemView.findViewById(R.id.profile_image);
        profileName = itemView.findViewById(R.id.name);
        profileLogin = itemView.findViewById(R.id.login);
    }

    public void setUserdata(ResponseModel responseModel) {
        if (responseModel.getOwner().getAvatarUrl() != null) {
            Glide.with(profileImage).load(responseModel.getOwner().getAvatarUrl()).into(profileImage);
        } else {
            Glide.with(profileImage).load(R.drawable.empty_image).into(profileImage);
        }
        profileName.setText(responseModel.getName());
        profileLogin.setText(responseModel.getOwner().getLogin());
    }
}
