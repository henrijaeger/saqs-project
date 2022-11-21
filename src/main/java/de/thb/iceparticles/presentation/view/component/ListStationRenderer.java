package de.thb.iceparticles.presentation.view.component;

import de.thb.iceparticles.presentation.model.ListStationDto;

import javax.swing.*;
import java.awt.*;

public class ListStationRenderer extends JLabel implements ListCellRenderer<ListStationDto> {

    public ListStationRenderer() {
        setFont(new Font("monospaced", Font.PLAIN, 16));
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ListStationDto> list, ListStationDto value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.getId());

        if (isSelected) {
            setForeground(Color.WHITE);
            setBackground(new Color(100, 100, 200));
        } else {
            setForeground(new Color(100, 100, 200));
            setBackground(Color.WHITE);
        }

        return this;
    }

}
