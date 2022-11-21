package de.thb.iceparticles.view.component;

import de.thb.iceparticles.controller.dto.ListStationDto;

import javax.swing.*;
import java.awt.*;

public class ListStationRenderer extends JLabel implements ListCellRenderer<ListStationDto> {

    @Override
    public Component getListCellRendererComponent(JList<? extends ListStationDto> list, ListStationDto value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.getId());

        if (isSelected) {
            setForeground(Color.RED);
        } else {
            setForeground(Color.BLACK);
        }

        return this;
    }

}
