package com.example.myfirstroomexercice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<User> myListUsers = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter adapterUser;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnDisplayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView_display);
        editTextEmail = findViewById(R.id.edit_email);
        editTextPassword = findViewById(R.id.edit_mdp) ;
        btnDisplayList = findViewById(R.id.btnDisplay);
        btnDisplayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
        setViewItem();
    }

    private void addUser(){
        User user = new User();
        user.setEmail(editTextEmail.getText().toString());
        user.setPassword(editTextPassword.getText().toString());
        myListUsers.add(user);
        adapterUser.setListUser(myListUsers);
        Toast.makeText(MainActivity.this, "La taille de ma liste est: "+myListUsers.size(),Toast.LENGTH_SHORT).show();
    }


    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        OnButtonDeleteClickedAction onButtonDeleteClickedAction = new OnButtonDeleteClickedAction() {
            @Override
            public void deleteUser(User user) {
                myListUsers.remove(user);
                adapterUser.setListUser(myListUsers);

            }
        };
        adapterUser =new UserAdapter(myListUsers,onButtonDeleteClickedAction);
        recyclerView.setAdapter(adapterUser);
    }
}