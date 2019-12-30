package com.example.muradmomani.anothaone;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchFragment extends Fragment {
    private ListView mListView;
    private CustomAdapter mCustomAdapter;
    private EditText mEditText;
    private ArrayList<movies> _Movies = new ArrayList<movies>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);


        mListView=view.findViewById(R.id.list_view);
        mEditText = (EditText) view.findViewById(R.id.search);

        Intent intent = getActivity().getIntent();
        String title=intent.getStringExtra("wTitle");
        String desc=intent.getStringExtra("wDesc");

        String img=intent.getStringExtra("wImg");

        Toast.makeText(getContext(), img, Toast.LENGTH_SHORT).show();
        /*Bundle extras = getActivity().getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("wImg");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);*/

        ArrayList<movies> transactionList=new ArrayList<>();
        //movies temp=new movies();
        //temp.setTitle(title);
        //temp.setDescription(desc);
        //temp.setImages(img);

        //mCustomAdapter = new CustomAdapter(getActivity(),transactionList);
        //mListView.setAdapter(mCustomAdapter);


        Toast.makeText(getContext(), "Coming Soon", Toast.LENGTH_SHORT).show();

        mEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                mCustomAdapter.getFilter().filter(arg0);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }
        });
        return view;
    }



}