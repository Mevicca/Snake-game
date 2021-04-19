package client;

import entity.Theme;
import entity.GameMode;
import entity.Media;
import entity.PanelEnum;
import entity.Player;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mevicca8
 */
public class Main {

    /**
     *
     * @param args the command line arguments
     */
    private static JLabel label = new JLabel();
    private static JFrame frame = new JFrame();
    private static MenuDriver menu;
    private static JPanel menuPane = new JPanel();
    private static Theme currentSetting = new Theme("Blue", "src/resources/rightmouth.png", "src/resources/leftmouth.png", "src/resources/downmouth.png", "src/resources/upmouth.png", "src/resources/snakeimage.png", "src/resources/enemy.png");
    private static Media currentMedia = new Media("Home", "src/resources/Marshmello-HoMe.wav");
    private static ImageIcon titleImage = new ImageIcon("src/resources/menuLogo.png");
    private static Player currentPlayer;

    public static void main(String[] args) {
        if (currentPlayer != null) {//need login first
            menu = new MenuDriver();
            menuPane = new JPanel();
            menuPane.setLayout(new BorderLayout());
            menuPane.add(logo(), BorderLayout.NORTH);
            menuPane.add(menu, BorderLayout.CENTER);

            frame.add(menuPane);
            frame.setBounds(10, 10, 905, 675);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            frame.dispose();
            PlayerLoginDriver login = new PlayerLoginDriver();
            login.setVisible(true);
            login.pack();
            login.setLocationRelativeTo(null);
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public void changePane(PanelEnum input) {
        frame.dispose();
        frame = new JFrame();

        switch (input.toString()) {
            case "Menu":
                menuPane = new JPanel();
                menu = new MenuDriver();
                menuPane.setLayout(new BorderLayout());
                menuPane.add(logo(), BorderLayout.NORTH);
                menuPane.add(menu, BorderLayout.CENTER);
                frame.add(menuPane);
                frame.setBounds(60, 0, 905, 675);
                break;
            case "Setting":
                frame.setBounds(60, 0, 905, 675);
                frame.add(new SettingDriver());
                break;
            case "LogOut":
                currentPlayer = null;
                PlayerLoginDriver login = new PlayerLoginDriver();
                login.setVisible(true);
                login.pack();
                login.setLocationRelativeTo(null);
                frame.setVisible(false);
                frame.dispose();
                break;
            case "Mode":
                frame.add(new GameModeDriver(currentSetting, currentMedia));
                frame.setBounds(60, 0, 780, 455);
                break;
            case "Leaderboard":
                frame.setBounds(60, 0, 400, 240);
                frame.add(new LeaderboardDriver());
                break;
            case "Quit":
                System.exit(-1);
                break;
            default:
                break;
        }

        if (input.toString() != "LogOut") {
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            frame.repaint();
        }

    }

    public static JPanel logo() {
        label.setIcon(titleImage);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(2, 3, 30, 30));
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 1 && col == 1) {
                    pane.add(label);
                } else {
                    pane.add(new JLabel());
                }
            }
        }
        return pane;
    }

    public void changeGamePane(GameMode currentMode, Theme currentSetting, Media currentMedia) {
        frame.dispose();
        frame = new JFrame();
        frame.add(new GameDriver(currentPlayer, currentMode, currentSetting, currentMedia));
        frame.setBounds(60, 0, 905, 675);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.repaint();
    }

    public void save(Theme currentSetting, Media currentMedia) {
        this.currentSetting = currentSetting;
        this.currentMedia = currentMedia;
        changePane(PanelEnum.Menu);
    }
    
    public void back(){
        changePane(PanelEnum.Menu);
    }

    public void storePlayer(Player player) {
        this.currentPlayer = player;
        main(null);
    }
}
