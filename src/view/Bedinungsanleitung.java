package view;

import javax.swing.*;
import java.awt.*;

/**
 * M326
 *
 * @author Arbias Imeri
 * @version 1.2
 * @since 09.07.2021
 */
public class Bedinungsanleitung extends JDialog{
    JPanel jPanel;
    JPanel panelFuerPanel;
    JLabel ersterAbschnitt;
    JLabel zweiterAbschnitt;
    JLabel dritterAbschnitt;

    public Bedinungsanleitung(Frame frame){
        super(frame);
        JDialog modalesGUI = new JDialog(frame, "Einstellungen", true);
        modalesGUI.setSize(700, 700);

        ersterAbschnitt = new JLabel("- Bevor man spielt öffnet man die Einstellungen. Dort ist die Konfiguration des Spiels enthalten" +
                "Man wählt aus, wie gross das Feld sein soll, ob man mit einer Jokerkarte spielt oder nicht und welchen Modus man gerne spielen möchte. Im Anschluss speichert man die Konfiguratio mit dem Speichern button und startet das Spiel");


        zweiterAbschnitt = new JLabel("- Wenn man das Spiel gestartet hat, sucht man sich 2 identische Karten. Zwei dieser Karten geben, also ein Kartenpaar geben 1 Punkt, während eine Jokerkarte 2 Punkte gibt. " +
                "Der Multiplayer beinhaltet 2 Spieler, der Singleplayer nur einen. Beim Multiplayer wechselt es die Spieler automatisch nach jedem Zug, in dem der andere Spieler kein Kartenpaar aufgedeckt hat.");

        dritterAbschnitt = new JLabel("- Zum Schluss, wenn man das Spiel fertig gespielt hat, kommt die Auswertung. Beim Multiplayer wird angezeigt, welcher Spieler gewonnen hat, während beim Singleplayer zuerst ermittelt wird, " +
                "ob man zu den 10 besten gehört. Ist das der Fall, so wird man in die Rangliste aufgenommen und die Rangliste wird angezeigt.");

        ersterAbschnitt.setFont(new Font("Impact", Font.PLAIN, 20));
        zweiterAbschnitt.setFont(new Font("Impact", Font.PLAIN, 20));
        dritterAbschnitt.setFont(new Font("Impact", Font.PLAIN, 20));

        ersterAbschnitt.setAlignmentX(Component.CENTER_ALIGNMENT);
        zweiterAbschnitt.setAlignmentX(Component.CENTER_ALIGNMENT);
        dritterAbschnitt.setAlignmentX(Component.CENTER_ALIGNMENT);

        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
        jPanel.add(ersterAbschnitt);
        jPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        jPanel.add(zweiterAbschnitt);
        jPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        jPanel.add(dritterAbschnitt);
        panelFuerPanel = new JPanel();
        panelFuerPanel.add(jPanel);

        modalesGUI.setBackground(new Color(144, 238, 144));
        panelFuerPanel.setBackground(new Color(144, 238, 144));
        jPanel.setBackground(new Color(144, 238, 144));

        modalesGUI.getContentPane().setLayout(new BorderLayout(1, 1));
        modalesGUI.getContentPane().add(panelFuerPanel, BorderLayout.CENTER);

        modalesGUI.setVisible(true);



    }
}
