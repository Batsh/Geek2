package com.example.muradmomani.anothaone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WatchlistFragment extends Fragment {
    //ArrayAdapter<String> arrayAdapter;

    private ListView mListView;
    TextView tv;
    private EditText mEditText;
    private ArrayList<String> titles;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watchlist, container, false);

        mListView=(ListView)view.findViewById(R.id.list_view);
        mEditText = (EditText) view.findViewById(R.id.search);

        tv=view.findViewById(R.id.textV);
        titles=new ArrayList<>();

        Intent intent = getActivity().getIntent();

        String str = intent.getStringExtra("wTitle");
        Toast.makeText(getActivity().getApplicationContext(),str, Toast.LENGTH_SHORT).show();


        //tv.setText(str);
        /*try{...
        Intent intent = getActivity().getIntent();
        if(intent.getStringExtra("wTitle")!=null) {
            String str = intent.getStringExtra("wTitle");
            Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            titles.add(str);
        }

        if(!titles.isEmpty()){
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    getActivity().getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    titles );

            mListView.setAdapter(arrayAdapter);}}
            catch (NullPointerException e){
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        //mCustomAdapter = new CustomAdapter(getActivity(),transactionList);
        //mListView.setAdapter(mCustomAdapter);

*/


     /*  mEditText.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               arrayAdapter.getFilter().filter(s);
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });*/
        return view;
    }



}
