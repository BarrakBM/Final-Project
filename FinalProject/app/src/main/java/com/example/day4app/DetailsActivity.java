package com.example.day4app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle b = getIntent().getExtras();
        TvShows t = (TvShows) b.getSerializable("TvShows");


        ImageView img = findViewById(R.id.imagedetails);
        TextView sns = findViewById(R.id.Seasonss);
        TextView yrs = findViewById(R.id.yearss);
        TextView nam = findViewById(R.id.name);
        TextView gnr = findViewById(R.id.genre);
        TextView eps = findViewById(R.id.epesod);
        ImageView sts = findViewById(R.id.start1);
        // ImageView
        // استدعاء العناصر

        //img.setImageResource(t.getImg());
         img.setImageResource(t.getImg());
       sns.setText(t.getSeasons()+"");
       yrs.setText(t.getYear()+"");
       nam.setText(t.getName()+"");
       eps.setText(t.getEpi()+"");
       gnr.setText(t.getGenre()+"");
       sts.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(Intent.ACTION_VIEW);
               i.setData(Uri.parse(t.getUrl()+""));
               startActivity(i);
           }
       });









    }
}