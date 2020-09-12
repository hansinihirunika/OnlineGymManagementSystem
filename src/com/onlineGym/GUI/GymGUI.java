package com.onlineGym.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GymGUI {

    public static void main(String[] args){

        JPanel panel=new JPanel();

        panel.setLayout(null);


        panel.setLayout(null);

        // table
        JFrame frame = new JFrame();
        JTable table = new JTable();

        // create a table model and set a Column Identifiers to this model
        Object[] columns = {"Membership Number","Membership Name","Telephone Number","Address"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);


        // input

        JTextField textmembershipNumber = new JTextField();
        JTextField textmembershipName = new JTextField();
        JTextField textteleNo = new JTextField();
        JTextField textaddress = new JTextField();



        // LABELS
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 200, 880, 200);

        frame.setLayout(null);

        frame.add(pane);

        JLabel label=new JLabel("ONLINE  GYM  MANAGEMENT  SYSTEM");
        label.setBounds(250,0,500,30);
        pane.add(label);

        JLabel label1=new JLabel("Membership Number");
        label1.setBounds(10,30,200,25);
        pane.add(label1);

        JLabel label2=new JLabel("Membership Name");
        label2.setBounds(10,60,200,25);
        pane.add(label2);

        JLabel label3=new JLabel("Telephone Number");
        label3.setBounds(10,90,200,25);
        pane.add(label3);

        JLabel label4=new JLabel("Address");
        label4.setBounds(10,120,200,25);
        pane.add(label4);


        frame.add(textmembershipNumber);
        frame.add(textmembershipName);
        frame.add(textteleNo);
        frame.add(textaddress);
        frame.add(label);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);


        textmembershipNumber.setBounds(150, 30, 200, 30);
        textmembershipName.setBounds(150, 60, 200, 30);
        textteleNo.setBounds(150, 90, 200, 30);
        textaddress.setBounds(150, 120, 200, 30);

        //ADD delete buttons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");


        btnAdd.setBounds(500, 30, 200, 50);
        btnDelete.setBounds(500, 100, 200, 50);

        frame.add(btnAdd);
        frame.add(btnDelete);


        Object[] row = new Object[4];


        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                row[0] = textmembershipNumber.getText();
                row[1] = textmembershipName.getText();
                row[2] = textteleNo.getText();
                row[3] = textaddress.getText();

                // add row to the model
                model.addRow(row);
            }
        });

        // remove
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });

        table.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e){

                int i = table.getSelectedRow();

                textmembershipNumber.setText(model.getValueAt(i, 0).toString());
                textmembershipName.setText(model.getValueAt(i, 1).toString());
                textteleNo.setText(model.getValueAt(i, 2).toString());
                textaddress.setText(model.getValueAt(i, 3).toString());
            }
        });


        frame.setSize(920,520);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
