package br.com.digitalhouse.conversandocomfragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.digitalhouse.conversandocomfragments.R;
import br.com.digitalhouse.conversandocomfragments.interfaces.Comunicador;
import br.com.digitalhouse.conversandocomfragments.model.Pessoa;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private Comunicador comunicador;


    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Comunicador){
            comunicador = (Comunicador) context;
        }else {
            try {
                throw new Exception("Activity deve implementar a interface 'Comunicador");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button btnSend = view.findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pessoa person = new Pessoa("Tairo", "Professor", 30);
                comunicador.receberMenssagem(person);


            }
        });
        return view;
    }

}
