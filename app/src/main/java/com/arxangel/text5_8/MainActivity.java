package com.arxangel.text5_8;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    List<Item> items = new ArrayList<>();
    MyAdapter mAdapter;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    MyDialogFragment dialogTestFragment;
    String chosePerson = "man";
    Button btnMan;
    Button btnWoman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMan = (Button)findViewById(R.id.btnMan);
        btnWoman = (Button)findViewById(R.id.btnWoman);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(items);
        mRecyclerView.setAdapter(mAdapter);
        btnMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                dialogTestFragment = new MyDialogFragment();
                dialogTestFragment.show(manager, "dialog");
                dialogTestFragment.setDialogResult(new MyDialogFragment.OnMyDialogResult(){
                    public void finish(String result){
                        addItem("man", result,1);

                    }
                });
            }
        });
        btnWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                dialogTestFragment = new MyDialogFragment();
                dialogTestFragment.show(manager, "dialog");
                dialogTestFragment.setDialogResult(new MyDialogFragment.OnMyDialogResult(){
                    public void finish(String result){
                        addItem("woman", result,2);

                    }
                });
            }
        });
    }

    public void addItem(String chosePerson,String result, int type){
        items.add(new Item(chosePerson,result,type));
        mAdapter.notifyDataSetChanged();
        mRecyclerView.smoothScrollToPosition(mRecyclerView.getAdapter().getItemCount() - 1);
    }

}
