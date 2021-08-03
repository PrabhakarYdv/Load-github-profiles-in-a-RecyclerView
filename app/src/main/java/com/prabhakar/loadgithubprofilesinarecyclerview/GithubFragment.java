package com.prabhakar.loadgithubprofilesinarecyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GithubFragment extends Fragment {
    private EditText githubId;
    private Button fetchButton;
    private RecyclerView recyclerView;
    private ArrayList<ResponseModel> userList = new ArrayList<>();
    private GithubProfileAdapter githubProfileAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_github, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        githubId = view.findViewById(R.id.enter_profile);
        fetchButton = view.findViewById(R.id.btn_fetch);
        recyclerView = view.findViewById(R.id.recyclerView);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallApi();
            }
        });
    }

    private void setAdapter() {
        githubProfileAdapter = new GithubProfileAdapter(userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(githubProfileAdapter);
    }

    private void CallApi() {
        APIService apiService = Network.getInstance().create(APIService.class);
        String profile = githubId.getText().toString();
        apiService.getProfile(profile).enqueue(new Callback<ArrayList<ResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseModel>> call, Response<ArrayList<ResponseModel>> response) {
                if (response.body() != null) {
                    userList = response.body();
                    setAdapter();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Error to loading profile", Toast.LENGTH_SHORT).show();
            }
        });
    }
}