package com.example.nestedrv;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.ItemRowHolder> {

    private ArrayList<SectionDataModel> dataList;
    private Context mContext;

    public RecyclerViewDataAdapter(Context context, ArrayList<SectionDataModel> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;
        protected Button btnNumber;
        protected RecyclerView recycler_view_list;
        LinearLayout lvLine, lvAccessebillity;
        public ItemRowHolder(View view) {
            super(view);
            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.btnNumber = (Button) view.findViewById(R.id.btnNumber);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.rv2);
            this.lvLine = (LinearLayout) view.findViewById(R.id.lvLine);
            this.lvAccessebillity = (LinearLayout) view.findViewById(R.id.lvAccessebillity);
        }

    }

    @Override
    public void onBindViewHolder(final ItemRowHolder itemRowHolder, int i) {

        final String sectionName = dataList.get(i).getHeaderTitle();
        ArrayList locationItems = dataList.get(i).getAllItemsInLocation();  //for i=0 location
        ArrayList passengerItems = dataList.get(i).getAllItemsInPassenger();  //for i=0 location
        ArrayList otherDetailsItems = dataList.get(i).getAllItemsOtherDetails();  //for i=0 location
        ArrayList driverItems = dataList.get(i).getAllItemsInDriver();  //for i=0 location

        itemRowHolder.itemTitle.setText(sectionName);
        itemRowHolder.btnNumber.setText((i+1)+"");
        itemRowHolder.lvAccessebillity.setVisibility(View.GONE);


        if(sectionName=="Location")
        {
            Log.i("My name = ",sectionName);
            itemRowHolder.lvAccessebillity.setVisibility(View.GONE);

            LocationDataAdapter itemListDataAdapter = new LocationDataAdapter(mContext, locationItems);
            itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);

            itemRowHolder.recycler_view_list.setVisibility(View.VISIBLE);
            itemRowHolder.lvLine.setVisibility(View.VISIBLE);
        }

        //for i=2
        else if(sectionName=="Other Details")
        {
            Log.i("My name = ",sectionName);
            OtherDetailsDataAdapter itemListDataAdapter2 = new OtherDetailsDataAdapter(mContext, otherDetailsItems);
            itemRowHolder.recycler_view_list.setLayoutManager(new GridLayoutManager(mContext, 2));
            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter2);

            itemRowHolder.recycler_view_list.setVisibility(View.VISIBLE);
            itemRowHolder.lvLine.setVisibility(View.VISIBLE);
        }

        else if(sectionName=="Passenger Details")
        {
            Log.i("My name = ",sectionName);
            itemRowHolder.lvAccessebillity.setVisibility(View.GONE);

            PassengerDataAdapter itemListDataAdapter3 = new PassengerDataAdapter(mContext, passengerItems);
            itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter3);

            itemRowHolder.recycler_view_list.setVisibility(View.VISIBLE);
            itemRowHolder.lvLine.setVisibility(View.VISIBLE);
        }

        else if(sectionName=="Driver Details")
        {
            Log.i("My name = ",sectionName);
            itemRowHolder.lvAccessebillity.setVisibility(View.GONE);
            itemRowHolder.lvLine.setMinimumHeight(0);

            DriverDataAdapter itemListDataAdapter4 = new DriverDataAdapter(mContext, driverItems);
            itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext));
            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter4);
            itemRowHolder.recycler_view_list.setVisibility(View.VISIBLE);
        }



        if(sectionName!="Location") //hide other view
        {
            itemRowHolder.recycler_view_list.setVisibility(View.GONE);
        }


        itemRowHolder.itemTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Click on = "+sectionName, Toast.LENGTH_SHORT).show();
                if(itemRowHolder.recycler_view_list.getVisibility() == View.VISIBLE)
                {
                    itemRowHolder.recycler_view_list.setVisibility(View.GONE);
                    itemRowHolder.lvLine.setMinimumHeight(5);
                }
                else
                {
                    itemRowHolder.recycler_view_list.setVisibility(View.VISIBLE);
                    itemRowHolder.lvLine.setVisibility(View.VISIBLE);
                }
                if(sectionName=="Other Details")
                {
                    if(itemRowHolder.lvAccessebillity.getVisibility() == View.VISIBLE)
                    {
                        itemRowHolder.lvAccessebillity.setVisibility(View.GONE);
                    }
                    else
                    {
                        itemRowHolder.lvAccessebillity.setVisibility(View.VISIBLE);
                    }
                }
                if(sectionName=="Driver Details")
                {
                    itemRowHolder.lvLine.setVisibility(View.GONE);
                    itemRowHolder.lvLine.setMinimumHeight(0);
                }


            }
        });
        itemRowHolder.itemTitle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



}