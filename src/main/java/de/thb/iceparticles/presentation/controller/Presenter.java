package de.thb.iceparticles.presentation.controller;

import de.thb.iceparticles.presentation.view.IView;
import de.thb.iceparticles.presentation.view.ViewHandler;

// https://riptutorial.com/swing/example/14137/simple-mvp-example
public abstract class Presenter<T, V extends IView<T>> implements ViewHandler {

    protected V view;
    protected T model;

    protected Presenter(T model, V view) {
        this.model = model;
        this.view = view;
        this.view.addHandler(this);
    }

    protected void updateModel(T model) {
        this.model = model;
    }

}
