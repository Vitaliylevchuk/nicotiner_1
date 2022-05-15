package com.nicotiner_1.Out;

import com.nicotiner_1.Out.gui.Buttons;
import com.nicotiner_1.Out.gui.Outs;
import com.nicotiner_1.Person.Health;
import com.nicotiner_1.Vape;

import javax.swing.*;
import java.awt.*;

public class GUIController {

    private static final JFrame jFrame = new JFrame();
    private static final JLabel label = new JLabel();

    public GUIController(Vape vape, Health health){
        frameConfiguring(jFrame);
        Outs outs = new Outs(jFrame);
        Buttons buttons = new Buttons(jFrame, vape, health, outs);

        jFrame.repaint();
        jFrame.revalidate();
    }

    private void frameConfiguring(JFrame jFrame) {
        jFrame.getContentPane().setBackground(Color.darkGray);
        jFrame.setBounds(0, 0, 465, 700);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setTitle("Nicotiner");
        jFrame.getContentPane().add(label);
    }


}
