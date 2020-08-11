package com.example.assignment_htf;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Toast.makeText(AccountActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_product:
                        Toast.makeText(AccountActivity.this, "Product", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_cart:
                        Toast.makeText(AccountActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_account:
                        Toast.makeText(AccountActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        button = (Button) findViewById(R.id.btn_edit);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, editProfile.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.btn_cust_detail);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, custDetail.class);
                startActivity(intent);
            }
        });
    }


}