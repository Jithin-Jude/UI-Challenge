package com.codingmortals.learncodeonline.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
public class WelcomeFragment extends Fragment implements View.OnClickListener {

    Button bSignIn,bGoogle,bFacebook;
    TextView bSignUp;
    private View logo, tvWelcome,bottomLayout,buttons;

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);

        bSignIn = v.findViewById(R.id.bSignIn);
        bSignUp = v.findViewById(R.id.bSignUp);
        bFacebook = v.findViewById(R.id.bFacebook);
        bGoogle= v.findViewById(R.id.bGoogle);

        logo = v.findViewById(R.id.imageView);
        tvWelcome = v.findViewById(R.id.lWelcomeText);
        buttons = v.findViewById(R.id.linearLayoutCompat);
        bottomLayout = v.findViewById(R.id.bottomtextlayout);

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
        arrayList.add(tvWelcome);
        MyAnimator.Animate(arrayList,MyAnimator.UP);
        arrayList.clear();
        arrayList.add(bSignUp);
        arrayList.add(buttons);
        arrayList.add(bottomLayout);
        MyAnimator.Animate(arrayList,MyAnimator.BOTTOM);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        intent = new Intent(getContext(), MainActivity.class);
        switch(view.getId()){
            case R.id.bSignIn:
                intent.putExtra(getString(R.string.SETINITFRAGMENT),0);
                getContext().startActivity(intent);
                getActivity().finish();
                break;
            case R.id.bSignUp:
                intent.putExtra(getString(R.string.SETINITFRAGMENT),1);
                getContext().startActivity(intent);
                getActivity().finish();
                break;
            case R.id.bGoogle:
            case R.id.bFacebook:
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                alertDialog.setMessage("Not Implemented !!!");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog.show();

                break;
        }
    }
}
