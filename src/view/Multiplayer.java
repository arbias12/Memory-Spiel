package view;

import controller.Spielcontroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

public class Multiplayer extends JFrame {
    JLabel jLabel = new JLabel("");
    Boolean vergleichen = false;

    public Multiplayer(int rows, int columns, int anzahlKarten) {
        super("Multiplayer");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Spielcontroller spielcontroller = new Spielcontroller();

        HashMap<JButton, ImageIcon> map = new HashMap<>();
        Vector<ImageIcon> vector = new Vector<>();
        for(int i = 1; i < (anzahlKarten / 2) + 1; i++) {
            ImageIcon imageIcon = new ImageIcon("Bilder\\" + i + ".jpg"); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(120, 120,  Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);  // transform it back
            imageIcon.setDescription(String.valueOf(i));

            vector.add(imageIcon);
            vector.add(imageIcon);
        }
        Collections.shuffle(vector);

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(rows, columns, 20, 20);
        panel.setLayout(layout);

        ArrayList<JButton> buttons = new ArrayList<>();
        for(int i = 0; i < vector.size(); i++) {

            JButton button = new JButton();
            panel.add(button);

            int x = i;

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (vergleichen == true){
                        try{
                            Thread.sleep(400);
                            buttons.get(1).setIcon(null);
                            buttons.get(0).setIcon(null);
                            buttons.clear();
                            vergleichen = false;
                        }catch(InterruptedException exception){}
                    }


                    buttons.add(button);


                    spielcontroller.incGedreht();
                    button.setIcon(map.get(button));
                    System.out.println();
                    if(Spielcontroller.getGedreht() == 2) {
                        String description1 = ((ImageIcon) buttons.get(0).getIcon()).getDescription();
                        String description2 = ((ImageIcon) buttons.get(1).getIcon()).getDescription();
                        System.out.println(description1);
                        System.out.println(description2);
                        if (description1.equalsIgnoreCase(description2)) {
                            buttons.get(0).setBackground(Color.black);
                            buttons.get(1).setBackground(Color.black);
                            buttons.get(0).setEnabled(false);
                            buttons.get(1).setEnabled(false);
                            buttons.clear();
                            Spielcontroller.setGedreht(0);
                        }else if(!(description1.equalsIgnoreCase(description2))){

                            vergleichen = true;
                            Spielcontroller.setGedreht(0);
                        }

                    }

                }
            });

            map.put(button, vector.get(i));


        }
        getContentPane().setLayout(new BorderLayout());
        panel.setBackground(new Color(144, 238, 144));
        getContentPane().setBackground(new Color(144, 238, 144));
        this.add(panel, BorderLayout.CENTER);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[]args){
        new Multiplayer(6, 8, 48);
    }
}