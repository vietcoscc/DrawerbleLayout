package com.example.vaio.drawerblelayout;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.t3h.adapter.ListViewAdapter;
import com.t3h.model.ItemListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
//    private final int arrImage[] = {R.drawable.angry, R.drawable.bored, R.drawable.confused,
//            R.drawable.crying, R.drawable.embarrassed, R.drawable.emoticons, R.drawable.happy,
//            R.drawable.unhappy, R.drawable.ill, R.drawable.kissing, R.drawable.mad, R.drawable.nerd,
//            R.drawable.ninja, R.drawable.quiet, R.drawable.sad, R.drawable.secret, R.drawable.smart,
//            R.drawable.smile, R.drawable.smiling, R.drawable.surprised, R.drawable.suspicious, R.drawable.wink};
//    private final String arrName[] = {"Angry", "Bored", "Confused", "Crying", "Embrrassed",
//            "Emoticons", "Happy", "Unhappy", "Ill", "Kissing", "Mad", "Nerd", "Ninja",
//            "Quiet", "Sad", "Secret", "Smart", "Smile", "Smiling", "Surprised", "Suspicious", "Wink"};

    private  final  int arrImage []= {R.drawable.confused,R.drawable.happy,R.drawable.happy_1,
    R.drawable.happy_2,R.drawable.in_love,R.drawable.sad,R.drawable.smiling,R.drawable.unhappy};
    private final String arrName [] = {"Confused","Happy","Happy 1","Happy 2","In love","Sad","Smilling","UnHappy"};
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private ListView listView;
    private ArrayList<ItemListView> arrItemListView = new ArrayList<>();
    private ListViewAdapter listViewAdapter;
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Status");
        initData();
        initViews();
    }

    private void initData() {
        for(int i=0;i<arrImage.length;i++){
            ItemListView item = new ItemListView(arrImage[i],arrName[i]);
            arrItemListView.add(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void initViews() {




        listViewAdapter = new ListViewAdapter(this,arrItemListView);
        listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
        listView.setScrollingCacheEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        imageView = (ImageView) findViewById(R.id.iv_main);
        imageView.setImageResource(arrItemListView.get(position).getIv());
        textView = (TextView) findViewById(R.id.tv_name_main);
        textView.setText(arrItemListView.get(position).getTv());
        drawerLayout.closeDrawers();
    }
}
