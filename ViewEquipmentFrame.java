import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewEquipmentFrame extends JFrame {

    JTable table;

    public ViewEquipmentFrame() {

        setTitle("View Equipment");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String columns[] = {
                "ID",
                "Equipment",
                "Category",
                "Rent/Day",
                "Status"
        };

        DefaultTableModel model = new DefaultTableModel(columns,0);

        model.addRow(new Object[]{1,"JCB","Heavy",5000,"Available"});
        model.addRow(new Object[]{2,"Concrete Mixer","Construction",2000,"Available"});
        model.addRow(new Object[]{3,"Drill Machine","Tools",500,"Rented"});

        table = new JTable(model);

        JScrollPane pane = new JScrollPane(table);

        add(pane);

        setVisible(true);
    }
} 