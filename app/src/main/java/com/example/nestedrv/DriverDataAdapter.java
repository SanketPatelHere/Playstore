package com.example.nestedrv;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DriverDataAdapter extends RecyclerView.Adapter<DriverDataAdapter.SingleItemRowHolder> {

private ArrayList<DriverPojo> itemsList;
private Context mContext;

public DriverDataAdapter(Context context, ArrayList<DriverPojo> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
        }

@Override
public int getItemCount() {
        return itemsList.size();
        }

@Override
public DriverDataAdapter.SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_driver_item, null);
        DriverDataAdapter.SingleItemRowHolder mh = new DriverDataAdapter.SingleItemRowHolder(v);
        return mh;
        }

public class SingleItemRowHolder extends RecyclerView.ViewHolder {
    protected ImageView imgDriver;
    protected TextView tvDriverName, tvBusinessType, tvNumber;

    public SingleItemRowHolder(View view) {
        super(view);

        this.imgDriver = (ImageView) view.findViewById(R.id.imgDriver);
        this.tvDriverName = (TextView) view.findViewById(R.id.tvDriverName);
        this.tvBusinessType = (TextView) view.findViewById(R.id.tvBusinessType);
        this.tvNumber = (TextView) view.findViewById(R.id.tvNumber);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), tvDriverName.getText(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}

    @Override
    public void onBindViewHolder(DriverDataAdapter.SingleItemRowHolder holder, int i) {

        DriverPojo driverItem = itemsList.get(i);

        holder.imgDriver.setImageResource(driverItem.getImgDriver());
        holder.tvDriverName.setText(driverItem.getDriverName());
        holder.tvBusinessType.setText(driverItem.getBusinnesType() + "");
        holder.tvNumber.setText(driverItem.getNumber() + "");
        //Log.i("My Name = ",driverItem.getDriverName());
    }
}