package com.example.android.damo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopAttractionsFragment extends Fragment {

    private ArrayList<FoodCustomClass> attractions = new ArrayList<>();
    private ArrayList<Location> locations = new ArrayList<>();

    public TopAttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview, container, false);
        if (attractions.size() == 0) {
            add_locations();
            attractions.add(new FoodCustomClass(getString(R.string.deltin_title), getString(R.string.deltin_short_des1), R.drawable.deltin_image, "4.9", locations.get(0), getString(R.string.deltin_des)));
            attractions.add(new FoodCustomClass(getString(R.string.sunburn_title), getString(R.string.sunburn_short_des1), R.drawable.sunburn, "4.5", locations.get(0), getString(R.string.sunburn)));
            attractions.add(new FoodCustomClass(getString(R.string.lighthouse_title), getString(R.string.lighthouse_short_des1), R.drawable.lighthouse, "4.5", locations.get(0), getString(R.string.lighthouse)));
            attractions.add(new FoodCustomClass(getString(R.string.painting_title), getString(R.string.art), R.drawable.painting, "4.1", locations.get(2), getString(R.string.painting_competition)));
            attractions.add(new FoodCustomClass((getString(R.string.sea_rock_title)), getString(R.string.sea_rock_short_des1), R.drawable.sea_rock_image, "4.2", locations.get(4), getString(R.string.sea_rock_des)));
            attractions.add(new FoodCustomClass((getString(R.string.miramar_title)), getString(R.string.miramar_short_des1), R.drawable.pizza, "4.8", locations.get(6), getString(R.string.miramar)));
            attractions.add(new FoodCustomClass(getString(R.string.cathedral_title), getString(R.string.cathedral_short_des), R.drawable.cathedral, "3.8", locations.get(4), getString(R.string.cathedral)));
            attractions.add(new FoodCustomClass(getString(R.string.mirasol_title), getString(R.string.mirasol_short_des1), R.drawable.hotel, "4.2", locations.get(8), getString(R.string.mirasol)));
        }
        ListView listView = view.findViewById(R.id.list_view);
        ListAdapterFood listfoodadapter = new ListAdapterFood(getActivity(), attractions);
        listView.setAdapter(listfoodadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", attractions.get(position).getmRestaurant());
                bundle.putString("description", attractions.get(position).getBig_description());
                bundle.putString("rating", attractions.get(position).getmRating());
                bundle.putInt("image", attractions.get(position).getmImageid());
                bundle.putDouble("latitude", attractions.get(position).getLocation().getLatitude());
                bundle.putDouble("longitude", attractions.get(position).getLocation().getLongitude());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }

    private void add_locations() {
        //The Deltin Coordinates
        locations.add(new Location(20.4130, 72.8567));
        //The GOld Beach Coordinates
        locations.add(new Location(20.4484, 72.8352));
        //The Black Pepper Coordinates
        locations.add(new Location(20.397373, 72.832802));
        //Cidade Daman Coordinates
        locations.add(new Location(20.4342, 72.8328));
        //Sea Rock Coordinates
        locations.add(new Location(20.4342, 72.8328));
        //Meraki Coordinates
        locations.add(new Location(20.4129, 72.8330));
        //Miramar coordinates
        locations.add(new Location(20.4489, 72.8353));
        //The Oceano Coordinates
        locations.add(new Location(20.4130, 72.8567));
        //The Mirasol Coordinates
        locations.add(new Location(20.4592, 72.8548));
        //The Sandy Coordinates
        locations.add(new Location(20.4558, 72.8422));
        //Veera da Dhabba Coordinates
        locations.add(new Location(20.4111, 72.8658));
        //The Palm Coordinates
        locations.add(new Location(20.4130, 72.8567));
        //Sai Kripa Coordinates
        locations.add(new Location(20.4216, 72.8411));
    }
}

