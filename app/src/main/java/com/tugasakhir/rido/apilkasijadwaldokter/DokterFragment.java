package com.tugasakhir.rido.apilkasijadwaldokter;


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
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DokterFragment extends Fragment {
    ArrayList<ModelDokter> listItemDokter = new ArrayList<>();
    RecyclerView myRecyclerView;
    String namaDokter[] = {"Malian", "Ridho", "Aldho", "Danny", "Shaffan"};
    String spesialistDokter[] = {"Mata", "Kejiwaan", "Jantung", "Syaraf", "Otak"};
    int Images[] = {R.mipmap.ic_profile, R.mipmap.doctor, R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, R.mipmap.ic_profile};
    String Jadwal[] = {"6.00-12.00", "12.30-16.30", "11.00-17.00", "12.00-15.00", "8.00-11.00"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeList();
    }


    public DokterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dokter, container, false);
        myRecyclerView = (RecyclerView) view.findViewById(R.id.cardViewDokter);
        myRecyclerView.setHasFixedSize(true);

        LinearLayoutManager MyLinearLayoutManager = new LinearLayoutManager(getActivity());
        MyLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (listItemDokter.size() > 0 & myRecyclerView != null) {
            myRecyclerView.setAdapter(new MyAdapter(listItemDokter));
        }
        myRecyclerView.setLayoutManager(MyLinearLayoutManager);


        return view;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private ArrayList<ModelDokter> list;
        public MyAdapter(ArrayList<ModelDokter> Data) {
            list = Data;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_items_dokter, parent, false);

            MyViewHolder holder = new MyViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.namaDokter.setText(list.get(position).getNama());
            holder.Spesialist.setText(list.get(position).getSpesialis());
            holder.Jadwal.setText(list.get(position).getJadwal());
            holder.coverImage.setImageResource(list.get(position).getImageResourceID());
            holder.coverImage.setTag(list.get(position).getImageResourceID());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Gue Ganteng", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView namaDokter;
            TextView Spesialist;
            TextView Jadwal;
            ImageView coverImage;
            CardView cardView;


            public MyViewHolder(View v) {
                super(v);

                coverImage = (ImageView) v.findViewById(R.id.coverImageViewdokter);
                namaDokter = (TextView) v.findViewById(R.id.namadokter);
                Spesialist = (TextView) v.findViewById(R.id.spesialist);
                Jadwal = (TextView) v.findViewById(R.id.jadwal);
                cardView = (CardView) v.findViewById(R.id.cardview_dokter);
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private void initializeList() {
        listItemDokter.clear();

        for (int i = 0; i<5; i++) {
            ModelDokter item = new ModelDokter();
            item.setNama(namaDokter[i]);
            item.setSpesialis(spesialistDokter[i]);
            item.setJadwal(Jadwal[i]);
            item.setImageResourceID(Images[i]);
            listItemDokter.add(item);
        }

    }


}
