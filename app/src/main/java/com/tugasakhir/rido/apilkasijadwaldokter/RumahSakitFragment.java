package com.tugasakhir.rido.apilkasijadwaldokter;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RumahSakitFragment extends Fragment {
    
    ArrayList<ModelRumahSakit> listItemRumahSakit = new ArrayList<>();
    RecyclerView myRecyclerView;
    String namarumahsakit[] = {"RSMH","MYRIA", "CHARITAS", "RS BUNDA"};
    String alamatrumahsakit[] = {"Sudirman", "Kolonel Burlian", "Sudirman", "Demang"};
    int Images [] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeList();
    }

    public RumahSakitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rumah_sakit, container, false);
        myRecyclerView = (RecyclerView) view.findViewById(R.id.cardView);
        myRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLinearLayoutManager = new LinearLayoutManager(getActivity());
        MyLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (listItemRumahSakit.size() > 0 & myRecyclerView != null) {
            myRecyclerView.setAdapter(new MyAdapter(listItemRumahSakit));
        }
        myRecyclerView.setLayoutManager(MyLinearLayoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

         private ArrayList<ModelRumahSakit> list;

        public MyAdapter(ArrayList<ModelRumahSakit> Data) {

            list = Data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycle_items, parent, false);

            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.namaRumahSakit.setText(list.get(position).getNama());
            holder.alamatRumahSakit.setText(list.get(position).getAlamat());
            holder.coverImage.setImageResource(list.get(position).getImageResourceID());
            holder.coverImage.setTag(list.get(position).getImageResourceID());
            holder.likeImage.setTag(R.drawable.ic_like);
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Pencarian.class);
                    startActivity(intent);
                }
            });

        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView namaRumahSakit;
            public TextView alamatRumahSakit;
            public ImageView coverImage;
            public ImageView shareImage;
            public ImageView likeImage;
            public CardView cardView;

            public MyViewHolder(View v) {
                super(v);
                namaRumahSakit = (TextView) v.findViewById(R.id.namaRumahSakit);
                alamatRumahSakit = (TextView) v.findViewById(R.id.alamatRumahsakit);
                coverImage = (ImageView) v.findViewById(R.id.coverImageView);
                likeImage = (ImageView) v.findViewById(R.id.likeImageView);
                shareImage = (ImageView) v.findViewById(R.id.shareImageView);
                cardView = (CardView) v.findViewById(R.id.cardview);

            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private void initializeList() {
        listItemRumahSakit.clear();

        for (int i = 0; i<4; i++) {
            ModelRumahSakit item = new ModelRumahSakit();
            item.setNama(namarumahsakit[i]);
            item.setAlamat(alamatrumahsakit[i]);
            item.setImageResourceID(Images[i]);
            listItemRumahSakit.add(item);
        }
    }


}
