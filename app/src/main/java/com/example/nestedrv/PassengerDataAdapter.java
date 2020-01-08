package com.example.nestedrv;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PassengerDataAdapter extends RecyclerView.Adapter<PassengerDataAdapter.SingleItemRowHolder> {

    private ArrayList<PassengerPojo> itemsList;
    private Context mContext;

    public PassengerDataAdapter(Context context, ArrayList<PassengerPojo> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    @Override
    public PassengerDataAdapter.SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_passenger_item, null);
        PassengerDataAdapter.SingleItemRowHolder mh = new PassengerDataAdapter.SingleItemRowHolder(v);
        return mh;
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        protected ImageView imgUser;
        protected TextView tvName, tvEmail, tvPhone;

        public SingleItemRowHolder(View view) {
            super(view);

            this.imgUser = (ImageView) view.findViewById(R.id.imgUser);
            this.tvName = (TextView) view.findViewById(R.id.tvName);
            this.tvEmail = (TextView) view.findViewById(R.id.tvEmail);
            this.tvPhone = (TextView) view.findViewById(R.id.tvPhone);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), tvName.getText(), Toast.LENGTH_SHORT).show();
                }
            });


        }

    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        PassengerPojo passengerItem = itemsList.get(i);

        holder.imgUser.setImageResource(passengerItem.getImg());
        holder.tvName.setText(passengerItem.getName() + "");
        holder.tvEmail.setText("Email : "+passengerItem.getEmail() + "");
        holder.tvPhone.setText("Contact No.: "+passengerItem.getPhone() + "");
    }
}