
import com.benny.utilities.Region;
import com.qcloud.Module.Cvm;
import com.qcloud.QcloudApiModuleCenter;
import com.qcloud.Utilities.Json.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benny~
 */
public class Console extends javax.swing.JFrame {

    /**
     * Creates new form Console
     */
    public Console() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        hostTab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        hostSet = new javax.swing.JTabbedPane();
        instance = new javax.swing.JPanel();
        gz = new javax.swing.JRadioButton();
        sh = new javax.swing.JRadioButton();
        bj = new javax.swing.JRadioButton();
        hk = new javax.swing.JRadioButton();
        sg = new javax.swing.JRadioButton();
        ca = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        hostStatus = new javax.swing.JTable();
        snapshot = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hostSet.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        buttonGroup1.add(gz);
        gz.setText("广州");

        buttonGroup1.add(sh);
        sh.setText("上海");

        buttonGroup1.add(bj);
        bj.setText("北京");
        bj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bjMouseClicked(evt);
            }
        });

        buttonGroup1.add(hk);
        hk.setText("香港");

        buttonGroup1.add(sg);
        sg.setText("新加坡");

        buttonGroup1.add(ca);
        ca.setText("北美");

        hostStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "实例ID/主机名", "状态", "类型", "配置", "IP地址", "计费模式"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(hostStatus);

        javax.swing.GroupLayout instanceLayout = new javax.swing.GroupLayout(instance);
        instance.setLayout(instanceLayout);
        instanceLayout.setHorizontalGroup(
            instanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instanceLayout.createSequentialGroup()
                .addGroup(instanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(instanceLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(gz)
                        .addGap(10, 10, 10)
                        .addComponent(sh)
                        .addGap(18, 18, 18)
                        .addComponent(bj)
                        .addGap(18, 18, 18)
                        .addComponent(hk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sg)
                        .addGap(10, 10, 10)
                        .addComponent(ca))
                    .addGroup(instanceLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        instanceLayout.setVerticalGroup(
            instanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instanceLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(instanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gz)
                    .addComponent(sh)
                    .addComponent(bj)
                    .addComponent(hk)
                    .addComponent(sg)
                    .addComponent(ca))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );

        hostSet.addTab("实例", instance);

        javax.swing.GroupLayout snapshotLayout = new javax.swing.GroupLayout(snapshot);
        snapshot.setLayout(snapshotLayout);
        snapshotLayout.setHorizontalGroup(
            snapshotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        snapshotLayout.setVerticalGroup(
            snapshotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        hostSet.addTab("快照", snapshot);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hostSet)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hostSet)
        );

        hostTab.addTab("服务器名称", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hostTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hostTab)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bjMouseClicked
        // TODO add your handling code here:
        //System.out.println("sda");
        //获取北京节点的实例信息
        //System.out.println(bj.getText());
        //
        
        Region regionID=new Region();
        
        JSONArray test=new JSONArray();
        //2017年1月18日18:13:17
        //核心问题在于如何处理JSON数组，SDK提供了JSON相关的几个类。


/*
		TreeMap<String, Object> config = new TreeMap<String, Object>();
		config.put("SecretId", "AKIDdZS8HJeC6pMuITAGC1gx8JK9B2ijqDi1");
		config.put("SecretKey", "lQtCKI4e6bzBDWi1Cj9NPJ1XryymTC0i");
		config.put("RequestMethod", "GET");
		config.put("DefaultRegion", regionID.getRegion(bj.getText()));
		QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Cvm(),
				config);
		TreeMap<String, Object> params = new TreeMap<String, Object>();
		params.put("offset", 0);
		params.put("limit", 3);
	
		String result = null;
		try {
			result = module.call("DescribeInstances", params);
			JSONObject json_result = new JSONObject(result);
			System.out.println( json_result.get("instanceSet"));
		} catch (Exception e) {
			System.out.println("error..." + e.getMessage());
		}
        
     */   
        
        
        
        //////////
    }//GEN-LAST:event_bjMouseClicked

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
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Console.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Console().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bj;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton ca;
    private javax.swing.JRadioButton gz;
    private javax.swing.JRadioButton hk;
    private javax.swing.JTabbedPane hostSet;
    private javax.swing.JTable hostStatus;
    private javax.swing.JTabbedPane hostTab;
    private javax.swing.JPanel instance;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton sg;
    private javax.swing.JRadioButton sh;
    private javax.swing.JPanel snapshot;
    // End of variables declaration//GEN-END:variables
}
