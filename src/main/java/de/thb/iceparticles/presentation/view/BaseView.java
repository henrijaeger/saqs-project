package de.thb.iceparticles.presentation.view;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseView<T> implements IView<T> {

    private final List<ViewHandler> handlers;

    protected BaseView() {
        this.handlers = new ArrayList<>();
    }

    @Override
    public void addHandler(ViewHandler handler) {
        handlers.add(handler);
    }

    @Override
    public void notifyHandlers() {
        handlers.forEach(ViewHandler::handle);
    }
}
