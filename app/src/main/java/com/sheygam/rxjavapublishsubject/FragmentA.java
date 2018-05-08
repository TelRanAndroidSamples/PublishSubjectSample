package com.sheygam.rxjavapublishsubject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.reactivex.Observer;
import io.reactivex.observers.DisposableObserver;

public class FragmentA extends Fragment {
    private TextView resultTxt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resultTxt = view.findViewById(R.id.resultTxt);
        Interactor.getInstance().subscribe(new DisposableObserver<String>() {
            @Override
            public void onNext(String s) {
                resultTxt.setText(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        //ToDo create DisposableObserver and subscribe to interactor
    }
}
