package client;

import entity.PanelEnum;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mevicca
 */
public class MenuDriver extends JPanel {

    private JButton playGameButton = new JButton("PLAY GAME");
    private JButton logOutButton = new JButton("LOG OUT");
    private JButton settingButton = new JButton("SETTING");
    private JButton leaderboardButton = new JButton("LEADERBOARD");
    private JButton quitButton = new JButton("QUIT");
    private Dimension dimension = new Dimension(40, 40);
    public Main menu = new Main();
    private PanelEnum panelSelection;

    public MenuDriver() {
        setLayout(new GridLayout(8, 5, 20, 20));
        playGameButton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.changePane(panelSelection.Mode);
            }
        }
        );
        logOutButton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.changePane(panelSelection.LogOut);
            }
        }
        );
        settingButton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.changePane(panelSelection.Setting);
            }
        }
        );
        leaderboardButton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.changePane(panelSelection.Leaderboard);
            }
        }
        );
        quitButton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.changePane(panelSelection.Quit);
            }
        }
        );

        playGameButton.setPreferredSize(dimension);
        logOutButton.setPreferredSize(dimension);
        settingButton.setPreferredSize(dimension);
        leaderboardButton.setPreferredSize(dimension);
        quitButton.setPreferredSize(dimension);

        setButton();

    }

    public void setButton() {

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 5; col++) {
                if (col == 2) {
                    switch (row) {
                        case 2:
                            add(playGameButton);
                            break;
                        case 3:
                            add(settingButton);
                            break;
                        case 4:
                            add(leaderboardButton);
                            break;
                        case 5:
                            add(quitButton);
                            break;
                        case 6:
                            add(logOutButton);
                            break;
                        default:
                            add(new JLabel());
                            break;
                    }
                } else {
                    add(new JLabel());
                }
            }
        }
    }
}
