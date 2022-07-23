package com.citas.ganaderias.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.citas.ganaderias.R;
import androidx.fragment.app.Fragment;





public class Migranja extends Fragment {

    public TextView nameFarm,ganadoFarm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_migranja_fragment, container, false);
    }
}