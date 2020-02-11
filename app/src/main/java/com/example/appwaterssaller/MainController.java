package com.example.appwaterssaller;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainController  extends Fragment {

    public MainController(FragmentManager fragmentManager)  {

        LoadingFrame loadingFrame = new LoadingFrame(fragmentManager);

    }


}
