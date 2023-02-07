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
import com.example.shop_app.model.SanPham;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListSP extends RecyclerView.Adapter<ListSP.ListViewHolder> {
    Context context;
    private List<SanPham> sanPhams;

    public ListSP(Context context, List<SanPham> sanPhams) {
        this.context = context;
        this.sanPhams = sanPhams;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhmuc_home,parent,false);
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
       SanPham sanPham = sanPhams.get(position);
        if (sanPham==null){
            return;
        }
        Picasso.get().load(sanPham.getAnh()).into(holder.productImage);
        holder.txtprice.setText(sanPham.getGia());
        holder.txtname.setText(sanPham.getName());
        holder.txtnumber.setText(sanPham.getNumber());
    }

    @Override
    public int getItemCount() {
        if(sanPhams!=null){
            return sanPhams.size();
        }
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        LinearLayout layout;
        ImageView productImage;
        TextView productName_TextView,txtname,txtprice,txtnumber;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productName_TextView = itemView.findViewById(R.id.productName_TextView);
            txtprice = itemView.findViewById(R.id.txtprice);
            txtname = itemView.findViewById(R.id.txtname);
            txtnumber = itemView.findViewById(R.id.txnumber);
            layout = itemView.findViewById(R.id.layout);

        }
    }
}
