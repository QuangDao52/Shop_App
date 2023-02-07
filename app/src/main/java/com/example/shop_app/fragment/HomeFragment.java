package com.example.shop_app.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.shop_app.R;
import com.example.shop_app.adapter.ListDanhMucAdapter;
import com.example.shop_app.adapter.ListSP;
import com.example.shop_app.adapter.ListSPNew;
import com.example.shop_app.model.DanhMuc;
import com.example.shop_app.model.SanPham;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {
    private ImageSlider imageSlider;
    View view;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    Timer timer;
    int page_position = 0;
    private int dotscount;
    private ImageView[] dots;
    private Integer[] images = {R.drawable.slide, R.drawable.slide, R.drawable.slide, R.drawable.slide, R.drawable.slide};
    RecyclerView rcyDanhMuc;
    ListDanhMucAdapter listDanhMucAdapter;
    List<DanhMuc> danhMucList = new ArrayList<>();

    RecyclerView rcySp,rcySpNew;
    ListSP sp;
    List<SanPham> sanPhamList = new ArrayList<>();
    List<SanPham> sanPhamList1 = new ArrayList<>();
    ListSPNew listSPNew;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container,false);
        imageSlider = view.findViewById(R.id.imgSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://cdn.shopify.com/s/files/1/0554/5879/1593/products/last_frame.png?v=1648751161", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://media.cnn.com/api/v1/images/stellar/prod/220818135836-ariana-grande-bodycare-lead-image-cnnu.jpg?c=original", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://cdn.shopify.com/s/files/1/0026/2022/7637/collections/master-navigation-image-2500x1750-shop-haircare-collection-1.jpg?v=1666334710", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://tutinminhdep.com/wp-content/uploads/2020/10/nhung-dung-cu-trang-diem-can-thiet.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.elleman.vn/wp-content/uploads/2020/04/01/174970/bia_nuoc-hoa-nam-gioi_0420.jpg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
        mapping();
        Danhmuc();
        SP();
        SPNew();
        return  view;
    }
    public void scheduleSlider() {

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == dotscount) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                viewPager.setCurrentItem(page_position, true);
            }
        };

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 1000, 4000);
    }



    public void Danhmuc(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity(), RecyclerView.HORIZONTAL, false);
        rcyDanhMuc.setLayoutManager (linearLayoutManager);
        rcyDanhMuc.setHasFixedSize(true);

        listDanhMucAdapter = new ListDanhMucAdapter(getActivity(),danhMucList);
        rcyDanhMuc.setAdapter(listDanhMucAdapter);

        danhMucList.add(new DanhMuc(R.drawable.ic_1,"Fragrance"));
        danhMucList.add(new DanhMuc(R.drawable.ic_2,"Bodycare"));
        danhMucList.add(new DanhMuc(R.drawable.ic_3,"Haircare"));
        danhMucList.add(new DanhMuc(R.drawable.ic_4,"Facial"));
        danhMucList.add(new DanhMuc(R.drawable.ic_5,"Makeup"));
        danhMucList.add(new DanhMuc(R.drawable.ic_6,"Medicine"));
        danhMucList.add(new DanhMuc(R.drawable.ic_7,"Men"));
        danhMucList.add(new DanhMuc(R.drawable.ic_8,"Others"));


    }
    public void SP(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity(), RecyclerView.HORIZONTAL, false);
        rcySp.setLayoutManager (linearLayoutManager);
        rcySp.setHasFixedSize(true);

        sp = new ListSP(getActivity(),sanPhamList);
        rcySp.setAdapter(sp);
        sanPhamList.add(new SanPham(R.drawable.icon_hoa,"Vert Malachite","Rp 999.999","(999)"));
        sanPhamList.add(new SanPham(R.drawable.icon_hoa,"Vert Malachite","Rp 999.999","(999)"));
        sanPhamList.add(new SanPham(R.drawable.icon_hoa,"Vert Malachite","Rp 999.999","(999)"));
        sanPhamList.add(new SanPham(R.drawable.icon_hoa,"Vert Malachite","Rp 999.999","(999)"));
        sanPhamList.add(new SanPham(R.drawable.icon_hoa,"Vert Malachite","Rp 999.999","(999)"));
        sanPhamList.add(new SanPham(R.drawable.icon_hoa,"Vert Malachite","Rp 999.999","(999)"));



    }
    public void SPNew(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity(), RecyclerView.VERTICAL, false);
        rcySpNew.setLayoutManager (linearLayoutManager);
        rcySpNew.setHasFixedSize(true);

        listSPNew = new ListSPNew(getActivity(),sanPhamList1);
        rcySpNew.setAdapter(listSPNew);
        sanPhamList1.add(new SanPham(R.drawable.fram1,"Essencia","Rp 999.999","(999)"));
        sanPhamList1.add(new SanPham(R.drawable.fram2,"Sauvage","Rp 999.999","(999)"));
        sanPhamList1.add(new SanPham(R.drawable.fram1,"Soothing","Rp 999.999","(999)"));




    }

    public void mapping(){
        rcyDanhMuc = view.findViewById(R.id.rcyDanhMuc);
        rcySp = view.findViewById(R.id.rcySp);
        rcySpNew = view.findViewById(R.id.rcySpNew);
    }
}
