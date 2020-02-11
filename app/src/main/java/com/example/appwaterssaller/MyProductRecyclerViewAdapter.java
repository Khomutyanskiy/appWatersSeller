package com.example.appwaterssaller;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appwaterssaller.ProductFragment.OnListFragmentInteractionListener;
import com.example.appwaterssaller.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyProductRecyclerViewAdapter extends RecyclerView.Adapter<MyProductRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
   // private final OnListFragmentInteractionListener mListener;
    private ArrayList<Product> productlist;
    private ArrayList<OrderBasket> orderlist;
    private OrderBasket orderBasket;
    private Product product;
    private final OnListFragmentInteractionListener mListener;
    private final onManagementFragmentDataListner mFragmentListner;


    public MyProductRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener, onManagementFragmentDataListner fragmentlistner) {
        mValues = items;
        mListener = listener;
        mFragmentListner = fragmentlistner;
        DataGoods dataGoods = new DataGoods();
        productlist = dataGoods.getProductlist();

        orderBasket = new OrderBasket();


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);


        if (productlist.get(position).getСapacity()!=0.0) {
            holder.mTextTitle.setText(productlist.get(position).getName() + "," + productlist.get(position).getСapacity() + "Л");
        } else {
            holder.mTextTitle.setText(productlist.get(position).getName());
            holder.mTextNamePrice.setText("Цена:");

        }


        holder.mTextDescription.setText(productlist.get(position).getDescription());

        holder.mTextPrice.setText(productlist.get(position).getPrice()+" руб");

        holder.mTextAmount.setText("" + orderBasket.getNumber(productlist.get(position)));
        holder.mTextAmounts.setText(orderBasket.getOrderAmountProduct(productlist.get(position))+" руб");

        // Нажатие кнопки плюс
        holder.mImagePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d ("123", String.valueOf(position));
                orderBasket.changeOrderPlus(productlist.get(position));
                holder.mTextAmount.setText("" + orderBasket.getNumber(productlist.get(position)));
                holder.mTextAmounts.setText(orderBasket.getOrderAmountProduct(productlist.get(position))+" руб");

                mFragmentListner.onManagementFragmentDataListner(orderBasket.getAmounts(),orderBasket);
            }
        });

        // Нажатие кнопки минус
        holder.mImageMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d ("123", String.valueOf(position));
                orderBasket.changeOrderMinus(productlist.get(position));
                holder.mTextAmount.setText("" + orderBasket.getNumber(productlist.get(position)));
                holder.mTextAmounts.setText(orderBasket.getOrderAmountProduct(productlist.get(position)) +" руб");

                mFragmentListner.onManagementFragmentDataListner(orderBasket.getAmounts(),orderBasket);
            }
        });


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                  //  mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
       // return mValues.size();
        return productlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
      //  public final TextView mIdView;
        public final TextView mTextTitle;
        public final TextView mTextDescription;
        public final TextView mTextNamePrice;
        public final TextView mTextPrice;
        public final ImageView mImageMinus;
        public final ImageView mImagePlus;
        public final TextView mTextAmount;
        public final TextView mTextAmounts;
        public DummyItem mItem;


        public ViewHolder(View view) {
            super(view);
            mView = view;
           // mIdView = (TextView) view.findViewById(R.id.item_number);
            mTextTitle = (TextView) view.findViewById(R.id.textTitle);
            mTextDescription = (TextView) view.findViewById(R.id.textDescription);
            mTextNamePrice = (TextView) view.findViewById(R.id.textnameprice);
            mTextPrice = (TextView) view.findViewById(R.id.textprice);
            mImageMinus = (ImageView) view.findViewById(R.id.imageminus);
            mImagePlus = (ImageView) view.findViewById(R.id.imageplus);
            mTextAmount = (TextView) view.findViewById(R.id.textamount);
            mTextAmounts = (TextView) view.findViewById(R.id.textamounts);

        }



//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}
