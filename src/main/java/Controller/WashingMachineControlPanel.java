package Controller;

import State.WashingMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sami on 15-Mar-17.
 */
public class WashingMachineControlPanel extends JFrame {
    private JLabel label_title;
    private JRadioButton offRadioButton_pwrOff;
    private JRadioButton onRadioButton_pwrOn;
    private JLabel label_power;
    private JLabel label_detergent;
    private JCheckBox checkBox_detergent;
    private JLabel label_Program;
    private JComboBox comboBox_program;
    private JButton button_wash;
    private JPanel mypanel;
    private JTextField textArea_monitor;

    WashingMachine wm = new WashingMachine();
    private boolean washButton_clicked = false;

    public WashingMachineControlPanel(){
        super("Washing machine");
        setContentPane(mypanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(400,250);
        comboBox_program.addItem("");
        comboBox_program.addItem("Cotton 40c");
        comboBox_program.addItem("Cotton 60c");
        comboBox_program.addItem("Synthetic 30c");
        comboBox_program.addItem("Fast program");
        setVisible(true);


        button_wash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (!washButton_clicked){
                    if (wm.machinePowderInserted && wm.machineProgramSelected){
                        button_wash.setText("Stop");
                        wm.startMachine();
                        textArea_monitor.setText(wm.getMonitorString());
                        washButton_clicked=true;
                    } else {
                        wm.startMachine();
                        textArea_monitor.setText(wm.getMonitorString());
                    }

                } else {
                    if (wm.machinePowerOn){
                        comboBox_program.setSelectedIndex(0);
                        wm.stopMachine();
                        textArea_monitor.setText(wm.getMonitorString());
                        button_wash.setText("Wash!");
                        checkBox_detergent.setSelected(false);
                        wm = new WashingMachine();
                        washButton_clicked=false;
                    } else {
                        wm.startMachine();
                        textArea_monitor.setText(wm.getMonitorString());
                    }

                }
            }
        });
        checkBox_detergent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (checkBox_detergent.isSelected()){
                    wm.addPowder();
                    textArea_monitor.setText(wm.getMonitorString());
                }
            }
        });
        comboBox_program.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(!wm.machinePowerOn){
                    if(!checkBox_detergent.isSelected()){
                           comboBox_program.setSelectedIndex(0);
                    }
                    wm.selectProgram(comboBox_program.getSelectedIndex());
                    textArea_monitor.setText(wm.getMonitorString());
                } else {
                    wm.selectProgram(comboBox_program.getSelectedIndex());
                    textArea_monitor.setText(wm.getMonitorString());
                }

            }
        });
        onRadioButton_pwrOn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                wm = new WashingMachine();
                checkBox_detergent.setEnabled(true);
                comboBox_program.setEnabled(true);
                button_wash.setEnabled(true);
                textArea_monitor.setText("Washing machine's power is on.");
            }
        });
        offRadioButton_pwrOff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                wm = new WashingMachine();
                checkBox_detergent.setSelected(false);
                checkBox_detergent.setEnabled(false);
                comboBox_program.setSelectedIndex(0);
                comboBox_program.setEnabled(false);
                button_wash.setEnabled(false);
                textArea_monitor.setText("Washing machine's power is off.");
            }
        });
    }

}
