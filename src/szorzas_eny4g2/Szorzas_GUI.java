/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szorzas_eny4g2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author szili
 */
public class Szorzas_GUI {

    private JFrame frame = new JFrame("Szorzás");
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final JPanel szorzasPanel = new JPanel(new FlowLayout());
    private final JPanel aboutPanel = new JPanel(new FlowLayout());

    private JTextArea aboutText = new JTextArea("Balogh Szilveszter\nszili@szili.eu");

    private JSpinner firstSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
    private final JLabel szorzasLabel = new JLabel("*");
    private JSpinner secondSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
    private final JButton szamitasButton = new JButton("Számítás!");
    private JProgressBar progressBar = new JProgressBar();
    private JTable scoreTable = new JTable(new DefaultTableModel(new Object[]{"Első szám", "Második szám", "Eredmény"}, 0));

    public Szorzas_GUI() {
        frame.setSize(1000, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(tabbedPane);
        tabbedPane.addTab("Szorzás", szorzasPanel);
        tabbedPane.addTab("About", aboutPanel);

        szorzasPanel.add(firstSpinner);
        szorzasPanel.add(szorzasLabel);
        szorzasPanel.add(secondSpinner);
        szorzasPanel.add(szamitasButton);

        progressBar.setBounds(50, 50, 250, 30);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        szorzasPanel.add(progressBar);
        szorzasPanel.add(scoreTable);

        aboutPanel.add(aboutText);

        frame.setVisible(true);

        szamitasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int firstValue = (int) firstSpinner.getValue();
                int secondValue = (int) secondSpinner.getValue();
                int score = Szorzas_ENY4G2.multiplyNaturals(firstValue, secondValue);
                updateBar();
                updateTable(firstValue, secondValue, score);
                JOptionPane.showMessageDialog(frame, "A szorzás eredménye: " + score, "Szorzateredmény", INFORMATION_MESSAGE);
            }
        });

    }

    private void updateBar() {
        Thread t = new Thread(() -> {
            try {
                int i = 0;
                while (i <= 100) {
                    final int step = i + 1;
                    Thread.sleep(10);
                    SwingUtilities.invokeAndWait(() -> {
                        progressBar.setValue(step + 1);
                    });
                    i++;
                }

            } catch (InterruptedException | InvocationTargetException ex) {
                Logger.getLogger(Szorzas_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        t.start();
    }
        private void updateTable(int first, int second, int score) {
        DefaultTableModel model = (DefaultTableModel)scoreTable.getModel();
        model.addRow(new Object[]{first, second, score});
    }
}
