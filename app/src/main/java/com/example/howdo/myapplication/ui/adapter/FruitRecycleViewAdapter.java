package com.example.howdo.myapplication.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.model.Fruit;
import com.example.howdo.myapplication.util.ToastUtil;

import java.util.List;

public class FruitRecycleViewAdapter extends RecyclerView.Adapter<FruitRecycleViewAdapter.ViewHolder> {
    private List<Fruit> mFruitList;


    public FruitRecycleViewAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruit, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(adapterPosition);
                ToastUtil.showText(fruit.getName()+fruit.getImageId());
            }
        });
        holder.fruitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(adapterPosition);
                ToastUtil.showText(fruit.getName()+fruit.getImageId());

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.first_code_fruit_imageView);
           fruitName =  (TextView) itemView.findViewById(R.id.first_code_fruit_tv);
        }
    }
}
