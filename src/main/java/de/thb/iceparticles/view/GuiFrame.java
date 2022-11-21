package de.thb.iceparticles.view;

import de.thb.iceparticles.controller.dto.ListStationDto;
import de.thb.iceparticles.view.component.ListStationRenderer;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class GuiFrame extends JFrame {

    public GuiFrame() {
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

        DefaultListModel<ListStationDto> stationsModel = new DefaultListModel<>();
        stationsModel.addElement(ListStationDto.builder().id("hallo welt 1").build());
        stationsModel.addElement(ListStationDto.builder().id("hallo welt 2").build());
        stationsModel.addElement(ListStationDto.builder().id("hallo welt 3").build());

        JScrollPane stationScrollPane = new JScrollPane();
        stationScrollPane.setSize(300, 200);
        stationScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JList<ListStationDto> stations = new JList<>(stationsModel);
        stations.setCellRenderer(new ListStationRenderer());

       // stationScrollPane.add(stations);
        mainPanel.add(stations);
        add(mainPanel);
    }

}
