package view;

import controller.Spielcontroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Programmieraufgaben
 *
 * @author Arbias Imeri
 * @version 1.2
 * @since 07.07.2021
 */
public class Einstellungen extends JDialog{
    JComboBox jComboBox;
    JCheckBox jokerkarte;
    JRadioButton singleplaxer;
    JRadioButton multiplayer;
    JButton speichern;
    JPanel panel;
    JPanel panel2;
    Spielcontroller spielcontroller;

    public Einstellungen(Frame frame, MutableComboBoxModel<String> daten) {
        super(frame);
        JDialog modalesGUI = new JDialog(frame, "Einstellungen", true);
        modalesGUI.setSize(450, 450);
        jComboBox = new JComboBox(daten);
        jokerkarte = new JCheckBox("Jokerkarte");
        singleplaxer = new JRadioButton("Singleplayer");
        multiplayer = new JRadioButton("Multiplayer");
        speichern = new JButton("Speichern");
        spielcontroller = new Spielcontroller();


        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(jComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 45)));
        panel.add(jokerkarte);
        panel.add(Box.createRigidArea(new Dimension(0, 45)));
        panel.add(singleplaxer);
        panel.add(Box.createRigidArea(new Dimension(0, 45)));
        panel.add(multiplayer);
        panel.add(Box.createRigidArea(new Dimension(0, 45)));
        panel.add(speichern);


        panel2 = new JPanel();
        panel2.add(panel);

        jComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        jokerkarte.setAlignmentX(Component.CENTER_ALIGNMENT);
        singleplaxer.setAlignmentX(Component.CENTER_ALIGNMENT);
        multiplayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        speichern.setAlignmentX(Component.CENTER_ALIGNMENT);

        jComboBox.setFont(new Font("Impact", Font.PLAIN, 18));
        jokerkarte.setFont(new Font("Impact", Font.PLAIN, 18));
        singleplaxer.setFont(new Font("Impact", Font.PLAIN, 18));
        multiplayer.setFont(new Font("Impact", Font.PLAIN, 18));
        speichern.setFont(new Font("Impact", Font.PLAIN, 18));

        modalesGUI.setBackground(new Color(144, 238, 144));
        panel2.setBackground(new Color(144, 238, 144));
        panel.setBackground(new Color(144, 238, 144));


        modalesGUI.getContentPane().setLayout(new BorderLayout(1, 1));
        modalesGUI.getContentPane().add(panel2, BorderLayout.CENTER);

        singleplaxer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (singleplaxer.isSelected()){
                    multiplayer.setSelected(false);
                }else{
                    multiplayer.setSelected(true);
                }
            }
        });

        multiplayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (multiplayer.isSelected()){
                    singleplaxer.setSelected(false);

                }else{
                    singleplaxer.setSelected(true);
                }
            }
        });

        speichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (jComboBox.getSelectedItem().equals(null)){
                        System.out.println("Kein Wert wurde ausgewählt");
                    }if(jComboBox.getSelectedItem()!= null && singleplaxer.isSelected() == true){
                        singleplaxer.setSelected(true);
                    spielcontroller.singleplayer(jComboBox.getSelectedItem().toString());
                        modalesGUI.dispose();
                    }else if (jComboBox.getSelectedItem()!= null && multiplayer.isSelected() == true){
                        multiplayer.setSelected(true);
                        spielcontroller.multiplayer(jComboBox.getSelectedItem().toString());
                        modalesGUI.dispose();
                    }
                }

        });




        modalesGUI.setVisible(true);
    }
}


