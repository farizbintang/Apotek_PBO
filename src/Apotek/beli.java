/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apotek;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Apotek.produk;

/**
 *
 * @author ASUS
 */
public class beli extends javax.swing.JFrame {

    private void kosongkan_form() {
        txtbeli.setEditable(true);
        txtbeli.setText(null);
        txtkode.setText(null);
        cbproduk.setSelectedItem(null);
        txtharga.setText(null);
        txtjml.setText(null);
        txttotal.setText(null);
    }

    private void tampilkan_data() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Beli");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Kode Produk");
        model.addColumn("Jumlah Produk");
        model.addColumn("Total Harga");

        try {

            String sql = "SELECT * FROM tabel_beli";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
            }
            tabelbeli.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    private void tampilcombo() {
        try {
            String sql = "SELECT * FROM tabel_produk";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                cbproduk.addItem(res.getString("kode_produk"));

            }
            res.last();
            int jumlahdata = res.getRow();
            res.first();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    /**
     * Creates new form beli
     */
    public beli() {
        initComponents();
        tampilkan_data();
        kosongkan_form();
        tampilcombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbeli = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        txtjml = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnkembali = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtbeli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        cbproduk = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(550, 600));
        setMinimumSize(new java.awt.Dimension(550, 600));
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(51, 204, 255));
        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA BELI APOTEK");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-60, 10, 650, 32);

        tabelbeli.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelbeli.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelbeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbeliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbeli);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 360, 452, 130);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Kode Pelanggan");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 120, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Kode Produk");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 150, 80, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Jumlah Produk");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 230, 110, 15);

        txtkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeActionPerformed(evt);
            }
        });
        getContentPane().add(txtkode);
        txtkode.setBounds(200, 100, 230, 30);

        txtjml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlActionPerformed(evt);
            }
        });
        getContentPane().add(txtjml);
        txtjml.setBounds(200, 220, 227, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Harga Barang");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 190, 100, 15);

        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });
        getContentPane().add(txtharga);
        txtharga.setBounds(200, 180, 227, 30);

        btnsimpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnsimpan);
        btnsimpan.setBounds(40, 310, 80, 23);

        btnedit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        getContentPane().add(btnedit);
        btnedit.setBounds(220, 310, 57, 23);

        btntambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        getContentPane().add(btntambah);
        btntambah.setBounds(130, 310, 80, 23);

        btnhapus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus);
        btnhapus.setBounds(290, 310, 80, 23);

        btnkembali.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnkembali.setText("Kembali");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btnkembali);
        btnkembali.setBounds(409, 500, 80, 23);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(722, 20, 626, 21);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Kode Beli");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 70, 100, 15);

        txtbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbeliActionPerformed(evt);
            }
        });
        getContentPane().add(txtbeli);
        txtbeli.setBounds(200, 60, 230, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total Harga");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 270, 110, 15);

        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        getContentPane().add(txttotal);
        txttotal.setBounds(200, 260, 227, 30);

        cbproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbprodukActionPerformed(evt);
            }
        });
        getContentPane().add(cbproduk);
        cbproduk.setBounds(200, 150, 90, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Harga");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(380, 310, 69, 23);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/two-colored-medicine-capsules-row.jpg"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(-130, 0, 667, 1000);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodeActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        kosongkan_form();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        // TODO add your handling code here:
        new login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO tabel_beli VALUES ('" + txtbeli.getText() + "','" + txtkode.getText() + "','" + cbproduk.getSelectedItem() + "','" + txtjml.getText() + "','" + txttotal.getText() + "')";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil..");
            tampilkan_data();
            kosongkan_form();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM tabel_beli WHERE kode_beli='" + txtbeli.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil..");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE tabel_beli SET "
                    + "kode_beli='" + txtbeli.getText() + "',"
                    + "kode_pelanggan='" + txtkode.getText() + "',"
                    + "kode_produk='" + cbproduk.getSelectedItem() + "',"
                    + "jumlah_produk='" + txtjml.getText() + "',"
                    + "total_harga='" + txttotal.getText() + "' WHERE "
                    + "kode_beli = '" + txtbeli.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil..");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_btneditActionPerformed

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM tabel_produk WHERE " +
                    "kode_produk = '" + cbproduk.getSelectedItem() + "";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                        txtharga.setText(res.getString("harga_barang"));
            }

        }
        catch (SQLException e) {
        }
    }//GEN-LAST:event_txthargaActionPerformed

    private void tabelbeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbeliMouseClicked
        // TODO add your handling code here:
        txtbeli.setEditable(false);
        int baris = tabelbeli.rowAtPoint(evt.getPoint());
        String kode_beli = tabelbeli.getValueAt(baris, 0).toString();
        txtbeli.setText(kode_beli);

        String kode_pelanggan = tabelbeli.getValueAt(baris, 1).toString();
        txtkode.setText(kode_pelanggan);

        String kode_produk = tabelbeli.getValueAt(baris, 2).toString();
        cbproduk.setSelectedItem(kode_produk);

        String jumlah_produk = tabelbeli.getValueAt(baris, 3).toString();
        txtjml.setText(jumlah_produk);

        String total_harga = tabelbeli.getValueAt(baris, 4).toString();
        txttotal.setText(total_harga);
    }//GEN-LAST:event_tabelbeliMouseClicked

    private void txtbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbeliActionPerformed

    private void txtjmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txttotalActionPerformed

    private void cbprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbprodukActionPerformed

        try {
            String sql = "SELECT * FROM tabel_produk WHERE " +
                    "kode_produk = '" + cbproduk.getSelectedItem() + "'";
            java.sql.Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                txtharga.setText(res.getString("harga_barang"));
            }

        }
        catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }//GEN-LAST:event_cbprodukActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int harga_barang = Integer.parseInt(txtharga.getText());
        int jumlah_produk = Integer.parseInt(txtjml.getText());
        
        int harga =  harga_barang * jumlah_produk;
        String hrg = Integer.toString(harga);
        txttotal.setText(hrg);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new beli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkembali;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cbproduk;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelbeli;
    private javax.swing.JTextField txtbeli;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjml;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

}
