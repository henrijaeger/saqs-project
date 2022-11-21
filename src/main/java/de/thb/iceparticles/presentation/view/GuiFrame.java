package de.thb.iceparticles.presentation.view;

import de.thb.iceparticles.presentation.controller.IViewController;
import de.thb.iceparticles.presentation.model.ListStationDto;
import de.thb.iceparticles.presentation.view.component.ListStationRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class GuiFrame extends JFrame {

    private final transient IViewController controller;

    @Autowired
    public GuiFrame(IViewController controller) {
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
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(getSize());

        JList<ListStationDto> stations = new JList<>(controller.getStationModel());
        stations.setCellRenderer(new ListStationRenderer());

        JScrollPane stationScrollPane = new JScrollPane(stations);
        stationScrollPane.setMinimumSize(new Dimension(300, 200));

        // --
        JPanel formPanel = new JPanel(new GridLayout());

        JButton btn = new JButton("Click me :)");
        formPanel.add(btn);

        JTextField idField = new JTextField("model");
        formPanel.add(idField);

        mainPanel.add(stationScrollPane);
        mainPanel.add(formPanel);

        add(mainPanel);
    }

}
