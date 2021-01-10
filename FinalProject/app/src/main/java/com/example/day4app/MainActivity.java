package com.example.day4app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final RelativeLayout rr = findViewById(R.id.ReL);
        // for the toolbar
        Toolbar toolbar = findViewById(R.id.Toolbar1);
        final LinearLayout ll = findViewById(R.id.LinearLayour);



//        AccountHeader accountHeader = new AccountHeaderBuilder()
//                .withActivity(this)
//                .withHeaderBackground(R.drawable.ic_undraw_profile_pic_ic5t)
//                .withTranslucentStatusBar(true)
//                .build();

     AccountHeader headerResult = new AccountHeaderBuilder()
             .withActivity(this)
             .withHeaderBackground(R.color.white)
             .addProfiles(
                     new ProfileDrawerItem().withName("Barrak").withEmail("BarrakMandani@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_undraw_profile_pic_ic5t))
             )
             .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
              @Override
              public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
               return false;
              }
             })
             .build();


        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_baseline_home_24);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Favorite").withIcon(R.drawable.ic_baseline_favorite_24);
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Settings");

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,

                        item2,
                        new DividerDrawerItem(),
                        item3


                        //
                )
                .build();


//        DrawerBuilder result = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbarr)
//                .addDrawerItems(
//                        item1,
//                        item2,
//                        new DividerDrawerItem(),
//                        item3
//                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//
//                        Snackbar.make(ll, "Hello", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                            }
//                        }).show();
//
//                        return false;
//                    }
//                });







       //
        ArrayList<TvShows> TvLibrary = new ArrayList<>();

        //
        TvShows bb = new TvShows("Breaking Bad", "5", "2008-2013", R.drawable.breakingbad, "62", "Crime","https://www.youtube.com/watch?v=HhesaQXLuRY");
        TvShows got = new TvShows("Game of Thrones", "8", "2011-2019", R.drawable.got, "60", "Action","https://www.youtube.com/watch?v=gcTkNV5Vg1E");
        TvShows bl = new TvShows("The Black List", "8", "2013-", R.drawable.blacklist, "155", "Crime","https://www.youtube.com/watch?v=XihA6GWIBdM");
        TvShows hof = new TvShows("House of Card", "6", "2013-2018", R.drawable.houseofcards, "73", "Drama","https://www.youtube.com/watch?v=SvSkxBYuoQY");
        TvShows suit = new TvShows("Suits", "8", "2011-2019", R.drawable.suits, "144", "Drama","https://www.youtube.com/watch?v=SYUQKm2nZNE");
        TvShows vik = new TvShows("Vikings", "6", "2013-", R.drawable.viking2, "59", "Action","https://www.youtube.com/watch?v=9GgxinPwAGc");
        TvShows ted = new TvShows("Ted Lasso", "3", "2020", R.drawable.tedlasso, "10", "Comedy","https://www.youtube.com/watch?v=3u7EIiohs6U");
        TvShows nar = new TvShows("Narcos","3","2015-2017",R.drawable.narcos,"30","Crime","https://www.youtube.com/watch?v=xl8zdCY-abw");
        TvShows frn = new TvShows("Friends","10","1994-2004",R.drawable.friends,"236","Comedy","https://www.youtube.com/watch?v=hDNNmeeJs1Q");
        TvShows twd = new TvShows("The Walking Dead","10","2010-",R.drawable.twd1,"115","Action","https://www.youtube.com/watch?v=R1v0uFms68U");


        TvLibrary.add(bb);
        TvLibrary.add(got);
        TvLibrary.add(bl);
        TvLibrary.add(hof);
        TvLibrary.add(suit);
        TvLibrary.add(vik);
        TvLibrary.add(ted);
        TvLibrary.add(nar);
        TvLibrary.add(frn);
        TvLibrary.add(twd);



        RecyclerView TvList = findViewById(R.id.rv);
        // لترتيب القائمه  عشان ماتبوض الدنيا

        TvList.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        TvList.setLayoutManager(lm);

        // نربط ال recycle view مع arraylist
        TvShowsAdapter tm = new TvShowsAdapter(TvLibrary, MainActivity.this,rr);
        TvList.setAdapter(tm);



//        Toolbar toolbar = findViewById(R.id.Toolbar1);
//        final LinearLayout ll = findViewById(R.id.LinearLayour);
//
//        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_baseline_home_24);
//        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Favorite").withIcon(R.drawable.ic_baseline_delete_24);
//        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Settings");
//
//        DrawerBuilder result = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .addDrawerItems(
//                        item1,
//                        item2,
//                        new DividerDrawerItem(),
//                        item3
//                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//
//                        Snackbar.make(ll, "Hello", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                            }
//                        }).show();
//
//                        return false;
//                    }
//                });


    }
}