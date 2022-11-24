package de.thb.iceparticles.presentation.view;

public interface IView<T> {

    void display(T model);

    T collect();

    void addHandler(ViewHandler handler);

    void notifyHandlers();

}
