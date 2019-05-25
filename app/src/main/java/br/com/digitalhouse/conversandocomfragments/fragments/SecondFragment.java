package br.com.digitalhouse.conversandocomfragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.digitalhouse.conversandocomfragments.R;
import br.com.digitalhouse.conversandocomfragments.model.Pessoa;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView txtViewName = view.findViewById(R.id.txtViewName);
        TextView txtViewProfession = view.findViewById(R.id.txtViewProfession);
        TextView txtViewAge = view.findViewById(R.id.txtViewAge);
        if(getArguments() != null){
            Pessoa person = getArguments().getParcelable("PERSON");
            if (person != null) {
                txtViewName.setText(person.getName());
                txtViewProfession.setText(person.getProfession());
                txtViewAge.setText(person.getAge() + "anos");
            }

        }
        return view;
    }

}
