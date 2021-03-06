package com.example.appwaterssaller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ManagementFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ManagementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManagementFragment extends Fragment implements onManagementFragmentDataListner {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView mTextAmounts;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView textorderprice;
    private ImageView buttongotobasket;
    private OrderBasket mOrderBasket;
    Double OrderPrice = 0.0;


    private  onManagementFragmentDataListner mFragmentListner;


    public ManagementFragment() {
        // Required empty public constructor


    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ManagementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ManagementFragment newInstance(String param1, String param2) {
        ManagementFragment fragment = new ManagementFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_management, container, false);
        textorderprice = (TextView) v.findViewById(R.id.textorderprice);
        buttongotobasket = (ImageView) v.findViewById(R.id.buttongotobasket);


        buttongotobasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        if ((mOrderBasket != null) && (OrderPrice !=0.0)){
            Intent intent = new Intent(getActivity(),BasketActivity.class);
            startActivity(intent);
        }

            }
        });
        return v;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onManagementFragmentDataListner) {
            mFragmentListner = (onManagementFragmentDataListner) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragment1DataListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFragmentListner = null;
    }

    @Override
    public void onManagementFragmentDataListner(Double d, OrderBasket orderBasket) {
        textorderprice.setText("Стоимость заказа - "+ d +" руб");
        OrderPrice = d;
        mOrderBasket = orderBasket;

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

        void setOrderPrice (Double d);
    }

}
