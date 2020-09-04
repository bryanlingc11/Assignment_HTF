package com.example.assignment_htf;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView NameProd1, PriceProd1;
    public  ImageView ImageProd1;
    public ItemClickListener listener;
    public  ViewHolder(View itemView)
    {
        super(itemView);
        ImageProd1 = (ImageView) itemView.findViewById(R.id.rImageView);
        NameProd1 = (TextView) itemView.findViewById(R.id.name);
        PriceProd1 = (TextView) itemView.findViewById(R.id.price);
    }

    public void setItemClickListener(ItemClickListener listener)
    {
        this.listener=listener;
    }

    @Override
    public void onClick(View view)
    {
        listener.onClick(view,getAdapterPosition(),false);
    }

}
