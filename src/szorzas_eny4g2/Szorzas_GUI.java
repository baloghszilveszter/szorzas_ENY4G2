/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szorzas_eny4g2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author szili
 */
public class Szorzas_GUI {
        
    private JFrame frame = new JFrame("Szorzás");
    private JSpinner firstSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
    private JLabel szorzasLabel = new JLabel("*");
    private JSpinner secondSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
    private JButton szamitasButton = new JButton("Számítás!");
    
    public Szorzas_GUI() {
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        frame.add(firstSpinner);
        frame.add(szorzasLabel);
        frame.add(secondSpinner);
        frame.add(szamitasButton);
        
        frame.setVisible(true);
        
        szamitasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int firstValue = (int)firstSpinner.getValue();
                int secondValue = (int)secondSpinner.getValue();
                JOptionPane.showMessageDialog(frame, "A szorzás eredménye: " + Szorzas_ENY4G2.multiplyNaturals(firstValue,secondValue), "Szorzateredmény", INFORMATION_MESSAGE);
            }
        });
        
    }
}

