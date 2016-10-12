package com.t3h.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vaio.drawerblelayout.R;
import com.t3h.model.ItemListView;

import java.util.ArrayList;

/**
 * Created by vaio on 10/10/2016.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<ItemListView> arrItemListView ;

    public ListViewAdapter(Context context, ArrayList<ItemListView> arrItemListView) {
        this.context = context;
        this.arrItemListView = arrItemListView;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrItemListView.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder viewHolder;
        if(v==null){
            v = inflater.inflate(R.layout.lv_item,parent,false);
            viewHolder = new ViewHolder(v);
            v.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) v.getTag();
        }

        int iv = arrItemListView.get(position).getIv();
        String tv = arrItemListView.get(position).getTv();
        viewHolder.iv.setImageResource(iv);
        viewHolder.tv.setText(tv);
        return v;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
        public ViewHolder ( View v){
            iv = (ImageView) v.findViewById(R.id.iv_status);
            tv= (TextView) v.findViewById(R.id.tv_name);
        }
    }
}
