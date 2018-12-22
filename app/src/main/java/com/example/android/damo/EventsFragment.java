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
public class EventsFragment extends Fragment {

    private ArrayList<Trending> events = new ArrayList<>();
    private ArrayList<Location> locations = new ArrayList<>();


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview, container, false);
        if (events.size() == 0) {
            add_locations();
            events.add(new Trending(getString(R.string.sunburn_title), getString(R.string.sunburn_short_des), R.drawable.sunburn, "4.5", locations.get(0), getString(R.string.sunburn)));
            events.add(new Trending(getString(R.string.circus_title), getString(R.string.circus_short_des), R.drawable.circus, "4.3", locations.get(1), getString(R.string.circus)));
            events.add(new Trending(getString(R.string.jetty_title), getString(R.string.jetty_short_des), R.drawable.painting, "4.1", locations.get(2), getString(R.string.painting_competition)));
            events.add(new Trending(getString(R.string.swim_team), getString(R.string.swim_short_des), R.drawable.pool, "4.8", locations.get(3), getString(R.string.swim)));
            events.add(new Trending(getString(R.string.fair_title), getString(R.string.fair_short_des), R.drawable.beachimage, "3.8", locations.get(5), getString(R.string.daman_fair)));
        }
        ListView listView = view.findViewById(R.id.list_view);
        ListAdapterTrends listAdapter = new ListAdapterTrends(getActivity(), events);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", events.get(position).getmName());
                bundle.putString("description", events.get(position).getmDetails());
                bundle.putString("rating", events.get(position).getmRating());
                bundle.putInt("image", events.get(position).getmImage());
                bundle.putDouble("latitude", events.get(position).getLocation().getLatitude());
                bundle.putDouble("longitude", events.get(position).getLocation().getLongitude());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }

    private void add_locations() {
        //LightHouse Coordinates
        locations.add(new Location(20.4082, 72.8331));
        //Jetty Coordinates
        locations.add(new Location(20.4129, 72.8330));
        //Jampore Coordinates
        locations.add(new Location(20.380942, 72.823853));
        //The deltin Coordinates
        locations.add(new Location(20.4130, 72.8567));
        //Sunset point Coordinates
        locations.add(new Location(20.4342, 72.8328));
        //Fort Coordinates
        locations.add(new Location(20.4129, 72.8330));
        //Devka Garden coordinates
        locations.add(new Location(20.4478, 72.8358));
        //The Mashal Chowk Coordinates
        locations.add(new Location(20.4216, 72.8411));
        //Devka Beach Coordinates
        locations.add(new Location(20.4478, 72.8358));
    }
}
