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
public class FoodFragment extends Fragment {
    ArrayList<FoodCustomClass> restaurants = new ArrayList<>();
    private ArrayList<Location> locations = new ArrayList<>();

    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview, container, false);
        if (restaurants.size() == 0) {
            add_locations();
            restaurants.add(new FoodCustomClass(getString(R.string.deltin_title), getString(R.string.deltin_short_des), R.drawable.deltin_image, "4.9", locations.get(0), getString(R.string.deltin_des)));
            restaurants.add(new FoodCustomClass(getString(R.string.gold_beach_title), getString(R.string.gold_beach_short_des), R.drawable.sea_rock_image, "4.8", locations.get(1), getString(R.string.gold_beach_des)));
            restaurants.add(new FoodCustomClass(getString(R.string.black_title), getString(R.string.black_short_des), R.drawable.princesspark, "4.3", locations.get(2), getString(R.string.black_pep_des)));
            restaurants.add(new FoodCustomClass(getString(R.string.cidade_title), getString(R.string.cidade_short_des), R.drawable.hotel, "4.1", locations.get(3), getString(R.string.cidacde_des)));
            restaurants.add(new FoodCustomClass(getString(R.string.sea_rock_title), getString(R.string.searock_short_des), R.drawable.fries, "4.2", locations.get(4), getString(R.string.sea_rock_des)));
            restaurants.add(new FoodCustomClass(getString(R.string.meraki_title), getString(R.string.meraki_short_des), R.drawable.meraki, "3.8", locations.get(5), getString(R.string.black_pep_des)));
            restaurants.add(new FoodCustomClass(getString(R.string.miramar_title), getString(R.string.miramar_short_des), R.drawable.restraunt, "4.8", locations.get(6), getString(R.string.miramar)));
            restaurants.add(new FoodCustomClass(getString(R.string.oceano_title), getString(R.string.oceano_short_des), R.drawable.pizza, "3.9", locations.get(7), getString(R.string.black_pep_des)));
            restaurants.add(new FoodCustomClass(getString(R.string.mirasol_title), getString(R.string.mirasol_short_des), R.drawable.food_item, "4.2", locations.get(8), getString(R.string.mirasol)));
            restaurants.add(new FoodCustomClass(getString(R.string.sandy_title), getString(R.string.sandy_short_des), R.drawable.burger, "3.8", locations.get(9), getString(R.string.black_pep_des)));
            restaurants.add(new FoodCustomClass(getString(R.string.veera_title), getString(R.string.veera_short_des), R.drawable.coffee_images, "4.6", locations.get(10), getString(R.string.black_pep_des)));
            restaurants.add(new FoodCustomClass(getString(R.string.palm_title), getString(R.string.palm_short_des), R.drawable.coffee, "4.0", locations.get(11), getString(R.string.black_pep_des)));
            restaurants.add(new FoodCustomClass(getString(R.string.sai_kripa_title), getString(R.string.sai_kripa_short_des), R.drawable.momos, "2.9", locations.get(12), getString(R.string.black_pep_des)));
        }
        ListView listView = view.findViewById(R.id.list_view);
        ListAdapterFood listfoodadapter = new ListAdapterFood(getActivity(), restaurants);
        listView.setAdapter(listfoodadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", restaurants.get(position).getmRestaurant());
                bundle.putString("description", restaurants.get(position).getBig_description());
                bundle.putString("rating", restaurants.get(position).getmRating());
                bundle.putInt("image", restaurants.get(position).getmImageid());
                bundle.putDouble("latitude", restaurants.get(position).getLocation().getLatitude());
                bundle.putDouble("longitude", restaurants.get(position).getLocation().getLongitude());
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
