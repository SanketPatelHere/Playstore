package com.example.nestedrv;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LocationDataAdapter extends RecyclerView.Adapter<LocationDataAdapter.SingleItemRowHolder> {

    private ArrayList<LocationPojo> itemsList;
    private Context mContext;

    public LocationDataAdapter(Context context, ArrayList<LocationPojo> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }
    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    @Override
    public LocationDataAdapter.SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_location_item, null);
        LocationDataAdapter.SingleItemRowHolder mh = new LocationDataAdapter.SingleItemRowHolder(v);
        return mh;
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvDateTime, tvAddress, tvAddressNote;

        public SingleItemRowHolder(View view) {
            super(view);

            this.tvDateTime = (TextView) view.findViewById(R.id.tvDateTime);
            this.tvAddress = (TextView) view.findViewById(R.id.tvAddress);
            this.tvAddressNote = (TextView) view.findViewById(R.id.tvAddressNote);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), tvDateTime.getText(), Toast.LENGTH_SHORT).show();
                }
            });


        }

    }

    @Override
    public void onBindViewHolder(LocationDataAdapter.SingleItemRowHolder holder, int i) {

        LocationPojo locationItem = itemsList.get(i);

        holder.tvDateTime.setText(locationItem.getDate()+"");
        holder.tvAddress.setText(locationItem.getAddress()+"");
        holder.tvAddressNote.setText(locationItem.getAddressNote()+"");



    }





}