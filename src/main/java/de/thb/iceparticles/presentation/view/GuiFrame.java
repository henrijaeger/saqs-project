package de.thb.iceparticles.presentation.view;

import de.thb.iceparticles.presentation.controller.IViewController;
import de.thb.iceparticles.presentation.controller.FormPresenter;
import de.thb.iceparticles.presentation.model.ListStationDto;
import de.thb.iceparticles.presentation.view.component.FormComponent;
import de.thb.iceparticles.presentation.view.component.ListStationRenderer;
import de.thb.iceparticles.service.IStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Slf4j
@Component
public class GuiFrame extends JFrame {

    private final transient IStationService stationService;
    private final transient IViewController controller;

    private FormPresenter formPresenter;

    @Autowired
    public GuiFrame(IStationService stationService, IViewController controller) {
        this.stationService = stationService;
        this.controller = controller;

        init();
        createLayout();
    }

    private void init() {
        setTitle("ICEP - Stations");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout() {
        JPanel mainPanel = new JPanel(new GridLayout());
        mainPanel.setSize(getSize());

        JList<ListStationDto> stations = new JList<>(controller.getStationModel());
        stations.setCellRenderer(new ListStationRenderer());
        stations.addListSelectionListener(e -> {
            controller.selectStation(e.getFirstIndex());

            formPresenter.loadStation(stations.getSelectionModel().getMinSelectionIndex());
        });

        JScrollPane stationScrollPane = new JScrollPane(stations);
        stationScrollPane.setMinimumSize(new Dimension(300, 200));

        FormComponent form = new FormComponent();
        formPresenter = new FormPresenter(stationService, form);

        mainPanel.add(stationScrollPane);
        mainPanel.add(form.getPanel());

        add(mainPanel);
    }

}
