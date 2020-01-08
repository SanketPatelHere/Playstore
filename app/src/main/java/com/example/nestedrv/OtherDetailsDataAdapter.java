package com.example.nestedrv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OtherDetailsDataAdapter extends RecyclerView.Adapter<OtherDetailsDataAdapter.SingleItemRowHolder> {

    private ArrayList<OtherDetailsPojo> itemsList;
    private Context mContext;

    public OtherDetailsDataAdapter(Context context, ArrayList<OtherDetailsPojo> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    @Override
    public OtherDetailsDataAdapter.SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_otherdetails_item, null);
        OtherDetailsDataAdapter.SingleItemRowHolder mh = new OtherDetailsDataAdapter.SingleItemRowHolder(v);
        return mh;
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        protected ImageView imgDetail;
        protected TextView tvDetailName, tvInfo;

        public SingleItemRowHolder(View view) {
            super(view);

            this.imgDetail = (ImageView) view.findViewById(R.id.imgDetail);
            this.tvDetailName = (TextView) view.findViewById(R.id.tvDetailName);
            this.tvInfo = (TextView) view.findViewById(R.id.tvInfo);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), tvDetailName.getText(), Toast.LENGTH_SHORT).show();
                }
            });


        }

    }

    @Override
    public void onBindViewHolder(OtherDetailsDataAdapter.SingleItemRowHolder holder, int i) {

        OtherDetailsPojo otherDetailsItem = itemsList.get(i);

        holder.imgDetail.setImageResource(otherDetailsItem.getImgDetail());
        holder.tvDetailName.setText(otherDetailsItem.getDetailName() + "");
        holder.tvInfo.setText(otherDetailsItem.getDetailInfo() + "");
    }
}