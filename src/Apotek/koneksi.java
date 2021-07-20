/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apotek;
import java.sql.DriverManager;
/**
 *
 * @author ASUS
 */
public class koneksi {
    private static java.sql.Connection koneksi;
    
    public static java.sql.Connection configDB(){
        if (koneksi == null){
            try {
                String url = "jdbc:mysql://localhost:3306/projek_pbo";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Berhasil Terhubung");
            }catch (Exception e){
                System.out.println("Error");
            }
        }
        return koneksi;
    }
    public static void main(String[] args) {
        configDB();
    }
}
