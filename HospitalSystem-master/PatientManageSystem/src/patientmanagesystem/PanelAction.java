/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagesystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * actions that shown in main panel all this methods returning a new panel
 *
 * @author mikep
 */
public class PanelAction {

    JPanel p = new JPanel();
    Color Lblue = new Color(191, 230, 242);
    Control control = new Control();
    PopUps pop = new PopUps();
    DataBase base;
    View v = new View();

    PanelAction(DataBase db) {
        this.base = db;
    }

    /**
     * home page photo
     *
     * @return
     */
    public JPanel HomePage() {
        p.removeAll();
        p.revalidate();
        p.repaint();
        ImageIcon hm = new ImageIcon("src\\Icons\\home.jpg");
        JLabel l = new JLabel(hm);
        p.setBackground(Lblue);
        p.add(l);
        return p;

    }

    /**
     * register patient form
     *
     * @return
     */
    public JPanel RegisterP() {
        p.removeAll();
        p.revalidate();
        p.repaint();

        JLabel l1, l2, l3, l3_5, l4, l5, l6, l7, l8, l9, l10, l11, l12;
        JTextField tf1, tf2, tf2_5, tf3, tf4, tf5, tf6, tf7, tf8;
        JButton btn1;    // register button 

        l1 = new JLabel("       Register new");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l11 = new JLabel(" Patient Form       ");
        l11.setForeground(Color.blue);
        l11.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Name");
        l3 = new JLabel("Last Name");
        l3_5 = new JLabel("Password");
        l4 = new JLabel("age");
        l5 = new JLabel("sex");
        l6 = new JLabel("fathers name");
        l7 = new JLabel("occupation");
        l8 = new JLabel("enter date ");
        l9 = new JLabel("exit date ");
        l10 = new JLabel("          ");
        l12 = new JLabel("          ");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf2_5 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();

        btn1 = new JButton("Register Patient");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // geters from text field 
                Patient patient = new Patient(tf1.getText(), tf2.getText(), tf2_5.getText(), Integer.parseInt(tf3.getText()),
                        tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText(), tf8.getText());
                try {
                    if ((tf1.getText().isEmpty()) || (tf2.getText().isEmpty()) || (tf2_5.getText().isEmpty()) || (tf3.getText().isEmpty())
                            || (tf4.getText().isEmpty()) || (tf5.getText().isEmpty()) || (tf6.getText().isEmpty()) || (tf7.getText().isEmpty()) || (tf8.getText().isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Not registered fill all fields");
                    } else {
                        control.CreatePatient(patient, base); // database 
                        JOptionPane.showMessageDialog(null, "Registered!");
                        int option = JOptionPane.OK_CANCEL_OPTION;
                        if(option==2){
                            HomePage();
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        p.setBackground(Lblue);
        p.setLayout(new GridLayout(12, 2)); // main panel

        p.add(l1);
        p.add(l11); // head label 
        p.add(l2);
        p.add(tf1);
        p.add(l3);
        p.add(tf2);
        p.add(l3_5);
        p.add(tf2_5);
        p.add(l4);
        p.add(tf3);
        p.add(l5);
        p.add(tf4);
        p.add(l6);
        p.add(tf5);
        p.add(l7);
        p.add(tf6);
        p.add(l8);
        p.add(tf7);
        p.add(l9);
        p.add(tf8);
        p.add(l10);
        p.add(l12);
        p.add(btn1); // register button 
        return p;
    }

    /**
     * register doctor doctor
     *
     * @return
     */
    public JPanel RegisterD() {
        p.removeAll();
        p.revalidate();
        p.repaint();

        JLabel l1, l2, l3, l3_5, l4, l5, l6, l7, l8, l10, l11, l12;
        JTextField tf1, tf2, tf2_5, tf3, tf4, tf5, tf6, tf7;
        JButton btn1;  // login button 

        l1 = new JLabel("       Register new");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l11 = new JLabel(" Doctor Form       ");
        l11.setForeground(Color.blue);
        l11.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Name");
        l3 = new JLabel("Last Name");
        l3_5 = new JLabel("Password");
        l4 = new JLabel("birth year");
        l5 = new JLabel("sex");
        l6 = new JLabel("fathers name");
        l7 = new JLabel("start date ");
        l8 = new JLabel("specialty");
        l10 = new JLabel("          ");
        l12 = new JLabel("          ");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf2_5 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();

        btn1 = new JButton("Register Doctor");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if ((tf1.getText().isEmpty()) || (tf2.getText().isEmpty()) || (tf2_5.getText().isEmpty()) || (tf3.getText().isEmpty())
                        || (tf4.getText().isEmpty()) || (tf5.getText().isEmpty()) || (tf6.getText().isEmpty()) || (tf7.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Not registered fill all fields");
                } else {
                    Doctor doc = new Doctor(tf1.getText(), tf2.getText(), tf2_5.getText(), Integer.parseInt(tf3.getText()),
                            tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText());
                    control.CreateDoctor(doc, base); // database
                    JOptionPane.showMessageDialog(null, "Registered");
                    int option = JOptionPane.OK_CANCEL_OPTION;
                        if(option==2){
                            HomePage();
                        }
                }
            }
        });
        p.setBackground(Lblue);
        p.setLayout(new GridLayout(12, 2));

        p.add(l1);
        p.add(l11); // head label 
        p.add(l2);
        p.add(tf1);
        p.add(l3);
        p.add(tf2);
        p.add(l3_5);
        p.add(tf2_5);
        p.add(l4);
        p.add(tf3);
        p.add(l5);
        p.add(tf4);
        p.add(l6);
        p.add(tf5);
        p.add(l7);
        p.add(tf6);
        p.add(l8);
        p.add(tf7);
        p.add(l10);
        p.add(l12);
        p.add(btn1); // login button 
        return p;
    }

    /**
     * only if user is logged in appointment form
     *
     * @param flag
     * @return
     */
    public JPanel Appointment(boolean flag) {
        p.removeAll();
        p.revalidate();
        p.repaint();
        JLabel l1, l2, l3, l3_5, l10, l11, l12, l4, l5;
        JTextField tf1, tf2, tf2_5, tf4, tf5;
        JButton btn1;    // register button 

        l1 = new JLabel("                 New");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l11 = new JLabel(" Appointment                ");
        l11.setForeground(Color.blue);
        l11.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Doctors id ");
        l3 = new JLabel("Your id");
        l3_5 = new JLabel("Date");
        l4 = new JLabel("Your name");
        l5 = new JLabel("Type of doctor");

        l10 = new JLabel("          ");
        l12 = new JLabel("          ");

        tf1 = new JTextField();  // id docotr
        tf2 = new JTextField();   // id patient 
        tf2_5 = new JTextField();   // date 
        tf4 = new JTextField(); //name
        tf5 = new JTextField();//type doctor

        btn1 = new JButton("Register an apointment");
        if (flag == true) {   // falg true means user is loged in 
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((tf1.getText().isEmpty()) || (tf2.getText().isEmpty()) || (tf2_5.getText().isEmpty())
                            || (tf4.getText().isEmpty()) || (tf5.getText().isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Not registered fill all fields");
                        
                        
                    } else {
                        // geters from text field 
                        control.CreateAppointment(Integer.parseInt(tf1.getText()), Integer.parseInt(tf2.getText()),
                                base, tf5.getText(), tf2_5.getText()); // database 
                        JOptionPane.showMessageDialog(null, "Registered!");
                        int option = JOptionPane.OK_CANCEL_OPTION;
                        if(option==2){
                            HomePage();
                        }
                    }

                }
            });
        } else {
            JOptionPane.showMessageDialog(null, " you have to login to make an appointment ");
        }
        p.setBackground(Lblue);
        p.setLayout(new GridLayout(12, 2));

        p.add(l1);
        p.add(l11); // head label 
        p.add(l5);
        p.add(tf4);// doctor type
        p.add(l2);
        p.add(tf1);// d id
        p.add(l4);
        p.add(tf5);// your name 
        p.add(l3);
        p.add(tf2);// your id 
        p.add(l3_5);
        p.add(tf2_5);//date

        p.add(l10);
        p.add(l12);
        p.add(btn1); // register button 
        return p;
    }

    /**
     * called from side bar button shows a table with all doctors and their
     * details
     *
     * @return
     * @throws SQLException
     */
    public JPanel SearchDoc() throws SQLException {
        p.removeAll();
        p.revalidate();
        p.repaint();
        ResultSet rss;

        rss = control.PrintAllDoctors(base); // database results
        JLabel lb1 = new JLabel("Id ");
        JLabel lb2 = new JLabel("Name");
        JLabel lb3 = new JLabel("LastName");
        JLabel lb4 = new JLabel("Occupation");

        JPanel pn = new JPanel(); // labels panel 
        pn.setBackground(Lblue);
        pn.setLayout(new GridLayout(1, 4));
        pn.add(lb1);
        pn.add(lb2);
        pn.add(lb3);
        pn.add(lb4);

        p.setLayout(new GridLayout(2, 1));
        p.setBackground(Lblue);// main panel

        JTable table = new JTable(buildTableModel(rss)); // doctors table
        table.setEnabled(false);

        p.add(pn);
        p.add(table);

        return p;
    }

    private static DefaultTableModel buildTableModel(ResultSet rs) // to print rs from Doc select as Jtable 
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

    /**
     * only for doctors called from menu bar button shows only theirs
     * appointments
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public JPanel CheckPatients(int id) throws SQLException {
        p.removeAll();
        p.revalidate();
        p.repaint();

        ResultSet rss = control.PrintAllPatients(base, id); // database control
        JButton b = new JButton("Delete Appointment");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pop.DeleteApp(); // call deleting new frame 
            }
        });
        JTable table = new JTable(buildTableModel(rss));
        table.setEnabled(false);

        JPanel pn = new JPanel(); // labels panel
        JPanel pn2 = new JPanel();// button panel
        pn.setBackground(Lblue);
        pn.setLayout(new GridLayout(1, 5));
        pn.add(new JLabel("id appointment    "));
        pn.add(new JLabel("patients id"));
        pn.add(new JLabel("patients name"));
        pn.add(new JLabel("date"));

        pn2.add(b, BorderLayout.CENTER);
        pn2.setBackground(Lblue);

        p.setLayout(new GridLayout(3, 1)); // main panel
        p.add(pn); // labels
        p.add(table); // appointments table 
        p.add(pn2); // delete appointment button 
        return p;
    }

    /**
     * only for admin shows the options for admin user
     *
     * @return
     */
    public JPanel Admin() {
        p.removeAll();
        p.revalidate();
        p.repaint();

        JButton b1 = new JButton("delete doctor");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pop.DeleteDoc(); // delete doctor button
            }
        });
        JButton b2 = new JButton("delete patient");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pop.DeletePat();// delete patient button 
            }
        });
        JButton b3 = new JButton("delete app");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pop.DeleteApp(); // delete appointment button 
            }
        });
        JPanel p = new JPanel();
        p.setBackground(Lblue);
        JPanel pp = new JPanel();
        pp.setLayout(new GridLayout(3, 1)); // button panel
        pp.add(b1); // delete doctor
        pp.add(b2);// delete patient
        pp.add(b3);// delete appointment
        p.add(pp, BorderLayout.CENTER); // main panel

        return p;
    }
}
