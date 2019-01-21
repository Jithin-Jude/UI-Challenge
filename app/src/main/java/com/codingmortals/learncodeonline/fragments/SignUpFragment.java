package com.codingmortals.learncodeonline.fragments;


import android.app.AlertDialog;
import android.content.Context;
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
public class SignUpFragment extends Fragment implements View.OnClickListener {

    TextInputEditText tiName,tiEmail,tiPassworrd;
    Button bSignUp;
    TextView bSignIn;
    private View logo;
    private View editTexts;
    private View tvRegister;
    private View bottomLayout;

    // newInstance constructor for creating fragment with arguments
    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        tiEmail = v.findViewById(R.id.etEmail);
        tiName = v.findViewById(R.id.etName);
        tiPassworrd = v.findViewById(R.id.etPassword);

        bSignIn = v.findViewById(R.id.bSignIn);
        bSignUp = v.findViewById(R.id.bSignUp);

        bSignIn.setOnClickListener(this);
        bSignUp.setOnClickListener(this);

        logo = v.findViewById(R.id.logo);
        tvRegister = v.findViewById(R.id.tvRegister);
        editTexts = v.findViewById(R.id.linearLayoutCompat);
        bottomLayout = v.findViewById(R.id.bottomtextlayout);

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
        arrayList.add(tvRegister);
        arrayList.add(editTexts);
       arrayList.add(bSignUp);
        arrayList.add(bottomLayout);
        MyAnimator.Animate(arrayList,MyAnimator.RIGHT);
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
            case R.id.bSignUp:
                alertDialog.setMessage("Hello "+tiName.getText()+"\nWelcome You Sign in");
                alertDialog.show();
                break;
            case R.id.bSignIn:
                assert ((MainActivity)getActivity()) != null;
                ((MainActivity)getActivity()).viewPager.setCurrentItem(0);
                break;
            case R.id.bGoogle:
            case R.id.bFacebook:
                alertDialog.setMessage("Not Implemented !!!");
                alertDialog.show();

                break;
        }
    }
}
