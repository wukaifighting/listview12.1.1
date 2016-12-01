package com.listview121.listview121;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mLst;
    private List<String> datdas;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLst = (ListView) findViewById(R.id.lst_main);
        datdas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datdas.add("第" + i + "条数据");
        }
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datdas);
        mLst.setAdapter(mAdapter);
        //动态设置LISTVIEW高度
//        setlistview(mLst);
    }

    //动态设置listview 高度
    public void setlistview(ListView listview) {
        //获取listview 对应的适配器
        ListAdapter listAdapter = listview.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int tiotalheight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            //listadapter ,getcount()发送数据的数目
            View listitem = listAdapter.getView(i, null, listview);
            //计算view的宽度
            //测量宽高，执行完之后，子项目高度就会有
            listitem.measure(0, 0);
            //统计所有字项目的高度
            tiotalheight += listitem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams parmas=listview.getLayoutParams();
        //listview.getdividerheught 获取子项目分隔符的高度
        parmas.height=tiotalheight+(listview.getDividerHeight()*(listAdapter.getCount()-1));
        listview.setLayoutParams(parmas);
    }
}

