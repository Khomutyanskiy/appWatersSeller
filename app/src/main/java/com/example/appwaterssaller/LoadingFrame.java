package com.example.appwaterssaller;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class LoadingFrame extends Fragment {



    public LoadingFrame(FragmentManager fm) {


        Fragment fragmentProduct = fm.findFragmentById(R.id.mainframe);
        if (fragmentProduct == null) {
            fragmentProduct = new ProductFragment();
            addFragmentToActivity(fm,fragmentProduct,R.id.mainframe);
        }

        Fragment fragmentManedgment = fm.findFragmentById(R.id.managementframe);
        if (fragmentManedgment == null) {
            fragmentManedgment = new ManagementFragment();
            addFragmentToActivity(fm,fragmentManedgment,R.id.managementframe);
        }


    }


    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
