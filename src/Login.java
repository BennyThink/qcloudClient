/*
 * Copyright (C) 2017 Benny~
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
import com.benny.utilities.ConfigReader;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Benny~
 */
public class Login extends javax.swing.JFrame {
    private int type;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/benny/images/ico.png")));
        setLocationRelativeTo(null);
        jButton2.setEnabled(false);
        //加载配置文件     
        loadConfig();
               
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chooseHost = new javax.swing.JList<>();
        hostDescription = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("腾讯云客户端（非官方） By Benny");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/benny/images/ico.png")));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        chooseHost.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        chooseHost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseHostMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(chooseHost);

        jButton2.setText("登录");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("增加");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(hostDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hostDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 加载配置文件
     */
    private void loadConfig(){
        if (isExist()) {
            ConfigReader reader = new ConfigReader("configuration.ini");
            List acquireName = reader.get("Sessions", "name");
            //List acquireComment= reader.get("Sessions","comment");
            DefaultListModel listModel = new DefaultListModel();
            chooseHost.setModel(listModel);
            for (int i = 0; i < acquireName.size(); i++) {
                listModel.addElement(acquireName.get(i).toString());
            }
        } else {
            ConfigReader reader = new ConfigReader();
            java.awt.event.MouseEvent evt = null;
            jButton3MouseClicked(evt);
        }
    
    }
    
    /**
     * 检查配置文件是否存在
     * @return 存在与否
     */
    private boolean isExist() {
        File file = new File("configuration.ini");
        if (file.exists()) 
            return true;
        else 
            return false;
        
    }
    /**
     * 创建默认配置文件
     */  
    private void createDefaultConfig(){
        
        //默认配置文件
        String sep = System.getProperty("line.separator");
        JOptionPane.showMessageDialog(null, "第一次使用，请先添加配置文件", "提示", JOptionPane.INFORMATION_MESSAGE);
        String toBeWriten = "[Sessions]"+sep+"[Sessions]"+ sep
            + "name=默认站点"+ sep
            + "secretID=你的secretID"+ sep
            + "secretKey=你的secretKey"+ sep
            + "comment=备注信息"+ sep;

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("configuration.ini", true)));
                out.write(toBeWriten);
                out.newLine();
                out.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        //弹出添加配置文件窗口
        java.awt.event.MouseEvent evt = null;
        jButton3MouseClicked(evt);
             
    }
    
    private void chooseHostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseHostMouseClicked
       
        if ("默认站点".equals(chooseHost.getSelectedValue())) 
            jButton2.setEnabled(false);
        else
             jButton2.setEnabled(true);
        ConfigReader reader = new ConfigReader("configuration.ini"); 
        List acquireComment = reader.get("Sessions", "comment");       
        //动态设置jLable
       
        hostDescription.setText("<html>名称： "+chooseHost.getSelectedValue() + "<br>"+
             "备注： "+ acquireComment.get(chooseHost.getSelectedIndex()).toString()+"</html>");
        type=chooseHost.getSelectedIndex();
        //System.out.println(type);

///////////
        
    }//GEN-LAST:event_chooseHostMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:增加配置文件                          
       
        String inputName=null,inputSecretID=null,inputSecretKey=null,inputComment=null;
        //输入主机名
        inputName=JOptionPane.showInputDialog(null,"输入主机名","建立配置文件 - 1/4",JOptionPane.INFORMATION_MESSAGE);
        //测试主机名
        if ("".equals(inputName) || inputName == null) {
            JOptionPane.showMessageDialog(rootPane, "未输入主机名", "建立配置文件 - 1/4", JOptionPane.WARNING_MESSAGE);
            return;
        } else 
            inputSecretID = JOptionPane.showInputDialog(null, "输入SecretID", "建立配置文件 - 2/4", JOptionPane.INFORMATION_MESSAGE);
        
        //测试SecretID
        if ("".equals(inputSecretID) || inputSecretID == null) {
            JOptionPane.showMessageDialog(rootPane, "未输入SecretID", "建立配置文件 - 2/4", JOptionPane.WARNING_MESSAGE);
            return;
        } else 
            inputSecretKey = JOptionPane.showInputDialog(null, "输入SecretKey", "建立配置文件 - 3/4", JOptionPane.INFORMATION_MESSAGE);
        
        //测试SecretKey
        if ("".equals(inputSecretKey) || inputSecretKey == null) {
            JOptionPane.showMessageDialog(rootPane, "未输入SecretKey", "建立配置文件 - 3/4", JOptionPane.WARNING_MESSAGE);
            return;
        } else 
            inputComment = JOptionPane.showInputDialog(null, "输入备注（可选）", "建立配置文件 - 4/4", JOptionPane.INFORMATION_MESSAGE);
        

        //配置文件存储在这四个变量中，将其写入。使用ConfigReader类。
        ConfigReader writeConfig=new ConfigReader("configuration.ini");
        Map inputMap = new HashMap();
        inputMap.put("name", inputName);
        inputMap.put("secretID", inputSecretID);
        inputMap.put("secretKey", inputSecretKey);
        inputMap.put("comment", inputComment);       
        if (writeConfig.append(inputMap)) {
            JOptionPane.showMessageDialog(rootPane, "配置文件建立成功！", "建立配置文件", JOptionPane.INFORMATION_MESSAGE);
            loadConfig();           
        }
        else
            JOptionPane.showMessageDialog(rootPane, "发生了致命错误！", "建立配置文件", JOptionPane.ERROR_MESSAGE);
       

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:登录按钮
        //读取文件，获得三个变量
        ConfigReader reader = new ConfigReader("configuration.ini");
        String acquireName= reader.get("Sessions","name").get(type);
        String acquireSecretID= reader.get("Sessions","secretID").get(type);
        String acquireSecretKey= reader.get("Sessions","secretKey").get(type);

        Console start=new Console();
        start.setVar(acquireName, acquireSecretID, acquireSecretKey);
        start.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> chooseHost;
    private javax.swing.JLabel hostDescription;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
