package com.example.assignment_htf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class MenProdActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_prod);
        mRecyclerView = findViewById(R.id.recyelerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Men");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Member, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Member, ViewHolder>(
                        Member.class,
                        R.layout.image,
                        ViewHolder.class,
                        reference
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Member member, int i) {
                        viewHolder.setdetails(getApplicationContext(), member.getNameProd(), member.getPriceProd(), member.getImageProd());
                    }

                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                        viewHolder.setOnclickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemclick(View view, int position) {
                                TextView mname = view.findViewById(R.id.name);
                                TextView mprice = view.findViewById(R.id.price);
                                ImageView mimageView = view.findViewById(R.id.rImageView);

                                String name = mname.getText().toString();
                                String price = mprice.getText().toString();
                                Drawable mDrawable = mimageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable) mDrawable).getBitmap();
                                Intent intent = new Intent(view.getContext(), SingleProdActivity.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();

                                intent.putExtra("ImageProd", bytes);
                                intent.putExtra("NameProd", name);
                                intent.putExtra("PriceProd", price);
                                startActivity(intent);

                            }

                            @Override
                            public void onItemLongclick(View view, int position) {

                            }
                        });

                        return viewHolder;
                    }
                };


        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}