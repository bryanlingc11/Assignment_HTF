package com.example.assignment_htf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductHomePageActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_home_page);

        button=(Button) findViewById(R.id.btnWomen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductHomePageActivity.this,WomenProdActivity.class));
            }
        });

        button=(Button) findViewById(R.id.btnMen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductHomePageActivity.this,MenProdActivity.class));
            }
        });


        button=(Button) findViewById(R.id.btnKid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductHomePageActivity.this,KidProdActivity.class));
            }
        });
    }
}