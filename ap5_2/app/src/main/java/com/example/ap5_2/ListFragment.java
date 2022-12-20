package com.example.ap5_2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ListFragment extends Fragment {
    public  static interface  ImageSelectionCallBack{
        public void onImageSelected(int position);
    }

    ImageSelectionCallBack callBack;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof ImageSelectionCallBack)
            callBack = (ImageSelectionCallBack)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        Button btn1 = rootView.findViewById(R.id.btn1);
        Button btn2 = rootView.findViewById(R.id.btn2);
        Button btn3 = rootView.findViewById(R.id.btn3);
        btn1.setOnClickListener(new MyListener(0));
        btn2.setOnClickListener(new MyListener(1));
        btn3.setOnClickListener(new MyListener(2));
        return rootView;
    }

    class MyListener implements View.OnClickListener{
        int idx;
        MyListener(int idx){
            this.idx =idx;
        }
        @Override
        public void onClick(View view) {
            callBack.onImageSelected(idx);
        }
    }
}