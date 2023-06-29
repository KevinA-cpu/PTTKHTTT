import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.Vector;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;

public class DangKyDichVu extends JPanel {

    public DangKyDichVu() {
        // Set the panel's layout
        setLayout(new GridBagLayout());

        // Create a titled border for the group box
        TitledBorder titledBorder = new TitledBorder("Chọn dịch vụ");
        setBorder(titledBorder);

        // Create GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add the table
        gbc.weightx = 1.0;
        addTable(gbc);
        gbc.weightx = 0.0;

        // Reset the gridy for the other components
        gbc.gridy++;

        // Add the labels
        
    }

    private void addTable(GridBagConstraints gbc) {
        // Create the table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Column 1");
        tableModel.addColumn("Column 2");
        tableModel.addColumn("Column 3");

        // Add some sample data
        tableModel.addRow(new Vector<>(3));
        tableModel.setValueAt("Data 1", 0, 0);
        tableModel.setValueAt("Data 2", 0, 1);
        tableModel.setValueAt("Data 3", 0, 2);

        // Create the table using the table model
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(400, 400));

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(scrollPane, gbc);
    }

}
