package com.nicotiner_1.Out.gui;

import javax.swing.*;
import java.awt.*;

public class Outs {

    private static final JLabel jLabel = new JLabel();
    private static JFrame jFrame;
    private static String txt;

    public Outs(JFrame jFrame) {
        Outs.jFrame = jFrame;
        jLabel.setBounds(0, 0, 500, 100);
        jLabel.setOpaque(true);
        jLabel.setBackground(Color.gray);
        jLabel.setVisible(true);
        jFrame.getContentPane().add(jLabel);
    }

    public void setText(String text){
        txt = text;
    }

    public void repaint(){
        jLabel.setBounds(0, 0, 500, 100);
        jLabel.setText(txt);
        jLabel.setOpaque(true);
        jLabel.setBackground(Color.gray);
        jLabel.setVisible(true);
        jFrame.getContentPane().add(jLabel);
    }

}
