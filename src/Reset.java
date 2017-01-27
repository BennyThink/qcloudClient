/*
 * Copyright (C) 2017 Benny~
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import com.benny.utilities.util;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Benny~
 */
public class Reset extends javax.swing.JFrame {

    public String rInstanceID;
    public  Map rAuth=new HashMap();  
    public String rRegion;
    /**
     * Creates new form reset
     */
    public Reset() {
        initComponents();
        setLocationRelativeTo(null);
       
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConfirmReset = new javax.swing.JButton();
        OSType = new javax.swing.JComboBox<>();
        OSPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("重装系统");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/benny/images/ico.png")));
        setResizable(false);

        ConfirmReset.setText("确定重装");
        ConfirmReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmResetMouseClicked(evt);
            }
        });

        OSType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "当前系统", "CentOS 6.7 32位", "CentOS 6.7 64位", "CentOS 7.2 64位", "Debian 8.2 32位", "Debian 8.2 64位", "Debian 7.8 32位", "Debian 7.8 64位", "openSUSE 13.2 64位", "FreeBSD 10.1 64位", "CoreOS 717.3.0 64位", "Ubuntu Server 14.04.1 LTS 32位", "Ubuntu Server 14.04.1 LTS 64位", "Ubuntu Server 16.04.1 LTS 32位", "Ubuntu Server 16.04.1 LTS 64位", "Windows Server 2012 R2 标准版 64位中文版", "Windows Server 2012 R2 数据中心版 64位中文版", "Windows Server 2008 R2 企业版 SP1 64位" }));

        OSPassword.setToolTipText("<html>Linux实例密码必须8到16位，至少包括两项[a-z，A-Z]、[0-9] 和 [( ) ` ~ ! @ # $ % ^ & - + = | { } [ ] : ; ' , . ? / ]中的特殊符号。<br>\nWindows实例密码必须12到16位，至少包括三项[a-z]，[A-Z]，[0-9] 和 [( ) ` ~ ! @ # $ % ^ & - + = { } [ ] : ; ' , . ? /]中的特殊符号。</html>");

        jLabel1.setText("系统：");

        jLabel2.setText("密码：");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(ConfirmReset))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(OSType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(OSPassword)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OSType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(OSPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(ConfirmReset)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmResetMouseClicked
        // TODO add your handling code here:重装确定按钮
        //rRegion是中文名字
       //
        if(OSPassword.getPassword().length!=0)
           System.out.println(rAuth+"\n"+rInstanceID+rRegion);
        else{
            JOptionPane.showMessageDialog(rootPane, "未输入密码");
            return;}

        String str=Arrays.toString(OSPassword.getPassword());
        str=str.replace(",", "").replace("[", "").replace("]", "").replace(" ", "");       
        util test=new util();
        str=test.resetOS(rAuth, rRegion, rInstanceID, str,test.getImageID(OSType.getSelectedItem().toString()));
        if(str=="1")
            JOptionPane.showMessageDialog(rootPane, "重装成功");
        else
            JOptionPane.showMessageDialog(rootPane, "错误代码"+str,"重装出错了",JOptionPane.INFORMATION_MESSAGE);
        
        
        
    }//GEN-LAST:event_ConfirmResetMouseClicked

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
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmReset;
    private javax.swing.JPasswordField OSPassword;
    private javax.swing.JComboBox<String> OSType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
