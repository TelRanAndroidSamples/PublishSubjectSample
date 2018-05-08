package com.sheygam.rxjavapublishsubject;

import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;

public class Interactor {
    private PublishSubject<String> subject;
    private static final Interactor instance = new Interactor();
    private Interactor(){
        subject = PublishSubject.create();

    }

    public static Interactor getInstance(){
        return instance;
    }

    public void immit(String count){
        subject.onNext(count);
    }

    public void subscribe(Observer<String> observer){
        subject.subscribe(observer);
    }
}
