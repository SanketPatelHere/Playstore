package com.example.nestedrv;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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
        allSampleData = new ArrayList<>();

        String s[] = {"Location","Other Details", "Passenger Details", "Driver Details"};
        for(int i=0;i<4;i++)
        {
            SectionDataModel dm = new SectionDataModel();  //header + name, url, description
            //dm.setHeaderTitle("Section = "+i);
            dm.setHeaderTitle(s[i]);

            //for i= 2, name, url, description
            ArrayList<SingleItemModel> singleItem = new ArrayList<>();
            for(int j=0;j<=5;j++)
            {
                //name, url, description
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }
            dm.setAllItemsInSection(singleItem);

            //for i= 1, location
            ArrayList<LocationPojo> locationItem = new ArrayList<>();
            //date, address, addressnote
            locationItem.add(new LocationPojo("12 july 19 | 01:28 AM",
                    "One Pace Plaza, New York, NY 10038, United States",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard."));
            dm.setAllItemsInLocation(locationItem);

            //for i = 3, Passenger Details  //img, name, email, phone
            //SectionDataModel dm = new SectionDataModel();
            ArrayList<PassengerPojo> passengerItem = new ArrayList<>();
            passengerItem.add(new PassengerPojo(R.drawable.ic_person_pin_black_24dp,"Michael Griffin", "michealgriffin@gmail.com", "7959486917"));
            dm.setAllItemsInPassenger(passengerItem);



            //for i = 4, Driver Details  //img, name, email, phone
            //SectionDataModel dm = new SectionDataModel();
            ArrayList<DriverPojo> driverItem = new ArrayList<>();
            driverItem.add(new DriverPojo(R.drawable.ic_person_pin_black_24dp,"Nikdrem", "Businnes Sedan | Black", "GV8042"));
            dm.setAllItemsInDriver(driverItem);

            //for i = 2, Other Details  //img, name, email, phone
            //SectionDataModel dm = new SectionDataModel();
            ArrayList<OtherDetailsPojo> otherDetailItem = new ArrayList<>();
            otherDetailItem.add(new OtherDetailsPojo(R.drawable.car,"Business Sedan", "x 4 x 2"));
            otherDetailItem.add(new OtherDetailsPojo(R.drawable.debitcard,"Payment Mode", "Pay by paypal"));
            otherDetailItem.add(new OtherDetailsPojo(R.drawable.jet,"Flight Number", "BA2490"));
            otherDetailItem.add(new OtherDetailsPojo(R.drawable.promo,"Promo Code", "You save $52"));
            dm.setAllItemsOtherDetails(otherDetailItem);


            allSampleData.add(dm);

        }






        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);

    }
}
