package com.example.android.retrofit.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.retrofit.R;
import com.example.android.retrofit.helper.Bunga;
import com.example.android.retrofit.helper.Constant;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class DetailActivity extends AppCompatActivity {
    private TextView name, mId, mCategory, mIntruksi, mPrice;
    private ImageView mphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bunga bunga = (Bunga) intent.getSerializableExtra(Constant.REFERENCE.FLOWER);

        configView();

        mId.setText("" + bunga.getProductId());
        name.setText(bunga.getName());
        mCategory.setText(bunga.getCategory());
        mPrice.setText(Double.toString(bunga.getPrice()));
        mIntruksi.setText(bunga.getInstructions());

        Picasso.with(getApplicationContext()).load("http://services.hanselandpetal.com/photos/" + bunga.getFoto()).into(mphoto);
    }

    private void configView() {
        mId = (TextView) findViewById(R.id.isi_id);
        name = (TextView) findViewById(R.id.isi_nama);
        mPrice=(TextView)findViewById(R.id.isi_harga);
        mCategory = (TextView) findViewById(R.id.isi_category);
        mIntruksi = (TextView) findViewById(R.id.isi_intruksi);
        mphoto = (ImageView) findViewById(R.id.gambar_bunga_detail);
    }
}
