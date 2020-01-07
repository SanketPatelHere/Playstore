package com.example.nestedrv;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SectionDataModel> allSampleData;
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
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));
            dm.setAllItemsInLocation(locationItem);
            allSampleData.add(dm);
        }


        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);

    }
}
