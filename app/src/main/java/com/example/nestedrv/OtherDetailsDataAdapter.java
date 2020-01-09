package com.example.nestedrv;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
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
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        OtherDetailsPojo otherDetailsItem = itemsList.get(i);
        if(i==0)  //X4 X2
        {
            Log.i("My position = ",i+"");
            SpannableStringBuilder builder = new SpannableStringBuilder();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder
                        .append(" ", new ImageSpan(mContext, R.drawable.user1), 0)
                        .append(otherDetailsItem.getDetailInfo()+" ")
                        .append(" ", new ImageSpan(mContext, R.drawable.briefcase1), 0)
                        .append(" X 2");
                holder.tvInfo.setText(builder);

            }
            else
            {
                holder.tvInfo.setText(otherDetailsItem.getDetailInfo()+"");
            }

        }
        else
        {
            holder.tvInfo.setText(otherDetailsItem.getDetailInfo() + "");

        }
        if(i==3)  //promo code
        {
            Log.i("My position = ",i+"");
            SpannableStringBuilder builder = new SpannableStringBuilder();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder
                        .append(" ", new ImageSpan(mContext, R.drawable.right1), 0)
                        .append(otherDetailsItem.getDetailInfo()+" ");
                holder.tvDetailName.setText(builder);

            }
            else
            {
                holder.tvDetailName.setText(otherDetailsItem.getDetailName() + "");
            }
        }
        else
        {
            holder.imgDetail.setImageResource(otherDetailsItem.getImgDetail());
            holder.tvDetailName.setText(otherDetailsItem.getDetailName() + "");
        }


    }
}