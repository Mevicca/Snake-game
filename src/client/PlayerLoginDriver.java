package client;

import adt.LinkedList;
import entity.Player;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class PlayerLoginDriver extends javax.swing.JFrame {

    private LinkedList<Player> playerList = new LinkedList<Player>();

    /**
     * Creates new form PlayerRegister
     */
    public PlayerLoginDriver() {
        initComponents();
        this.setLocationRelativeTo(null); //center form in screen
        this.setResizable(false);
    }

    public PlayerLoginDriver(Player player) {
        playerList.add(player);
        initComponents();
        this.setLocationRelativeTo(null); //center form in screen
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_PlayerName = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jLabel_toRegister = new javax.swing.JLabel();

        jLabel3.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME TO SNAKE GAME");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/snake (1).png"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("PLAYERNAME   :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PASSWORD      :");

        jTextField_PlayerName.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTextField_PlayerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_PlayerNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_PlayerNameFocusLost(evt);
            }
        });
        jTextField_PlayerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PlayerNameActionPerformed(evt);
            }
        });
        jTextField_PlayerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_PlayerNameKeyPressed(evt);
            }
        });

        jPassword.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jPassword.setToolTipText("");
        jPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFocusLost(evt);
            }
        });
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordKeyPressed(evt);
            }
        });

        jButtonLogin.setBackground(new java.awt.Color(0, 84, 140));
        jButtonLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("Login");
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseExited(evt);
            }
        });
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabel_toRegister.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel_toRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_toRegister.setText("Register a new account");
        jLabel_toRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_toRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_toRegisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_toRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_toRegisterMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_PlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_toRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_PlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_toRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPassword.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_toRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_toRegisterMouseExited
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_toRegister.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_toRegisterMouseExited

    private void jLabel_toRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_toRegisterMouseEntered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_toRegister.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel_toRegisterMouseEntered

    private void jLabel_toRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_toRegisterMouseClicked
        PlayerRegisterationDriver register = new PlayerRegisterationDriver();
        register.setVisible(true);
        register.pack();
        register.setLocationRelativeTo(null);
        register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel_toRegisterMouseClicked

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        //get username & password
        String playerName = jTextField_PlayerName.getText();
        String password = String.valueOf(jPassword.getPassword());
        int totalOfGame = 0;
        int highestMark = 0;
        //Load data to List from text file
        BufferedReader reader = null;
        try {
            String currentLine;
            boolean login = false;

            reader = new BufferedReader(new FileReader("player.txt"));

            while ((currentLine = reader.readLine()) != null) {
                //read from file to List
                String[] playerDetails = currentLine.split("\\s"); // separate the string by white space(\\s)
                String name = playerDetails[0];
                String pw = playerDetails[1];
                totalOfGame = Integer.parseInt(playerDetails[2]);
                highestMark = Integer.parseInt(playerDetails[3]);
                Player player = new Player(name, pw, totalOfGame, highestMark);

                playerList.add(player);
            }
            //check validateLogin
            Player validLogin = new Player(playerName, password, totalOfGame, highestMark);
            //player input equal to the data in the List
            Player validPlayer = playerList.equalTo(validLogin);
            if (validPlayer != null) {
                ImageIcon icon = new ImageIcon("src/resources/success.png");
                JOptionPane.showMessageDialog(null, "Player Login Successful !", "Welcome to Snake Game", JOptionPane.INFORMATION_MESSAGE, icon);
                login = true;

                Main menu = new Main();
                menu.storePlayer(validPlayer);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();

            }
            if (login == false) {
                ImageIcon icon = new ImageIcon("src/resources/error.png");
                JOptionPane.showMessageDialog(null, "Player Name or Password Invalid", "Error", JOptionPane.INFORMATION_MESSAGE, icon);
            }
            reader.close();

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLoginMouseExited

    private void jButtonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseEntered
        //set jbutton background
        jButtonLogin.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButtonLoginMouseEntered

    private void jPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyPressed
        String password = String.valueOf(jPassword.getPassword());

        int length = password.length();
        char c = evt.getKeyChar();

        if (Character.isLetterOrDigit(c)) {
            jPassword.setEditable(true);
            if (length < 10) {
                jPassword.setEditable(true);
            } else {
                jPassword.setEditable(false);
            }
        } else {
            jPassword.setEditable(false);
        }

        //allow delete
        if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
            jPassword.setEditable(true);
        }
    }//GEN-LAST:event_jPasswordKeyPressed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusLost
        //if the password is equal to password / empty
        //set 'password' in the field
        //get password text
        String pass = String.valueOf(jPassword.getPassword());

        if (pass.trim().equals("")
                || pass.trim().toLowerCase().equals("password")) {
            jPassword.setText("password");
            jPassword.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jPasswordFocusLost

    private void jPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusGained
        //clear the password field on focus is the text is "password"

        //get password text
        String pass = String.valueOf(jPassword.getPassword());

        if (pass.trim().toLowerCase().equals("password")) {
            jPassword.setText("");
            jPassword.setForeground(Color.black);
        }
    }//GEN-LAST:event_jPasswordFocusGained

    private void jTextField_PlayerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PlayerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PlayerNameActionPerformed

    private void jTextField_PlayerNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_PlayerNameFocusLost
        //if the textField is equal to playername / empty
        //will set "Player Name / ID" in the text field
        if (jTextField_PlayerName.getText().trim().equals("")
                || jTextField_PlayerName.getText().trim().toLowerCase().equals("player name")) {
            jTextField_PlayerName.setText("Player Name");
            jTextField_PlayerName.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jTextField_PlayerNameFocusLost

    private void jTextField_PlayerNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_PlayerNameFocusGained
        //clear textfield on focus is the text is "playername"

        if (jTextField_PlayerName.getText().trim().toLowerCase().equals("player name")) {
            jTextField_PlayerName.setText("");
            jTextField_PlayerName.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextField_PlayerNameFocusGained

    private void jTextField_PlayerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PlayerNameKeyPressed
        String playerName = jTextField_PlayerName.getText();

        int length = playerName.length();
        char c = evt.getKeyChar();

        if (Character.isLetterOrDigit(c)) {
            jTextField_PlayerName.setEditable(true);
            if (length < 10) {
                jTextField_PlayerName.setEditable(true);
            } else {
                jTextField_PlayerName.setEditable(false);
            }
        } else {
            jTextField_PlayerName.setEditable(false);
        }

        //allow delete
        if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
            jTextField_PlayerName.setEditable(true);
        }
    }//GEN-LAST:event_jTextField_PlayerNameKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerLoginDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerLoginDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerLoginDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerLoginDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerLoginDriver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_toRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextField_PlayerName;
    // End of variables declaration//GEN-END:variables
}