package com.arxangel.text5_8;

import android.content.Context;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Архангел on 02.08.2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    final int MAN = 1;
    final int WOMAN = 2;

    private List<Item> itemDataSet;


    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView textName;




        public MyViewHolder(View itemView){
            super (itemView);
            this.textName = (TextView) itemView.findViewById(R.id.textChat);

        }
    }
    public MyAdapter(List<Item> items){
        itemDataSet = items;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = -1;
        switch (viewType) {
            case MAN:
                layout = R.layout.item_man;
                break;
            case WOMAN:
                layout = R.layout.item_woman;
                break;
        }
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int listPosition) {
        Item item = itemDataSet.get(listPosition);
        holder.textName.setText(item.getText());

        }

    @Override
    public int getItemViewType(int position) {
        if(itemDataSet.get(position).getType()==1)return MAN;
        else return WOMAN;

        /*return itemDataSet.get(position).getType();*/
        /*return super.getItemViewType(position);*/


    }

    @Override
    public int getItemCount() {
        return itemDataSet.size();
    }
}
  /*  @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = -1;
        switch (viewType) {
            case Message.TYPE_MESSAGE:
                layout = R.layout.item_message;
                break;
            case Message.TYPE_LOG:
                layout = R.layout.item_log;
                break;
            case Message.TYPE_ACTION:
                layout = R.layout.item_action;
                break;
        }
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(layout, parent, false);
        return new ViewHolder(v);
    }
*/
