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
public class TrendsFragment extends Fragment {
    private ArrayList<Trending> trending = new ArrayList<>();
    private ArrayList<Location> locations = new ArrayList<>();

    public TrendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview, container, false);
        if (trending.size() == 0) {
            add_locations();
            trending.add(new Trending(getString(R.string.lighthouse_title), getString(R.string.light_house_short_des), R.drawable.lighthouse, "4.5", locations.get(0), getString(R.string.lighthouse)));
            trending.add(new Trending(getString(R.string.devka_beach_title), getString(R.string.devka_short_des), R.drawable.black_sand, "3.9", locations.get(8), getString(R.string.devka_beach)));
            trending.add(new Trending(getString(R.string.jetty_title), getString(R.string.seaside_short_des), R.drawable.jetty_1, "4.3", locations.get(1), getString(R.string.jetty)));
            trending.add(new Trending(getString(R.string.jampore_title), getString(R.string.jampore_short_des), R.drawable.beachimage, "4.1", locations.get(2), getString(R.string.jampore)));
            trending.add(new Trending(getString(R.string.cathedral_title_big), getString(R.string.cathedral_short_des1), R.drawable.cathedral, "3.8", locations.get(4), getString(R.string.cathedral)));
            trending.add(new Trending(getString(R.string.fort_title), getString(R.string.fort_short_des), R.drawable.beach2, "3.8", locations.get(5), getString(R.string.fort)));
            trending.add(new Trending(getString(R.string.devka_title), getString(R.string.devka_short_des1), R.drawable.shell_image, "4.2", locations.get(6), getString(R.string.devka)));

        }
        ListView listView = view.findViewById(R.id.list_view);
        ListAdapterTrends listAdapter = new ListAdapterTrends(getActivity(), trending);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", trending.get(position).getmName());
                bundle.putString("rating", trending.get(position).getmRating());
                bundle.putString("description", trending.get(position).getmDetails());
                bundle.putInt("image", trending.get(position).getmImage());
                bundle.putDouble("latitude", trending.get(position).getLocation().getLatitude());
                bundle.putDouble("longitude", trending.get(position).getLocation().getLongitude());
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
