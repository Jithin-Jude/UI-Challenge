package com.codingmortals.learncodeonline.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codingmortals.learncodeonline.R;
import com.codingmortals.learncodeonline.activities.MainActivity;
import com.codingmortals.learncodeonline.utils.MyAnimator;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment implements View.OnClickListener {
    // Store instance variables
    private String title;
    private int page;
    static SignInFragment fragmentFirst;
    TextInputEditText tiEmail,tiPassworrd;
    Button bSignIn,bGoogle,bFacebook;
    TextView bSignUp;
    private View logo,editTexts,buttons,tvLogin,bottomLayout;

    // newInstance constructor for creating fragment with arguments
    public static SignInFragment newInstance() {
        fragmentFirst = new SignInFragment();
        return fragmentFirst;
    }


    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_login, container, false);

        tiEmail = v.findViewById(R.id.etEmail);
        tiPassworrd = v.findViewById(R.id.etPassword);

        logo = v.findViewById(R.id.logo);
        buttons = v.findViewById(R.id.buttons);
        editTexts = v.findViewById(R.id.linearLayoutCompat);
        tvLogin = v.findViewById(R.id.tvLogin);
        bottomLayout = v.findViewById(R.id.bottomtextlayout);


        bSignIn = v.findViewById(R.id.bSignIn);
        bSignUp = v.findViewById(R.id.bSignUp);
        bFacebook = v.findViewById(R.id.bFacebook);
        bGoogle= v.findViewById(R.id.bGoogle);

        bSignIn.setOnClickListener(this);
        bSignUp.setOnClickListener(this);
        bGoogle.setOnClickListener(this);
        bFacebook.setOnClickListener(this);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        AnimateThings();
    }

    private void AnimateThings() {
        ArrayList<View> arrayList =  new ArrayList<>();
        arrayList.add(logo);
        arrayList.add(tvLogin);
        arrayList.add(editTexts);
        arrayList.add(bSignIn);
        arrayList.add(buttons);
        arrayList.add(bottomLayout);
        MyAnimator.Animate(arrayList,MyAnimator.LEFT);
    }



    @Override
    public void onClick(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        switch(view.getId()){
            case R.id.bSignIn:
                alertDialog.setMessage("Email: "+tiEmail.getText()+"\nPassword: "+tiPassworrd.getText()+"\nSuccessfully Sign in");
                alertDialog.show();
                break;
            case R.id.bSignUp:
                assert getActivity() != null;
                ((MainActivity)getActivity()).viewPager.setCurrentItem(1,true);
                break;
            case R.id.bGoogle:
            case R.id.bFacebook:
                alertDialog.setMessage("Not Implemented !!!");
                alertDialog.show();

                break;
        }
    }

}
