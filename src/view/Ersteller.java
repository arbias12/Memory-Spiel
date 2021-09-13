package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * M326
 *
 * @author Arbias Imeri
 * @version 1.2
 * @since 08.07.2021
 */
public class Ersteller extends JFrame{
    private JLabel titel;
    private JLabel arbias;
    private JLabel leonardo;
    JPanel jPanel;
    JPanel jPanel2;

    public Ersteller(){
        super("Made-by");

        setSize(500, 500);
        titel = new JLabel("Made-by", SwingConstants.CENTER);
        arbias = new JLabel("Arbias");
        leonardo = new JLabel("Leonardo");
        jPanel = new JPanel();

        EmptyBorder border = new EmptyBorder(80, 0, 80, 0);
        titel.setBorder(border);

        titel.setFont(new Font("Arial Black", Font.PLAIN, 65));
        arbias.setFont(new Font("Impact", Font.PLAIN, 40));
        leonardo.setFont(new Font("Impact", Font.PLAIN, 40));

        arbias.setAlignmentX(Component.CENTER_ALIGNMENT);
        leonardo.setAlignmentX(Component.CENTER_ALIGNMENT);

        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
        jPanel.add(arbias);
        jPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        jPanel.add(leonardo);

        jPanel2 = new JPanel();
        jPanel2.add(jPanel);

        getContentPane().setLayout(new BorderLayout(1, 1));
        getContentPane().add(jPanel2, BorderLayout.CENTER);
        getContentPane().add(titel, BorderLayout.NORTH);
        getContentPane().setBackground(new Color(144, 238, 144));
        jPanel2.setBackground(new Color(144, 238, 144));
        jPanel.setBackground(new Color(144, 238, 144));

        setVisible(true);

    }


}
