package com.nicotiner_1.Out.gui;

import com.nicotiner_1.Liquid.Nicotine;
import com.nicotiner_1.Person.Experience;
import com.nicotiner_1.Person.Health;
import com.nicotiner_1.Puff.PuffTime;
import com.nicotiner_1.Puff.PuffType;
import com.nicotiner_1.Vape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Buttons {
    private static Outs outs;
    private static Health health;
    private static JFrame jFrame;
    private static Vape vape;
    private static final JLabel label = new JLabel();
    public Buttons(JFrame jFrame, Vape vape, Health health, Outs outs) {
        Buttons.outs = outs;
        Buttons.health = health;
        Buttons.vape = vape;
        Buttons.jFrame = jFrame;

        String[] experienceValues = new String[Experience.exp.values().length];
        for (Experience.exp exp : Experience.exp.values()) {
            experienceValues[exp.ordinal()] = exp.name();
        }

        JComboBox experienceBox = new JComboBox(experienceValues);
        experienceBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        experienceBox.setEditable(false);
        experienceBox.setBackground(Color.gray);
        experienceBox.setBounds(300, 380, 150, 50);
        experienceBox.addActionListener(actionListener);
        experienceBox.addActionListener(experienceListener);
        experienceBox.setSelectedIndex(1);
        jFrame.getContentPane().add(experienceBox);


        String[] nicotineValues = new String[Nicotine.values().length];
        for (Nicotine nicotine : Nicotine.values()) {
            nicotineValues[nicotine.ordinal()] = nicotine.name();
        }

        JComboBox nicotineBox = new JComboBox(nicotineValues);
        nicotineBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        nicotineBox.setEditable(false);
        nicotineBox.setBackground(Color.gray);
        nicotineBox.setBounds(0, 120, 150, 50);
        nicotineBox.addActionListener(actionListener);
        nicotineBox.addActionListener(nicotineListener);
        nicotineBox.setSelectedIndex(4);
        jFrame.getContentPane().add(nicotineBox);


        String[] puffTypeValues = new String[PuffType.values().length];
        for (PuffType puffType : PuffType.values()) {
            puffTypeValues[puffType.ordinal()] = puffType.name();
        }

        JComboBox puffTypeBox = new JComboBox(puffTypeValues);
        puffTypeBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        puffTypeBox.setEditable(false);
        puffTypeBox.setBackground(Color.gray);
        puffTypeBox.setBounds(150, 120, 150, 50);
        puffTypeBox.addActionListener(actionListener);
        puffTypeBox.addActionListener(puffTypeListener);
        puffTypeBox.setSelectedIndex(1);
        jFrame.getContentPane().add(puffTypeBox);


        String[] puffTimeValues = new String[PuffTime.values().length];
        for (PuffTime puffTime : PuffTime.values()) {
            puffTimeValues[puffTime.ordinal()] = puffTime.name();
        }

        JComboBox puffTimeBox = new JComboBox(puffTimeValues);
        puffTimeBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        puffTimeBox.setEditable(false);
        puffTimeBox.setBackground(Color.gray);
        puffTimeBox.setBounds(300, 120, 150, 50);
        puffTimeBox.addActionListener(actionListener);
        puffTimeBox.addActionListener(puffTimeListener);
        puffTimeBox.setSelectedIndex(2);
        jFrame.getContentPane().add(puffTimeBox);

        JButton jButton = new JButton();
        jButton.setBackground(Color.gray);
        jButton.setBounds(0, 550, 150, 70);
        jButton.setText("РАССЧИТАТЬ");
        jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton.addActionListener(buttonListener);
        jFrame.getContentPane().add(jButton);
    }

    ActionListener nicotineListener = e -> {
        JComboBox box = (JComboBox)e.getSource();
        vape.setNicotine(Nicotine.values()[box.getSelectedIndex()]);
        createInfo(jFrame, health);
    };

    ActionListener puffTypeListener = e -> {
        JComboBox box = (JComboBox)e.getSource();
        vape.setPuffType(PuffType.values()[box.getSelectedIndex()]);
        createInfo(jFrame, health);
    };

    ActionListener puffTimeListener = e -> {
        JComboBox box = (JComboBox)e.getSource();
        vape.setPuffTime(PuffTime.values()[box.getSelectedIndex()]);
        createInfo(jFrame, health);
    };

    ActionListener experienceListener = e -> {
        JComboBox box = (JComboBox)e.getSource();
        vape.setExp(Experience.exp.values()[box.getSelectedIndex()]);
        createInfo(jFrame, health);
    };


    ActionListener buttonListener = e -> {
        health.calcNic(vape);
        health.calcExperience(vape);
        health.calcCloudRation(vape);
        health.calcPuffTime(vape);
        health.calcNicInOnePuff();
        System.out.println("ok");
        outs.setText(String.format("<html>Никотина в одной затяжке: %s<br>Нужная для насыщения доза никотина: %s, %s затяжек<br>Нужная для передозировки доза никотина: %s, %s затяжек<br>Нужная для смерти доза никотина: %s, %s затяжек<html>",
                health.getNicInOnePuff(),
                health.getNicToSat(), Math.round(health.getNicToSat()/health.getNicInOnePuff()),
                health.getNicToSat()*2, Math.round((health.getNicToSat()*2)/health.getNicInOnePuff()),
                Health.Nic.maxNicInBlood, Math.round(Health.Nic.maxNicInBlood/health.getNicInOnePuff())));
        outs.repaint();
    };


    ActionListener actionListener = e -> {
        JComboBox box = (JComboBox)e.getSource();
        String item = (String)box.getSelectedItem();
        label.setText(item);
    };

    public static void createInfo(JFrame jFrame, Health health){
        Color foregroundColor = Color.LIGHT_GRAY;
        Color backgroundColor = Color.DARK_GRAY;

        JLabel jLabel = new JLabel();
        jLabel.setBounds(0, 170, 150, 210);
        health.calcNic(vape);
        jLabel.setText(String.format("<html>Никотина: %s<br><br>Объём: %s<br><br>Внимание:<br>Солевой никотин крепче обычного!<html>", health.getNic(), Health.valueMl));
        jLabel.setOpaque(true);
        jLabel.setBackground(backgroundColor);
        jLabel.setForeground(foregroundColor);
        jFrame.getContentPane().add(jLabel);

        JLabel jLabel1 = new JLabel();
        jLabel1.setBounds(150, 170, 150, 210);
        health.calcCloudRation(vape);
        jLabel1.setText(String.format("<html>Воздух / Пар<br> %s / %s<br><br>Внимание:<br>Чем туже затяжка тем быстрее в насыщаетесь никотином!<html>", 100 - health.getCloudRatio(), health.getCloudRatio()));
        jLabel1.setOpaque(true);
        jLabel1.setBackground(backgroundColor);
        jLabel1.setForeground(foregroundColor);
        jFrame.getContentPane().add(jLabel1);

        JLabel jLabel2 = new JLabel();
        jLabel2.setBounds(300, 170, 150, 210);
        health.calcPuffTime(vape);
        jLabel2.setText(String.format("<html>Время: %s с<br><br>Внимание:<br>Чем дольше вы тянитесь тем быстрее вы насыщаетесь никотином!<html>", health.getPuffSec()));
        jLabel2.setOpaque(true);
        jLabel2.setBackground(backgroundColor);
        jLabel2.setForeground(foregroundColor);
        jFrame.getContentPane().add(jLabel2);

        JLabel jLabel3 = new JLabel();
        jLabel3.setBounds(300, 170, 150, 210);
        health.calcPuffTime(vape);
        jLabel3.setText(String.format("<html><html>"));
        jLabel3.setOpaque(true);
        jLabel3.setBackground(backgroundColor);
        jLabel3.setForeground(foregroundColor);
        jFrame.getContentPane().add(jLabel3);
    }

}
