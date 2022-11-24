package de.thb.iceparticles.presentation.view.component;

import de.thb.iceparticles.presentation.model.StationDetailDto;
import de.thb.iceparticles.presentation.view.BaseView;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormComponent extends BaseView<StationDetailDto> {

    private JPanel panel;

    private JTextField idField;
    private JTextField dateField;
    private JTextField targetField;
    private JTextField valueField;
    private JTextField varianceField;

    public FormComponent() {
        init();
    }

    private void init() {
        panel = new JPanel();

        JLabel idLabel = new JLabel("Station ID");
        idField = new JTextField("");

        JLabel dateLabel = new JLabel("Date");
        dateField = new JTextField("");

        JLabel targetLabel = new JLabel("Target");
        targetField = new JTextField("");

        JLabel valueLabel = new JLabel("Value");
        valueField = new JTextField("");
        valueField.setEditable(false);

        JLabel varianceLabel = new JLabel("Variance");
        varianceField = new JTextField("");

        JButton commit = new JButton("Save");
        commit.addActionListener(e -> notifyHandlers());

        panel.add(idLabel);
        panel.add(idField);

        panel.add(dateLabel);
        panel.add(dateField);

        panel.add(targetLabel);
        panel.add(targetField);

        panel.add(valueLabel);
        panel.add(valueField);

        panel.add(varianceLabel);
        panel.add(varianceField);

        panel.add(commit);

        panel.setLayout(new GridLayout(6, 2));
        panel.setSize(260, 200);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    public void display(StationDetailDto station) {
        idField.setText(station.getId());

        if (station.getDate() != null) {
            dateField.setText(station.getDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        } else {
            dateField.setText("");
        }

        targetField.setText(station.getTarget() + "");
        valueField.setText(station.getValue() + "");
        varianceField.setText("f(x)");
    }

    @Override
    public StationDetailDto collect() {
        return StationDetailDto.builder()
                .id(idField.getText())
                .date(LocalDate.now())
                .target(Integer.parseInt(targetField.getText()))
                .value(Integer.parseInt(valueField.getText()))
                .build();
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JTextField getTargetField() {
        return targetField;
    }

    public JTextField getValueField() {
        return valueField;
    }
}
