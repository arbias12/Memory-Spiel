package view;

import controller.Spielcontroller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class App extends JFrame {
    private JLabel titel;
    private JButton startGame;
    private JButton bedinungsanleitung;
    private JButton ersteller;
    private JButton beenden;
    private JButton option;

    private JPanel buttonPanel;
    private JPanel buttonBoxPanel;
    private JPanel buttonUntenRechts;
    private JPanel wegenUnenRechts;
    Spielcontroller spielcontroller;


    public App() {
        setTitle("Memory");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(144, 238, 144));
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titel = new JLabel("Memory", SwingConstants.CENTER);
        titel.setForeground(Color.black);
        startGame = new JButton("Start Game");
        ersteller = new JButton("Made by");
        bedinungsanleitung = new JButton("Bedinungsanleitung");
        option = new JButton("Konfiguration");
        beenden = new JButton("Beenden");
        spielcontroller = new Spielcontroller();




        EmptyBorder border = new EmptyBorder(80, 0, 80, 0);
        titel.setBorder(border);

        titel.setFont(new Font("Arial Black", Font.PLAIN, 65));
        startGame.setFont(new Font("Impact", Font.PLAIN, 45));
        bedinungsanleitung.setFont(new Font("Impact", Font.PLAIN, 45));
        ersteller.setFont(new Font("Impact", Font.PLAIN, 45));

        beenden.setFont(new Font("impact", Font.PLAIN, 20));
        option.setFont(new Font("impact", Font.PLAIN, 20));

        startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        bedinungsanleitung.setAlignmentX(Component.CENTER_ALIGNMENT);
        ersteller.setAlignmentX(Component.CENTER_ALIGNMENT);


        buttonBoxPanel = new JPanel();
        buttonBoxPanel.setLayout(new BoxLayout(buttonBoxPanel, BoxLayout.PAGE_AXIS));
        buttonBoxPanel.add(startGame);
        buttonBoxPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonBoxPanel.add(bedinungsanleitung);
        buttonBoxPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonBoxPanel.add(ersteller);
        buttonPanel = new JPanel();
        buttonPanel.add(buttonBoxPanel);

        wegenUnenRechts = new JPanel(new BorderLayout());

        buttonUntenRechts = new JPanel(new BorderLayout());
        buttonUntenRechts.add(option, BorderLayout.WEST);
        buttonUntenRechts.add(Box.createRigidArea(new Dimension(20, 0)));
        buttonUntenRechts.add(beenden, BorderLayout.EAST);
        buttonUntenRechts.setBackground(new Color(144, 238, 144));

        wegenUnenRechts.add(buttonUntenRechts, BorderLayout.EAST);
        wegenUnenRechts.setBackground(new Color(144, 238, 144));


        buttonBoxPanel.setBackground(new Color(144, 238, 144));
        buttonPanel.setBackground(new Color(144, 238, 144));


        getContentPane().setLayout(new BorderLayout(1, 1));
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(titel, BorderLayout.NORTH);
        getContentPane().add(wegenUnenRechts, BorderLayout.SOUTH);

        bedinungsanleitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spielcontroller.bedinungsanleitung();
            }
        });
        //add ActionListener
        option.addActionListener(new einstellungsButton());
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spielcontroller.startGame();
            }
        });

        ersteller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ersteller();
            }
        });


        setVisible(true);
    }


    public static void main(String[] args) {
        new App();
    }

}

class einstellungsButton implements ActionListener {
    Spielcontroller spielcontroller = new Spielcontroller();

    @Override
    public void actionPerformed(ActionEvent e) {
        spielcontroller.option();
    }
}




