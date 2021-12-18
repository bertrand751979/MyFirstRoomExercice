package com.example.myfirstroomexercice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User> listUser;
    private OnButtonDeleteClickedAction onButtonDeleteClickedAction;

    public UserAdapter(ArrayList<User> listUser, OnButtonDeleteClickedAction onButtonDeleteClickedAction) {
        this.listUser = listUser;
        this.onButtonDeleteClickedAction = onButtonDeleteClickedAction;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.raw_display,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(listUser.get(position),onButtonDeleteClickedAction);
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }
}
