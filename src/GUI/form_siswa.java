/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Richie
 */
public class form_siswa extends javax.swing.JFrame {
    private Connection con = null;
    private Statement stat = null;
    private PreparedStatement pst =null;
    private ResultSet res = null;
    private String sql = null;
    String username = UserSession.getU_username();
    public form_siswa() {
        initComponents();
        setTitle("Data Siswa - Aplikasi Data Siswa");
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        tabel();
        agamacombo();
        jurusancombo();
        kosongkan();
        Btninfolgt.setText("Hello," +username);
        jButton1.setBorderPainted(false);
    }
    private void kosongkan(){
        txtnis.setText(""); 
        txtnamasis.setText("");
        txtlahir.setText("");
        txttanggal.setText("");
        txtstatus.setText("");
        txtalamat.setText("");
        txtsiswatelp.setText("");
        txtasalsekolah.setText("");
        txtalamatsekolah.setText("");
        txtijazah.setText("");
        txtskhu.setText("");
        txttahunskhu.setText("");
        txtnamaay.setText("");
        txtnamaib.setText("");
        txtalamatorang.setText("");
        txttelporg.setText("");
        txtpekerjaanaya.setText("");
        txtpekerjaanibu.setText("");
        txtnamaw.setText("");
        txtalamatw.setText("");
        txtpekerjaanw.setText("");
        txttelpw.setText("");
    }
    private void tabel(){ 
        DefaultTableModel t= new DefaultTableModel();
         t.addColumn("NIS"); 
         t.addColumn("Nama Lengkap"); 
         t.addColumn("Tempat Lahir");
         t.addColumn("Tanggal Lahir");
         t.addColumn("Jenis Kelamin");
         t.addColumn("Agama");
         t.addColumn("Status Dalam Keluarga");
         t.addColumn("Alamat Siswa");
         t.addColumn("Telepon Siswa");
         t.addColumn("Jurusan");
         t.addColumn("Nama Asal Sekolah");
         t.addColumn("Alamat Asal Sekolah");
         t.addColumn("Nomor Ijazah");
         t.addColumn("Nomor SKHU");
         t.addColumn("Tahun SKHU");
         t.addColumn("Nama Ayah");
         t.addColumn("Nama Ibu");
         t.addColumn("Alamat Orangtua");
         t.addColumn("Telepon Orangtua");
         t.addColumn("Pekerjaan Ayah");
         t.addColumn("Pekerjaan Ibu");
         t.addColumn("Nama Wali");
         t.addColumn("Alamat Wali");
         t.addColumn("Pekerjaan Wali");
         t.addColumn("Telepon Wali");
         tbl.setModel(t); 
         try{ 
            res=stat.executeQuery("SELECT * FROM data_siswa"); 
            while (res.next()) { 
            t.addRow(new Object[]{ res.getString("nis"),
            res.getString("nama_lengkap"), 
            res.getString("tempat_lahir"), 
            res.getString("tanggal_lahir"),
            res.getString("jenis_kelamin"),
            res.getString("kode_agama"),
            res.getString("status_dalamkeluarga"),
            res.getString("alamat_pesertadidik"),
            res.getString("telepon_pesertadidik"),
            res.getString("kode_jurusan"),
            res.getString("namaasalsekolah"),
            res.getString("alamatasalsekolah"),
            res.getString("nomor_ijazah"),
            res.getString("nomor_skhu"),
            res.getString("tahun_skhu"),
            res.getString("nama_ayah"),
            res.getString("nama_ibu"),
            res.getString("alamat_orangtua"),
            res.getString("telepon_orangtua"),
            res.getString("pekerjaan_ayah"),
            res.getString("pekerjaan_ibu"),
            res.getString("nama_wali"),
            res.getString("alamat_wali"),
            res.getString("pekerjaan_wali"),
            res.getString("telepon_wali")
            }); 
            }
         }catch (Exception e) { 
         JOptionPane.showMessageDialog(rootPane, e); 
         }
        }
    private void agamacombo(){
      try{
          String sql="select * from agama";
          pst = con.prepareStatement(sql);
          res = pst.executeQuery();
          while(res.next()){
              cmbagama.addItem(res.getString("kode_agama"));
          }
      }catch (Exception e){
          JOptionPane.showMessageDialog(rootPane, e); 
      }  
    }
    private void jurusancombo(){
        try{
          String sql="select * from mata_pelajaran";
          pst = con.prepareStatement(sql);
          res = pst.executeQuery();
          while(res.next()){
              cmbjurusan.addItem(res.getString("kode_matapelajaran"));
          }
      }catch (Exception e){
          JOptionPane.showMessageDialog(rootPane, e); 
      }  
    }
    private void hapus(){
        try { 
            String sql="DELETE FROM data_siswa WHERE "+"nis='"+txtnis.getText()+"'" ;
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil");  
            this.setVisible(true);
            setVisible(true);
        }catch (Exception e) { 
            JOptionPane.showMessageDialog(this, "pesan salah : "+e);
        }
            kosongkan();
            tabel();
    }
    private void tambah(){
        try {
            stat.executeUpdate("INSERT INTO `data_siswa`(`nis`, `nama_lengkap`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`, `kode_agama`, `status_dalamkeluarga`, `alamat_pesertadidik`, `telepon_pesertadidik`, `kode_jurusan`, `namaasalsekolah`, `alamatasalsekolah`, `nomor_ijazah`, `nomor_skhu`, `tahun_skhu`, `nama_ayah`, `nama_ibu`, `alamat_orangtua`, `telepon_orangtua`, `pekerjaan_ayah`, `pekerjaan_ibu`, `nama_wali`, `alamat_wali`, `pekerjaan_wali`, `telepon_wali`) VALUES (" 
            + "'" + txtnis.getText() +"',"
            + "'" + txtnamasis.getText() +"',"
            + "'" + txtlahir.getText() +"',"
            + "'" + txttanggal.getText() +"',"
            + "'" + cmbkelamin.getSelectedItem() +"',"
            + "'" + (String) cmbagama.getSelectedItem() +"',"
            + "'" + txtstatus.getText() +"',"
            + "'" + txtalamat.getText() +"',"
            + "'" + txtsiswatelp.getText() +"',"
            + "'" + (String) cmbjurusan.getSelectedItem() +"',"
            + "'" + txtasalsekolah.getText() +"',"
            + "'" + txtalamatsekolah.getText() +"',"
            + "'" + txtijazah.getText() +"',"
            + "'" + txtskhu.getText() +"',"
            + "'" + txttahunskhu.getText() +"',"
            + "'" + txtnamaay.getText() +"',"
            + "'" + txtnamaib.getText() +"',"
            + "'" + txtalamatorang.getText() +"',"
            + "'" + txttelporg.getText() +"',"
            + "'" + txtpekerjaanaya.getText() +"',"
            + "'" + txtpekerjaanibu.getText() +"',"
            + "'" + txtnamaw.getText() +"',"
            + "'" + txtalamatw.getText() +"',"
            + "'" + txtpekerjaanw.getText() +"',"
            + "'" + txttelpw.getText() +"')");
            kosongkan(); 
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data"); 
        }
        catch (SQLException | HeadlessException e) { 
            JOptionPane.showMessageDialog(null, "Perintah Salah : "+e);
        }finally{
         tabel();
         kosongkan();
         } 
    }
    private void edit(){
        try {
            stat.executeUpdate("UPDATE data_siswa SET "
                + "nis='"+ txtnis.getText() +"',"
                + "nama_lengkap='"+ txtnamasis.getText() +"',"
                + "tempat_lahir='"+ txtlahir.getText() +"',"
                + "tanggal_lahir='"+ txttanggal.getText() +"',"
                + "jenis_kelamin='"+ cmbkelamin.getSelectedItem() +"',"
                + "kode_agama='"+ (String) cmbagama.getSelectedItem() +"',"
                + "status_dalamkeluarga='"+ txtstatus.getText() +"',"
                + "alamat_pesertadidik='"+ txtalamat.getText() +"',"
                + "telepon_pesertadidik='"+ txtsiswatelp.getText() +"',"
                + "kode_jurusan='"+ (String) cmbjurusan.getSelectedItem() +"',"
                + "namaasalsekolah='"+ txtasalsekolah.getText() +"',"
                + "alamatasalsekolah='"+ txtalamatsekolah.getText() +"',"
                + "nomor_ijazah='"+ txtijazah.getText() +"',"
                + "nomor_skhu='"+ txtskhu.getText() +"',"
                + "tahun_skhu='"+ txttahunskhu.getText() +"',"
                + "nama_ayah='"+ txtnamaay.getText() +"',"
                + "nama_ibu='"+ txtnamaib.getText() +"',"
                + "alamat_orangtua='"+ txtalamatorang.getText() +"',"
                + "telepon_orangtua='"+ txttelporg.getText() +"',"
                + "pekerjaan_ayah='"+ txtpekerjaanaya.getText() +"',"
                + "pekerjaan_ibu='"+ txtpekerjaanibu.getText() +"',"
                + "nama_wali='"+ txtnamaw.getText() +"',"
                + "alamat_wali='"+ txtalamatw.getText() +"',"
                + "pekerjaan_wali='"+ txtpekerjaanw.getText() +"',"
                + "telepon_wali='"+ txttelpw.getText() +"'"
                        
                + " WHERE " + "nis='"+txtnis.getText()+"'");
            kosongkan(); 
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data"); 
        }
        catch (SQLException | HeadlessException e) { 
            JOptionPane.showMessageDialog(null, "Perintah Salah : "+e);
        }finally{
         tabel();
         kosongkan();
         } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Btninfolgt = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new RoundedPanel(10, 10, new Color(247,247,247));
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtnis = new javax.swing.JTextField();
        txtnamasis = new javax.swing.JTextField();
        txtlahir = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        cmbkelamin = new javax.swing.JComboBox<>();
        cmbagama = new javax.swing.JComboBox<>();
        txtstatus = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txtsiswatelp = new javax.swing.JTextField();
        cmbjurusan = new javax.swing.JComboBox<>();
        txtasalsekolah = new javax.swing.JTextField();
        txtalamatsekolah = new javax.swing.JTextField();
        txtijazah = new javax.swing.JTextField();
        txtskhu = new javax.swing.JTextField();
        txttahunskhu = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jPanel4 = new RoundedPanel(10,10, new Color(247,247,247));
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtnamaay = new javax.swing.JTextField();
        txtnamaib = new javax.swing.JTextField();
        txtalamatorang = new javax.swing.JTextField();
        txttelporg = new javax.swing.JTextField();
        txtpekerjaanaya = new javax.swing.JTextField();
        txtpekerjaanibu = new javax.swing.JTextField();
        jPanel7 = new RoundedPanel(10,10, new Color(247,247,247));
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtnamaw = new javax.swing.JTextField();
        txtalamatw = new javax.swing.JTextField();
        txtpekerjaanw = new javax.swing.JTextField();
        txttelpw = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jPanel8 = new RoundedPanel(10,10, new Color(247,247,247));
        jLabel23 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Logout");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 20, 80, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton1.setText("Kembali");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        Btninfolgt.setText("hello");
        Btninfolgt.setBorder(null);
        Btninfolgt.setBorderPainted(false);
        Btninfolgt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btninfolgt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtninfolgtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtninfolgtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1208, Short.MAX_VALUE)
                .addComponent(Btninfolgt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Btninfolgt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATA SISWA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1370, 80));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel5.setBackground(new java.awt.Color(247, 247, 247));

        jPanel6.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Nama Lengkap");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Tanggal Lahir");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("NIS");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Tempat Lahir");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Jenis Kelamin");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Agama");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("Status Dalam Keluarga");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Alamat");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setText("Nomor Telepon");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Jurusan");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("Nama Asal Sekolah");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setText("Alamat Asal Sekolah");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setText("Nomor Ijazah");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setText("Nomor SKHU");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setText("Tahun SKHU");

        cmbkelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L", "P" }));

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel30.setText("*L=Laki-Laki  P=Perempuan");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel32.setText("*");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnamasis)
                    .addComponent(txtlahir)
                    .addComponent(txtstatus)
                    .addComponent(cmbagama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtalamat)
                    .addComponent(txtsiswatelp)
                    .addComponent(txtasalsekolah)
                    .addComponent(cmbjurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtalamatsekolah)
                    .addComponent(txtijazah)
                    .addComponent(txtskhu)
                    .addComponent(txttahunskhu)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtnis, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cmbkelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txttanggal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnamasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtlahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbkelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbagama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtsiswatelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmbjurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtasalsekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtalamatsekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtijazah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtskhu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txttahunskhu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("SISWA");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("ORANG TUA");

        jPanel6.setOpaque(false);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setText("Nama Ayah");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setText("Nama Ibu");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setText("Alamat Orang Tua");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel24.setText("Telepon Orang Tua");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel25.setText("Pekerjaan Ayah");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel26.setText("Pekerjaan Ibu");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnamaay)
                            .addComponent(txtnamaib)
                            .addComponent(txtalamatorang)
                            .addComponent(txtpekerjaanibu, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttelporg, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtpekerjaanaya, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtnamaay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtnamaib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtalamatorang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txttelporg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtpekerjaanaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpekerjaanibu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel6.setOpaque(false);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel27.setText("Nama Wali");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel28.setText("Alamat Wali");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel29.setText("Pekerjaan Wali");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel31.setText("Telepon Wali");

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnedit.setText("Simpan");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnamaw)
                            .addComponent(txtalamatw)
                            .addComponent(txtpekerjaanw)
                            .addComponent(txttelpw)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtnamaw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtalamatw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtpekerjaanw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txttelpw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnclear)
                    .addComponent(btnhapus)
                    .addComponent(btnedit)
                    .addComponent(btntambah))
                .addGap(26, 26, 26))
        );

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("WALI");

        jPanel6.setOpaque(false);
        jPanel8.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel23.setText("**=Jika tidak ada wali isi dengan - untuk telepon isi dengan 0");
        jPanel8.add(jLabel23);
        jLabel23.setBounds(10, 40, 340, 16);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("KODE AGAMA");
        jPanel8.add(jLabel33);
        jLabel33.setBounds(10, 100, 340, 16);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel36.setText("<html>1=Kristen <br> 2=Muslim <br> 3=Katolik</html");
        jPanel8.add(jLabel36);
        jLabel36.setBounds(10, 100, 320, 130);

        jLabel37.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("KODE JURUSAN");
        jPanel8.add(jLabel37);
        jLabel37.setBounds(10, 250, 340, 16);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel38.setText("<html>1=RPL 1 <br> 2=RPL 2</html");
        jPanel8.add(jLabel38);
        jLabel38.setBounds(10, 250, 320, 90);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel39.setText("* = Untuk penulisan tanggal lahir : DDMMYY");
        jPanel8.add(jLabel39);
        jLabel39.setBounds(10, 11, 239, 16);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("INFO");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel40.setText("**");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel18)
                .addGap(382, 382, 382)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(275, 275, 275))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        jScrollPane3.setViewportView(jPanel5);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1320, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1382, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setBackground(new java.awt.Color(220,220,220));
        panel3.setSize(80,20);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setBackground(new java.awt.Color(0,0,0));
        panel3.setSize(0,0);
    }//GEN-LAST:event_jLabel1MouseExited

    private void BtninfolgtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtninfolgtMouseEntered
       Btninfolgt.setBackground(Color.CYAN);
        panel3.setSize(80,20);
    }//GEN-LAST:event_BtninfolgtMouseEntered

    private void BtninfolgtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtninfolgtMouseExited
        Btninfolgt.setBackground(new java.awt.Color(255,255,255));
        panel3.setSize(0,0);
    }//GEN-LAST:event_BtninfolgtMouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        new MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        tambah();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        edit();
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        hapus();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        kosongkan();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
         try { 
            res=stat.executeQuery("select * from data_siswa where "+ "nis='" +txtnis.getText()
            +"'" );
            while (res.next()) 
            {
                txtnis.setText(res.getString("nis")); 
                txtnamasis.setText(res.getString("nama_lengkap"));
                txtlahir.setText(res.getString("tempat_lahir"));
                txttanggal.setText(res.getString("tanggal_lahir"));
                cmbkelamin.setSelectedItem(res.getString("jenis_kelamin"));
                cmbagama.setSelectedItem(res.getString("kode_agama"));
                txtstatus.setText(res.getString("status_dalamkeluarga"));
                txtalamat.setText(res.getString("alamat_pesertadidik"));
                txtsiswatelp.setText(res.getString("telepon_pesertadidik"));
                cmbjurusan.setSelectedItem(res.getString("kode_jurusan"));
                txtasalsekolah.setText(res.getString("namaasalsekolah"));
                txtalamatsekolah.setText(res.getString("alamatasalsekolah"));
                txtijazah.setText(res.getString("nomor_ijazah"));
                txtskhu.setText(res.getString("nomor_skhu"));
                txttahunskhu.setText(res.getString("tahun_skhu"));
                txtnamaay.setText(res.getString("nama_ayah"));
                txtnamaib.setText(res.getString("nama_ibu"));
                txtalamatorang.setText(res.getString("alamat_orangtua"));
                txttelporg.setText(res.getString("telepon_orangtua"));
                txtpekerjaanaya.setText(res.getString("pekerjaan_ayah"));
                txtpekerjaanibu.setText(res.getString("pekerjaan_ibu"));
                txtnamaw.setText(res.getString("nama_wali"));
                txtalamatw.setText(res.getString("alamat_wali"));
                txtpekerjaanw.setText(res.getString("pekerjaan_wali"));
                txttelpw.setText(res.getString("telepon_wali"));
            }                                        
        }       
        catch (Exception e) { 
            JOptionPane.showMessageDialog(rootPane, e); 
        }
    }//GEN-LAST:event_btncariActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        int row = tbl.getSelectedRow();
        String nis=tbl.getValueAt(row,0).toString();
        String namanis =tbl.getValueAt(row,1).toString();
        String lahir =tbl.getValueAt(row,2).toString();
        String tanggal =tbl.getValueAt(row,3).toString();
        String kelamin =tbl.getValueAt(row,4).toString();
        String agama =tbl.getValueAt(row,5).toString();
        String status =tbl.getValueAt(row,6).toString();
        String alamat =tbl.getValueAt(row,7).toString();
        String siswatelp =tbl.getValueAt(row,8).toString();
        String jurusan =tbl.getValueAt(row,9).toString();
        String asalsekolah =tbl.getValueAt(row,10).toString();
        String alamatsekolah =tbl.getValueAt(row,11).toString();
        String ijazah =tbl.getValueAt(row,12).toString();
        String skhu =tbl.getValueAt(row,13).toString();
        String tahunskhu =tbl.getValueAt(row,14).toString();
        String namaay =tbl.getValueAt(row,15).toString();
        String namaib =tbl.getValueAt(row,16).toString();
        String alamatorang =tbl.getValueAt(row,17).toString();
        String telporg =tbl.getValueAt(row,18).toString();
        String pekerjaanaya =tbl.getValueAt(row,19).toString();
        String pekerjaanibu =tbl.getValueAt(row,20).toString();
        String namaw =tbl.getValueAt(row,21).toString();
        String alamatw =tbl.getValueAt(row,22).toString();
        String pekerjaanw =tbl.getValueAt(row,23).toString();
        String telpw =tbl.getValueAt(row,24).toString();
        txtnis.setText(nis); 
        txtnamasis.setText(namanis);
        txtlahir.setText(lahir);
        txttanggal.setText(tanggal);
        cmbkelamin.setSelectedItem(kelamin);
        cmbagama.setSelectedItem(agama);
        txtstatus.setText(status);
        txtalamat.setText(alamat);
        txtsiswatelp.setText(siswatelp);
        cmbjurusan.setSelectedItem(jurusan);
        txtasalsekolah.setText(asalsekolah);
        txtalamatsekolah.setText(alamatsekolah);
        txtijazah.setText(ijazah);
        txtskhu.setText(skhu);
        txttahunskhu.setText(tahunskhu);
        txtnamaay.setText(namaay);
        txtnamaib.setText(namaib);
        txtalamatorang.setText(alamatorang);
        txttelporg.setText(telporg);
        txtpekerjaanaya.setText(pekerjaanaya);
        txtpekerjaanibu.setText(pekerjaanibu);
        txtnamaw.setText(namaw);
        txtalamatw.setText(alamatw);
        txtpekerjaanw.setText(pekerjaanw);
        txttelpw.setText(telpw);
    }//GEN-LAST:event_tblMouseClicked
            
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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btninfolgt;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cmbagama;
    private javax.swing.JComboBox<String> cmbjurusan;
    private javax.swing.JComboBox<String> cmbkelamin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel3;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtalamatorang;
    private javax.swing.JTextField txtalamatsekolah;
    private javax.swing.JTextField txtalamatw;
    private javax.swing.JTextField txtasalsekolah;
    private javax.swing.JTextField txtijazah;
    private javax.swing.JTextField txtlahir;
    private javax.swing.JTextField txtnamaay;
    private javax.swing.JTextField txtnamaib;
    private javax.swing.JTextField txtnamasis;
    private javax.swing.JTextField txtnamaw;
    private javax.swing.JTextField txtnis;
    private javax.swing.JTextField txtpekerjaanaya;
    private javax.swing.JTextField txtpekerjaanibu;
    private javax.swing.JTextField txtpekerjaanw;
    private javax.swing.JTextField txtsiswatelp;
    private javax.swing.JTextField txtskhu;
    private javax.swing.JTextField txtstatus;
    private javax.swing.JTextField txttahunskhu;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txttelporg;
    private javax.swing.JTextField txttelpw;
    // End of variables declaration//GEN-END:variables
class RoundedPanel extends JPanel
    {
        private static final long serialVersionUID = 1L;
        private Color backgroundColor;
        private int cornerRadius = 15;
        public int pixels;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, int pix, Color bgColor) {
            super();
            cornerRadius = radius;
            this.pixels = pix;
            Border border = BorderFactory.createEmptyBorder(pixels, pixels, pixels, pixels);
            this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), border));
            this.setLayout(new BorderLayout());
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            int shade = 0;
            int topOpacity = 80;
            for (int i = 0; i < pixels; i++) {
                g.setColor(new Color(shade, shade, shade, ((topOpacity / pixels) * i)));
                g.drawRect(i, i, this.getWidth() - ((i * 2) + 1), this.getHeight() - ((i * 2) + 1));
            }
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }
}
