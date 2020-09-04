package com.example.assignment_htf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleProdActivity extends AppCompatActivity {
    EditText edittext;
    TextView name;
    TextView price;
    Button buttonAddtocart;
    ImageView image;
    FirebaseDatabase database;
    DatabaseReference ref;
    int prod =0;
    Member member;
    private Uri filePath;
    FirebaseStorage storage;
    private StorageReference mStorageRef;
    String prodID = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_prod);
        prodID=getIntent().getStringExtra("prodID");

        name=findViewById(R.id.name2);
        price=findViewById(R.id.price2);
        image=findViewById(R.id.rImageView2);
        buttonAddtocart=findViewById(R.id.btnAddtoCart);

        addtocart();
        getWomenData(prodID);
        getMenData(prodID);
        getKidData(prodID);


//        Button button=findViewById(R.id.gocart);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ProductDetailsActivity.this, Cart.class));
//            }
//        });

    }

    private void addtocart()
    {
        member=new Member();
        ref=database.getInstance().getReference().child("Cart");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    prod=(int) dataSnapshot.getChildrenCount();

                }
                else{
                    ///
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        buttonAddtocart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

//                    member.setImageProd1(dataSnapshot.child("Cart").getValue(Boolean.parseBoolean("ImageProd1")).toString());
                member.setImageProd1(image.getDrawable().toString());
                member.setNameProd1(name.getText().toString());
                member.setPriceProd1(price.getText().toString());
                ref.child(String.valueOf(prod+1)).setValue(member);
                Toast.makeText(ProductDetailsActivity.this,"Added",Toast.LENGTH_SHORT).show();



//                Picasso.get().load(member.getImageProd1()).into(image);

            }

        });
    }


    private void getWomenData(String prodID)
    {
        DatabaseReference ref =FirebaseDatabase.getInstance().getReference().child("Data");

        ref.child(prodID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    Member member = dataSnapshot.getValue(Member.class);
                    name.setText(member.getNameProd1());
                    price.setText(member.getPriceProd1());
                    Picasso.get().load(member.getImageProd1()).into(image);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getMenData(String prodID)
    {
        DatabaseReference ref =FirebaseDatabase.getInstance().getReference().child("Men");

        ref.child(prodID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    Member member = dataSnapshot.getValue(Member.class);
                    name.setText(member.getNameProd1());
                    price.setText(member.getPriceProd1());
                    Picasso.get().load(member.getImageProd1()).into(image);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getKidData(String prodID)
    {
        DatabaseReference ref =FirebaseDatabase.getInstance().getReference().child("Kids");

        ref.child(prodID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    Member member = dataSnapshot.getValue(Member.class);
                    name.setText(member.getNameProd1());
                    price.setText(member.getPriceProd1());
                    Picasso.get().load(member.getImageProd1()).into(image);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



            public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.send_message, Toast.LENGTH_SHORT);
        toast.show();
        edittext=findViewById(R.id.txtComment);
        edittext.setText("");
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}