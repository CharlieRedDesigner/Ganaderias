package com.citas.ganaderias.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.citas.ganaderias.R;
import androidx.fragment.app.Fragment;




public class Granjas extends Fragment {

    WebView mapa_ganado;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_granjas, container, false);
        mapa_ganado = (WebView) v.findViewById(R.id.mapa_ganado);
        mapa_ganado.getSettings().setJavaScriptEnabled(true);
        mapa_ganado.setWebViewClient(new WebViewClient());
        mapa_ganado.loadUrl("https://www.google.com/maps/d/embed?mid=1i6NYf9emztypfeBIB2Xcmthf05iy6Ow&ehbc=2E312F");
        return v;


    }

}