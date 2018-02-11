package uinbdg.developer.surveymultibahasa.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import uinbdg.developer.surveymultibahasa.DashboardActivity;
import uinbdg.developer.surveymultibahasa.LoginActivity;
import uinbdg.developer.surveymultibahasa.R;
import uinbdg.developer.surveymultibahasa.Session;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private Button btnLogout;
    private Session session;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        session = new Session(getContext());
        if(!session.loggedin()){
            logout();
        }
        btnLogout = (Button) view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                session.setLoggedin(false, null, null);
                getActivity().finish();
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        return view;
    }

    private void logout() {

    }


}
