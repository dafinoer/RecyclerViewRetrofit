package com.example.android.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.retrofit.R;
import com.example.android.retrofit.helper.Bunga;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dafidzeko on 5/11/2016.
 */
public class BungaAdapter extends RecyclerView.Adapter<BungaAdapter.Holder> {

    private static final String TAG = BungaAdapter.class.getSimpleName();
    private List<Bunga> mBunga = new ArrayList<>();
    private final BungaKlik mListen;

    public BungaAdapter(BungaKlik listener) {
        mBunga = new ArrayList<>();
        mListen = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bunga, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Bunga bunga = mBunga.get(position);
        holder.namaBunga.setText(bunga.getName());
        holder.hargaBunga.setText("$" + Double.toString(bunga.getPrice()));

        Picasso.with(holder.itemView.getContext()).load("http://services.hanselandpetal.com/photos/" + bunga.getFoto()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mBunga.size();
    }


    public void addBunga(Bunga bunga) {
        //Log.d(TAG,bunga.getFoto());
        //   Log.d(TAG,bunga.getFoto());
        mBunga.add(bunga);
        notifyDataSetChanged();
    }

    public Bunga getAmbilBunga(int position) {
        return mBunga.get(position);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected ImageView imageView;
        protected TextView namaBunga, hargaBunga;

        public Holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.gambar_bunga);
            namaBunga = (TextView) itemView.findViewById(R.id.nama_bunga);
            hargaBunga = (TextView) itemView.findViewById(R.id.harga_bunga);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListen.onClick(getLayoutPosition());
        }
    }

    public interface BungaKlik {
        void onClick(int position);
    }

}
