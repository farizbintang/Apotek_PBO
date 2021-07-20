/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apotek;

import java.awt.HeadlessException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class produk extends javax.swing.JFrame {
    private void kosongkan_form(){
        txtkode.setEditable(true);
        txtkode.setText(null);
        txtnama.setText(null);
        txtjenis.setText(null);
        txtstok.setText(null);
        txtharga.setText(null);
    }
    private void tampilkan_data(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Jenis Produk");
        model.addColumn("Stok");
        model.addColumn("Harga Produk");
       
        try{
            
            String sql = "SELECT * FROM tabel_produk";
            java.sql.Connection conn =(Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
            }
            tabelproduk.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    private void autonumberPro(){
        try{
            Connection c = koneksi.configDB();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tabel_produk ORDER BY kode_produk DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()){
                String code = r.getString("kode_produk").substring(2);
                String BR = "" + (Integer.parseInt(code) + 1);
                String Nol = "";
                
                if(BR.length()==1){
                    Nol = "00";
                }else if(BR.length()==2){
                    Nol = "0";
                }else if(BR.length()==3){
                    Nol = "";
                }
                
                txtkode.setText("B" + Nol + BR);
                
            }else{
                txtkode.setText("B001");
            }
            r.close();
            s.close();
        }catch(Exception e){
            System.out.println("autonumber error");
        }
    }
    /**
     * Creates new form produk
     */
    public produk() {
        initComponents();
        tampilkan_data();
        kosongkan_form();
        autonumberPro();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelproduk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtjenis = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        btnkembali = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 445));
        setMinimumSize(new java.awt.Dimension(550, 445));
        setSize(new java.awt.Dimension(550, 440));
        getContentPane().setLayout(null);

        tabelproduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelproduk.setSelectionForeground(new java.awt.Color(153, 255, 153));
        tabelproduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelprodukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelproduk);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 260, 452, 118);

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PRODUK APOTEK");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 10, 277, 32);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Kode Produk");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 70, 79, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nama Produk");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 110, 90, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Jenis Produk");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 150, 80, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Stok");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 190, 60, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Harga Produk");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 230, 90, 15);

        txtkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeActionPerformed(evt);
            }
        });
        getContentPane().add(txtkode);
        txtkode.setBounds(180, 60, 200, 30);
        getContentPane().add(txtnama);
        txtnama.setBounds(180, 100, 200, 30);
        getContentPane().add(txtjenis);
        txtjenis.setBounds(180, 140, 200, 30);
        getContentPane().add(txtstok);
        txtstok.setBounds(180, 180, 201, 30);
        getContentPane().add(txtharga);
        txtharga.setBounds(180, 220, 201, 30);

        btnkembali.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnkembali.setText("Kembali");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btnkembali);
        btnkembali.setBounds(400, 380, 90, 23);

        btnsimpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnsimpan);
        btnsimpan.setBounds(410, 80, 80, 23);

        btnedit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        getContentPane().add(btnedit);
        btnedit.setBounds(410, 160, 80, 23);

        btnhapus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus);
        btnhapus.setBounds(410, 200, 80, 23);

        btntambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        getContentPane().add(btntambah);
        btntambah.setBounds(410, 120, 80, 23);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Cetak");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(301, 380, 80, 23);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/background apotek.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 600, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM tabel_produk WHERE kode_produk='"+txtkode.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil..");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "INSERT INTO tabel_produk VALUES ('"+txtkode.getText()+"','"+txtnama.getText()+"','"+txtjenis.getText()+"','"+txtstok.getText()+"','"+txtharga.getText()+"')";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil..");
            tampilkan_data();
            kosongkan_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        kosongkan_form();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "UPDATE tabel_produk SET " +
                    "kode_produk='"+txtkode.getText()+"'," +
                    "nama_produk='"+txtnama.getText()+"'," +
                    "jenis_produk='"+txtjenis.getText()+"'," +
                    "stok='"+txtstok.getText()+"'," +
                    "harga_barang='"+txtharga.getText()+"' WHERE " +
                    "kode_produk = '"+txtkode.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil..");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_btneditActionPerformed

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        // TODO add your handling code here:
        new login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            InputStream is = produk.class.getResourceAsStream("/Laporan/apotek.jasper");
            JasperPrint jsPrint = JasperFillManager.fillReport(is, null, koneksi.configDB());
            JasperViewer.viewReport(jsPrint, false);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "gagal mencetak laporan karena :"
            + e.getMessage(), "cetak laporan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodeActionPerformed

    private void tabelprodukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelprodukMouseClicked
        // TODO add your handling code here:
        txtkode.setEditable(false);
        int baris = tabelproduk.rowAtPoint(evt.getPoint());
        
        String kode_produk = tabelproduk.getValueAt(baris, 0).toString();
        txtkode.setText(kode_produk);
        
        String nama_produk = tabelproduk.getValueAt(baris, 1).toString();
        txtnama.setText(nama_produk);
        
        String jenis_produk = tabelproduk.getValueAt(baris, 2).toString();
        txtjenis.setText(jenis_produk);
        
        String stok = tabelproduk.getValueAt(baris, 3).toString();
        txtstok.setText(stok);
        
        String harga_barang = tabelproduk.getValueAt(baris, 4).toString();
        txtharga.setText(harga_barang);
    }//GEN-LAST:event_tabelprodukMouseClicked

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
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkembali;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelproduk;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjenis;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}