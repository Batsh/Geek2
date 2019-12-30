package com.example.muradmomani.anothaone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import java.util.LinkedHashMap;
import java.util.Random;

public class HomeFragment extends Fragment {
    LinkedHashMap<Integer, String> meMap;
    int random;
    int i;
    TextView tv, tv2;
    ImageView mv1;
    RatingBar rb;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        try {

            meMap = new LinkedHashMap<Integer, String>();

            i = 0;

            meMap.put(0, "THE GODFATHER");
            meMap.put(1, "INTERSTELLAR");
            meMap.put(2, "8MILE");
            meMap.put(3, "FIGHTCLUB");
            meMap.put(4, "IDENTITY");

            Random ran = new Random();
            random = ran.nextInt(5);
            mv1 = (ImageView) view.findViewById(R.id.mvImage);
            tv = (TextView) view.findViewById(R.id.mvtitle);
            tv2 = (TextView) view.findViewById(R.id.bio);
            rb = view.findViewById(R.id.star);

            while (i != random) {
                i++;
            }
            tv.setText(meMap.get(i));

            switch (i) {
                case 0:
                    mv1.setImageResource(R.drawable.gf);
                    rb.setRating(5);
                    tv2.setText("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
                    break;
                case 1:
                    mv1.setImageResource(R.drawable.interstellar);
                    rb.setRating((float) 4.7);
                    tv2.setText("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
                    break;
                case 2:
                    mv1.setImageResource(R.drawable.mile8);
                    rb.setRating((float) 3.2);
                    tv2.setText("A young rapper, struggling with every aspect of his life, wants to make it big but his friends and foes make this odyssey of rap harder than it may seem.");
                    break;
                case 3:
                    mv1.setImageResource(R.drawable.fightclub);
                    rb.setRating((float) 4.5);
                    tv2.setText("An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.");
                    break;
                case 4:
                    mv1.setImageResource(R.drawable.identity);
                    rb.setRating((float) 2.4);
                    tv2.setText("Stranded at a desolate Nevada motel during a nasty rain-storm, ten strangers become acquainted with each other when they realize that they're being killed off one by one.");
                    break;
            }
            //Iterator myVeryOwnIterator = meMap.keySet().iterator();
        } catch (RuntimeException e2) {
            i = 0;
            tv.setText(meMap.get(i));
            mv1.setImageResource(R.drawable.gf);
            rb.setRating(5);
            tv2.setText("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        }
        return view;
    }
}
