package com.example.nestedrv;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SectionDataModel> allSampleData;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        allSampleData = new ArrayList<>();

        String s[] = {"Location","Other Details", "Passenger Details", "Driver Details"};
        for(int i=0;i<4;i++)
        {
            SectionDataModel dm = new SectionDataModel();  //header + name, url, description
            //dm.setHeaderTitle("Section = "+i);
            dm.setHeaderTitle(s[i]);

            //for header name //name ////, url, description
            ArrayList<SingleItemModel> singleItem = new ArrayList<>();
            //name, url, description
            singleItem.add(new SingleItemModel("Item " + i));
            dm.setAllItemsInSection(singleItem);


            if(i==0)
            {
            Log.i("My location : i = ",i+"");
            //for i= 1, location
            ArrayList<LocationPojo> locationItem = new ArrayList<>();
            //date, address, addressnote
            locationItem.add(new LocationPojo("12 july 19 | 01:28 AM",
                    "One Pace Plaza, New York, NY 10038, United States",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard."));
            dm.setAllItemsInLocation(locationItem);
            }
            if(i==1)
            {

                //for i = 1, Other Details
                ArrayList<OtherDetailsPojo> otherDetailItem = new ArrayList<>();
                otherDetailItem.add(new OtherDetailsPojo(R.drawable.car1,"Business Sedan", "x 4 x 2"));
                otherDetailItem.add(new OtherDetailsPojo(R.drawable.card11,"Payment Mode", "Pay by paypal"));
                otherDetailItem.add(new OtherDetailsPojo(R.drawable.plane1,"Flight Number", "BA2490"));
                otherDetailItem.add(new OtherDetailsPojo(R.drawable.promo1,"Promo Code", "You save $52"));
                dm.setAllItemsOtherDetails(otherDetailItem);
            }

            if(i==2)
            {

            //for i = 2, Passenger Details
            ArrayList<PassengerPojo> passengerItem = new ArrayList<>();
            passengerItem.add(new PassengerPojo(R.drawable.ic_person_pin_black_24dp,"Michael Griffin", "michealgriffin@gmail.com", "7959486917"));
            dm.setAllItemsInPassenger(passengerItem);
            }


            if(i==3)
            {

            //for i = 3, Driver Details
            ArrayList<DriverPojo> driverItem = new ArrayList<>();
            driverItem.add(new DriverPojo(R.drawable.ic_person_pin_black_24dp,"Nikdrem", "Businnes Sedan | Black", "GV8042"));
            dm.setAllItemsInDriver(driverItem);
            }


            allSampleData.add(dm);

        }

        rv = (RecyclerView)findViewById(R.id.rv);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

    }

}
