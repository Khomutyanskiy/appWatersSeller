package com.example.appwaterssaller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements onManagementFragmentDataListner {

    private onManagementFragmentDataListner mListenerActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        MainController mainController = new MainController(fm);




    }
    @Override
    public void onManagementFragmentDataListner(Double d, OrderBasket orderBasket) {
        System.out.println("1234");

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.managementframe);

        if (fragment instanceof onManagementFragmentDataListner) {
            mListenerActivity = (onManagementFragmentDataListner) fragment;
        } else {
            throw new RuntimeException(fragment.toString()
                    + " must implement onActivityDataListener");
        }



        mListenerActivity.onManagementFragmentDataListner(d, orderBasket );
        //System.out.println("1234");
    }

}
