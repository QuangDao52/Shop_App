package com.example.shop_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shop_app.R;
import com.example.shop_app.model.DanhMuc;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListDanhMucAdapter extends RecyclerView.Adapter<ListDanhMucAdapter.ListViewHolder> {
    Context context;
    private List<DanhMuc> danhMucList;

    public ListDanhMucAdapter(Context context, List<DanhMuc> danhMucList) {
        this.context = context;
        this.danhMucList = danhMucList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_danhmuc,parent,false);
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        DanhMuc danhMuc = danhMucList.get(position);
        if (danhMuc==null){
            return;
        }
        Picasso.get().load(danhMuc.getAnh()).into(holder.productImage);
        holder.productName_TextView.setText(danhMuc.getName());
    }

    @Override
    public int getItemCount() {
        if(danhMucList!=null){
            return danhMucList.size();
        }
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        LinearLayout layout;
        ImageView productImage;
        TextView productName_TextView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productName_TextView = itemView.findViewById(R.id.productName_TextView);
            layout = itemView.findViewById(R.id.layout);

        }
    }
}
