/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.Color;

/**
 *
 * @author Richie
 */
public class MenuUtama extends javax.swing.JFrame {
    String username = UserSession.getU_username();
    public MenuUtama() {
        initComponents();
        setTitle("Aplikasi Data Siswa");
        Btninfolgt.setText("Hello," +username);
        jButton1.setBorderPainted(false);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        txttmbhuser = new javax.swing.JLabel();
        txtwali = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Btninfolgt = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        panel_siswa = new javax.swing.JPanel();
        siswa = new javax.swing.JLabel();
        txtsiswa = new javax.swing.JLabel();
        panel_matpel = new javax.swing.JPanel();
        pelajaran = new javax.swing.JLabel();
        txtpelajaran = new javax.swing.JLabel();
        panel_jurusan = new javax.swing.JPanel();
        jurusan = new javax.swing.JLabel();
        txtjurusan = new javax.swing.JLabel();
        panel_guru = new javax.swing.JPanel();
        guru = new javax.swing.JLabel();
        txtguru = new javax.swing.JLabel();
        panel_kelas = new javax.swing.JPanel();
        kelas = new javax.swing.JLabel();
        txtkelas = new javax.swing.JLabel();
        panel_agama = new javax.swing.JPanel();
        agama = new javax.swing.JLabel();
        txtagama = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelMouseExited(evt);
            }
        });

        txttmbhuser.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txttmbhuser.setText("Tambah User");
        txttmbhuser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txttmbhuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttmbhuserMouseClicked(evt);
            }
        });

        txtwali.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtwali.setText("Tambah Wali Kelas");
        txtwali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtwali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtwaliMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txttmbhuser, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtwali, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(txttmbhuser)
                .addGap(4, 4, 4)
                .addComponent(txtwali))
        );

        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, 130, 0));

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

        jPanel1.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 80, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton1.setText("File");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 628, Short.MAX_VALUE)
                .addComponent(Btninfolgt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Btninfolgt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("APLIKASI DATA SISWA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 770, 80));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 4));

        panel_siswa.setBackground(new java.awt.Color(255, 255, 255));
        panel_siswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_siswaMouseClicked(evt);
            }
        });
        panel_siswa.setLayout(null);

        siswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/670874-200.png"))); // NOI18N
        panel_siswa.add(siswa);
        siswa.setBounds(0, 0, 94, 100);

        txtsiswa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsiswa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtsiswa.setText("Data Siswa");
        panel_siswa.add(txtsiswa);
        txtsiswa.setBounds(0, 106, 94, 15);

        panel_matpel.setBackground(new java.awt.Color(255, 255, 255));
        panel_matpel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_matpel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_matpelMouseClicked(evt);
            }
        });
        panel_matpel.setLayout(null);

        pelajaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/1014107-200.png"))); // NOI18N
        panel_matpel.add(pelajaran);
        pelajaran.setBounds(0, 0, 100, 100);

        txtpelajaran.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtpelajaran.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpelajaran.setText("Mata Pelajaran");
        panel_matpel.add(txtpelajaran);
        txtpelajaran.setBounds(0, 110, 100, 15);

        panel_jurusan.setBackground(new java.awt.Color(255, 255, 255));
        panel_jurusan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_jurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_jurusanMouseClicked(evt);
            }
        });
        panel_jurusan.setLayout(null);

        jurusan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/2323297-200.png"))); // NOI18N
        jurusan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_jurusan.add(jurusan);
        jurusan.setBounds(0, 0, 100, 100);

        txtjurusan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtjurusan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtjurusan.setText("Jurusan");
        txtjurusan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_jurusan.add(txtjurusan);
        txtjurusan.setBounds(0, 110, 100, 20);

        panel_guru.setBackground(new java.awt.Color(255, 255, 255));
        panel_guru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_guru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_guruMouseClicked(evt);
            }
        });
        panel_guru.setLayout(null);

        guru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/2588973-200.png"))); // NOI18N
        panel_guru.add(guru);
        guru.setBounds(0, 0, 100, 100);

        txtguru.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtguru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtguru.setText("Guru");
        panel_guru.add(txtguru);
        txtguru.setBounds(0, 106, 100, 15);

        panel_kelas.setBackground(new java.awt.Color(255, 255, 255));
        panel_kelas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_kelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_kelasMouseClicked(evt);
            }
        });
        panel_kelas.setLayout(null);

        kelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/2509734-200.png"))); // NOI18N
        panel_kelas.add(kelas);
        kelas.setBounds(0, 0, 100, 100);

        txtkelas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtkelas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtkelas.setText("Kelas");
        panel_kelas.add(txtkelas);
        txtkelas.setBounds(0, 106, 100, 15);

        panel_agama.setBackground(new java.awt.Color(255, 255, 255));
        panel_agama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_agama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_agamaMouseClicked(evt);
            }
        });
        panel_agama.setLayout(null);

        agama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/1307794-200.png"))); // NOI18N
        agama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_agama.add(agama);
        agama.setBounds(0, 0, 100, 100);

        txtagama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtagama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtagama.setText("Agama");
        txtagama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_agama.add(txtagama);
        txtagama.setBounds(0, 100, 100, 20);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_guru, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_matpel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_agama, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_matpel, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(panel_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_jurusan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_guru, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(panel_agama, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 650, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(786, 540));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseExited
        panel.setSize(0,0);
    }//GEN-LAST:event_panelMouseExited

    private void panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseEntered
        panel.setSize(130,42);
    }//GEN-LAST:event_panelMouseEntered

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(Color.CYAN);
        panel.setSize(130,42);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(new java.awt.Color(255,255,255));
        
    }//GEN-LAST:event_jButton1MouseExited

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
        Btninfolgt.setBackground(new Color(255,255,255));
        panel3.setSize(0,0);
    }//GEN-LAST:event_BtninfolgtMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txttmbhuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttmbhuserMouseClicked
        new tambah_user().setVisible(true);
        dispose();
    }//GEN-LAST:event_txttmbhuserMouseClicked

    private void panel_agamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_agamaMouseClicked
        new form_agama().setVisible(true);
        dispose();
    }//GEN-LAST:event_panel_agamaMouseClicked

    private void panel_jurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_jurusanMouseClicked
        new form_jurusan().setVisible(true);
        dispose();
    }//GEN-LAST:event_panel_jurusanMouseClicked

    private void panel_matpelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_matpelMouseClicked
        new form_matpel().setVisible(true);
        dispose();
    }//GEN-LAST:event_panel_matpelMouseClicked

    private void panel_kelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_kelasMouseClicked
        new form_kelas().setVisible(true);
        dispose();
    }//GEN-LAST:event_panel_kelasMouseClicked

    private void panel_guruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_guruMouseClicked
        new form_guru().setVisible(true);
        dispose();
    }//GEN-LAST:event_panel_guruMouseClicked

    private void txtwaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtwaliMouseClicked
        new form_walikelas().setVisible(true);
        dispose();
    }//GEN-LAST:event_txtwaliMouseClicked

    private void panel_siswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_siswaMouseClicked
        new form_siswa().setVisible(true);
        dispose();
    }//GEN-LAST:event_panel_siswaMouseClicked

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
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btninfolgt;
    private javax.swing.JLabel agama;
    private javax.swing.JLabel guru;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jurusan;
    private javax.swing.JLabel kelas;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel_agama;
    private javax.swing.JPanel panel_guru;
    private javax.swing.JPanel panel_jurusan;
    private javax.swing.JPanel panel_kelas;
    private javax.swing.JPanel panel_matpel;
    private javax.swing.JPanel panel_siswa;
    private javax.swing.JLabel pelajaran;
    private javax.swing.JLabel siswa;
    private javax.swing.JLabel txtagama;
    private javax.swing.JLabel txtguru;
    private javax.swing.JLabel txtjurusan;
    private javax.swing.JLabel txtkelas;
    private javax.swing.JLabel txtpelajaran;
    private javax.swing.JLabel txtsiswa;
    private javax.swing.JLabel txttmbhuser;
    private javax.swing.JLabel txtwali;
    // End of variables declaration//GEN-END:variables
}
