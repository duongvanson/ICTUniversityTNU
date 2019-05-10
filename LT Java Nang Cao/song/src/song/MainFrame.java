package song;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dvson
 */
public class MainFrame extends JFrame implements ActionListener{
    private JPanel pnlMain, pnlTitle, pnlView, pnlButton;
    private JTable tblView;
    private JButton btnAdd, btnEdit, btnDelete;
    private String arrTitle[] = {"ID", "Name", "Author", "Year"};
    private DefaultTableModel dtModel;
    private Model model = new Model();
    
    public MainFrame(){
        pnlTitle = new JPanel();
        pnlTitle.add(new JLabel("SONG"));
        
        tblView = new JTable();
        pnlView = new JPanel();
        pnlView.add(new JScrollPane(tblView));
        
        btnAdd = new JButton("ADD");
        btnAdd.addActionListener(this);
        btnDelete = new JButton("EDIT");
        btnDelete.addActionListener(this);
        btnEdit = new JButton("DELETE");
        btnEdit.addActionListener(this);
        
        pnlButton =new JPanel();
        pnlButton.add(btnAdd);
        pnlButton.add(btnEdit);
        pnlButton.add(btnDelete);
        
        pnlMain = new JPanel(new BorderLayout());
        pnlMain.add(pnlTitle, BorderLayout.PAGE_START);
        pnlMain.add(pnlView, BorderLayout.CENTER);
        pnlMain.add(pnlButton, BorderLayout.PAGE_END);
        
        this.setSize(450, 500);
        getContentPane().add(pnlMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public void loadData() throws SQLException{
        dtModel = new DefaultTableModel();
        dtModel.setColumnIdentifiers(arrTitle);
        model.connectDatabase();
        ResultSet rs = model.getAllSong();
        while(rs.next()){
            String data[] = new String[rs.getMetaData().getColumnCount()];
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                data[i] = rs.getString(i+1);
            }
            dtModel.addRow(data);
        }
        tblView.setModel(dtModel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn == btnAdd) {
            showInsertAndUpdate();
        }
    }

    private void showInsertAndUpdate() {
        JTextField txtID = new JTextField(),
                    txtName = new JTextField(),
                    txtAuthor = new JTextField(),
                    txtYear = new JTextField();
        JComponent[] component= new JComponent[]{
          new JLabel("ID"),
            txtID,
            new JLabel("Name"),
            txtName,
            new JLabel("Author"),
            txtAuthor,
            new JLabel("Year"),
            txtYear
        };
        int rsd = JOptionPane.showConfirmDialog(this,
                component, "ADD NEW SONG", JOptionPane.DEFAULT_OPTION);
    }
    
}