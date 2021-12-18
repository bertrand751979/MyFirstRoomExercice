package com.example.myfirstroomexercice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private ImageView vhImage;
    private TextView  vhEmail;
    private TextView  vhPassord;


    public UserViewHolder(@NonNull View view) {
        super(view);
        vhImage = view.findViewById(R.id.raw_delete);
        vhEmail = view.findViewById(R.id.raw_email);
        vhPassord = view.findViewById(R.id.raw_password);
    }

    public ImageView getVhImage() {
        return vhImage;
    }

    public void setVhImage(ImageView vhImage) {
        this.vhImage = vhImage;
    }

    public TextView getVhEmail() {
        return vhEmail;
    }

    public void setVhEmail(TextView vhEmail) {
        this.vhEmail = vhEmail;
    }

    public TextView getVhPassord() {
        return vhPassord;
    }

    public void setVhPassord(TextView vhPassord) {
        this.vhPassord = vhPassord;
    }

    public void bind(User user, OnButtonDeleteClickedAction onButtonDeleteClickedAction){
        vhEmail.setText(user.getEmail());
        vhPassord.setText(user.getPassword());
        vhImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonDeleteClickedAction.deleteUser(user);
            }
        });
    }
}
