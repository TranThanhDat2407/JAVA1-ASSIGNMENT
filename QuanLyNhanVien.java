/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MOB1023_ASM;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.text.Collator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANHDAT
 */
public class QuanLyNhanVien extends javax.swing.JFrame {

    private DefaultTableModel tblModel = new DefaultTableModel();
    
    List<NhanVien> list = new ArrayList<>();

    private int index = -1;
    private Timer searchTimer;
    private final int SEARCH_DELAY = 500;
    
    public QuanLyNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        initTable();
//        initValueTable();
        fillTable();
    }

    public void initTable() {
        String[] cols = new String[]{"Mã", "HỌ VÀ TÊN", "TUỔI", "EMAIL", "LƯƠNG"};
        tblModel.setColumnIdentifiers(cols);
        tblNhanVien.setModel(tblModel);

        tblNhanVien.getTableHeader().addMouseListener(new MouseAdapter() {
            boolean tangDan = true;

            @Override
            public void mouseClicked(MouseEvent e) {
                int columnIndex = tblNhanVien.columnAtPoint(e.getPoint());
                if (columnIndex == 4) {
                    sortTableBySalary(tangDan);
                    tangDan = !tangDan;
                } else if (columnIndex == 1) {
                    orderByName(tangDan);
                    tangDan = !tangDan;
                } else if (columnIndex == 2) {
                    sortTableByAge(tangDan);
                    tangDan = !tangDan;
                }else if (columnIndex == 0) {
                    orderByID(tangDan);
                    tangDan = !tangDan;
                }
            }
        });

    }

    public void fillTable() {
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }

        for (NhanVien nv : list) {
            Object[] row = new Object[]{nv.getMaNV(), nv.getTenNV(), nv.getTuoi(), nv.getEmail(), nv.getLuong()};
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }

    public void initValueTable() {
        list.add(new NhanVien("NV001", "Nguyễn Tấn Duy", 22, "duynguyen@edu.com", 12000));
        list.add(new NhanVien("NV002", "Đỗ Đức Minh", 22, "ducminh@gmail.com", 1800));
        list.add(new NhanVien("NV003", "Trần Thành Đạt", 22, "thanhdat@fpt.edu.vn", 127700));
    }

    public String getCurrentRecord() {
        return "Record: " + (this.index + 1) + " of " + list.size();
    }

    public boolean validateFrom() {
        if (txtMaNV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã nhân viên");
            return false;
        }
        if (txtTuoi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tuổi nhân viên");
            return false;
        }
        try {
            int tuoi = Integer.parseInt(txtTuoi.getText());
            if (tuoi <= 16 || tuoi >= 55) {
                JOptionPane.showMessageDialog(this, "Tuổi không hợp lệ phải từ 16 - 55");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tuổi chưa đúng định dạng");
            return false;
        }

        if (!txtMaNV.getText().matches("NV\\d+")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên phải bắt đầu từ NV và các số");
            return false;
        }
        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập Email nhân viên");
            return false;
        }
        if (!txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtTenNV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên nhân viên");
            return false;
        }
        if (!txtTenNV.getText().matches("^[^0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$")) {
            JOptionPane.showMessageDialog(this, "Tên không được chứa số hoặc ký tự đặc biệt!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập lương nhân viên");
            return false;
        }
        try {
            double luong = Double.parseDouble(txtLuong.getText());
            if (luong <= 5000000) {
                JOptionPane.showMessageDialog(this, "Lương không hợp lệ phải 5000000 trở lên");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lương chưa đúng định dạng");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        lblRecord = new javax.swing.JLabel();
        lblClock = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Quản Lý Nhân Viên");

        jLabel2.setText("MÃ NHÂN VIÊN");

        jLabel3.setText("HỌ VÀ TÊN");

        jLabel4.setText("TUỔI");

        jLabel5.setText("EMAIL");

        jLabel6.setText("LƯƠNG");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Actions-view-refresh-icon.png"))); // NOI18N
        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Actions-document-edit-icon.png"))); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Action-cancel-icon.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-find-30.png"))); // NOI18N
        btnFind.setText("FIND");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-folder-30.png"))); // NOI18N
        btnOpen.setText("OPEN");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-logout-32.png"))); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOpen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        lblRecord.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 0, 0));
        lblRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecord.setText("Record:  1 of 10");

        lblClock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblClock.setForeground(new java.awt.Color(255, 0, 0));
        lblClock.setText("00:00 AM");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel7.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTuoi))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenNV))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNV))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLuong)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnFirst)
                                        .addGap(33, 33, 33)
                                        .addComponent(btnPrev)
                                        .addGap(44, 44, 44)
                                        .addComponent(btnNext)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnLast)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblRecord)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClock)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFirst)
                            .addComponent(btnPrev)
                            .addComponent(btnNext)
                            .addComponent(btnLast)
                            .addComponent(lblRecord))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblClock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        index--;
        if (index < 0) {
            index = list.size() - 1;
        }
        tblNhanVien.setRowSelectionInterval(index, index);
        fillInfoToForm(index);
        lblRecord.setText(this.getCurrentRecord());
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        index = list.size() - 1;
        tblNhanVien.setRowSelectionInterval(index, index);
        fillInfoToForm(index);
        lblRecord.setText(this.getCurrentRecord());
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        index++;
        if (index > list.size() - 1) {
            index = 0;
        }

        tblNhanVien.setRowSelectionInterval(index, index);
        fillInfoToForm(index);
        lblRecord.setText(this.getCurrentRecord());
    }//GEN-LAST:event_btnNextActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        index = tblNhanVien.getSelectedRow();
        fillInfoToForm(index);
        lblRecord.setText(getCurrentRecord());
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lblRecord.setText(this.getCurrentRecord());
        clockThread clockThread = new clockThread(lblClock);
        Thread t1 = new Thread(clockThread);
        t1.start();
    }//GEN-LAST:event_formWindowOpened

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        index = 0;
        tblNhanVien.setRowSelectionInterval(index, index);
        fillInfoToForm(index);
        lblRecord.setText(this.getCurrentRecord());
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn muốn lưu không?", "Xác nhận lưu", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            write();
            System.exit(0);
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if (find(txtMaNV.getText()) == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhận viên!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        fillInfoToForm(find(txtMaNV.getText()));
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        read();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        addKeyListenerToTxtSearch();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNhanVien().setVisible(true);
            }
        });
    }

    public void clear() {
        txtMaNV.setText(null);
        txtTenNV.setText(null);
        txtTuoi.setText(null);
        txtEmail.setText(null);
        txtLuong.setText(null);
        index = -1;
    }

    public void fillInfoToForm(int index) {
        NhanVien currentNV = list.get(index);

        this.txtMaNV.setText(currentNV.getMaNV());
        this.txtTenNV.setText(currentNV.getTenNV());
        this.txtTuoi.setText(String.valueOf(currentNV.getTuoi()));
        this.txtEmail.setText(currentNV.getEmail());
        this.txtLuong.setText(String.valueOf(currentNV.getLuong()));
    }

    public void save() {
        if (validateFrom()) {
            NhanVien nv = new NhanVien(txtMaNV.getText(), txtTenNV.getText(),
                    Integer.parseInt(txtTuoi.getText()), txtEmail.getText(), Double.parseDouble(txtLuong.getText()));
            NhanVien nvFinded = find(nv.getMaNV());
            if (index == -1 || nvFinded == null) {
                list.add(nv);
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!", "Successfuly", JOptionPane.INFORMATION_MESSAGE);
            } else {
                update(nv);
            }
        }
        fillTable();
        clear();
        index = -1;
    }

    public void write() {
        try {
            String filePath = "NhanVien.dat";
            XFile.writeObject(filePath, list);
            JOptionPane.showMessageDialog(this, "Lưu dữ liệu vào file thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lưu dữ liệu vào file thất bại!");
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            list = (List<NhanVien>) XFile.readObject("NhanVien.dat");
            fillTable();
            JOptionPane.showMessageDialog(this, "Đọc thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đọc thất bại");
            e.getMessage();
        }
    }

    public void update(NhanVien nv) {
        if (validateFrom()) {
            NhanVien nvFinded = find(nv.getMaNV());

            if (nvFinded != null) {
                tblModel.setValueAt(txtTenNV.getText(), index, 1);
                tblModel.setValueAt(txtTuoi.getText(), index, 2);
                tblModel.setValueAt(txtEmail.getText(), index, 3);
                tblModel.setValueAt(txtLuong.getText(), index, 4);

                nvFinded.setTenNV(txtTenNV.getText());
                nvFinded.setTuoi(Integer.parseInt(txtTuoi.getText()));
                nvFinded.setEmail(txtEmail.getText());
                nvFinded.setLuong(Double.parseDouble(txtLuong.getText()));
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "Successfully", JOptionPane.INFORMATION_MESSAGE);

                return;
            }

            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên phù hợp!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public NhanVien find(String MaNV) {
        for (NhanVien nv : list) {
            if (MaNV.equalsIgnoreCase(nv.getMaNV())) {
                return nv;
            }
        }
        return null;
    }

    public void delete() {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần xóa!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sinh viên này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            list.remove(index);
            fillTable();
            JOptionPane.showMessageDialog(this, "Đã xóa thành công!", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            clear();
        }
    }

    public void fillInfoToForm(NhanVien nv) {
        this.txtMaNV.setText(nv.getMaNV());
        this.txtTenNV.setText(nv.getTenNV());
        this.txtTuoi.setText(String.valueOf(nv.getTuoi()));
        this.txtEmail.setText(nv.getEmail());
        this.txtLuong.setText(String.valueOf(nv.getLuong()));
    }

    public void sortTableBySalary(boolean tangDan) {
        list.sort(Comparator.comparingDouble(NhanVien::getLuong));

        if (!tangDan) {
            Collections.reverse(list);
        }

        fillTable();
    }

    public void sortTableByAge(boolean tangDan) {
        list.sort(Comparator.comparingInt(NhanVien::getTuoi));

        if (!tangDan) {
            Collections.reverse(list);
        }

        fillTable();
    }

    public void sortTableByName(boolean tangDan) {
        list.sort(Comparator.comparing(NhanVien::getTenNV));

        if (!tangDan) {
            Collections.reverse(list);
        }

        fillTable();
    }

    public String getLastName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            return "";
        }
        int lastSpaceIndex = fullName.lastIndexOf(" ");
        if (lastSpaceIndex == -1) {
            return fullName;
        }
        return fullName.substring(lastSpaceIndex + 1);
    }

    public String getFirstName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            return "";
        }
        int firstSpaceIndex = fullName.indexOf(" ");
        if (firstSpaceIndex == -1) {
            return fullName;
        }
        return fullName.substring(0, firstSpaceIndex);
    }

    public String getMiddleName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            return "";
        }
        int firstSpaceIndex = fullName.indexOf(" ");
        int lastSpaceIndex = fullName.lastIndexOf(" ");
        if (firstSpaceIndex == -1 || lastSpaceIndex == -1 || firstSpaceIndex == lastSpaceIndex) {
            return "";
        }
        return fullName.substring(firstSpaceIndex + 1, lastSpaceIndex);
    }

public void orderByName(boolean tangdan) {
    Comparator<String> vietnameseComparator = new Comparator<String>() {
        @Override
        public int compare(String str1, String str2) {
            Collator collator = Collator.getInstance(new Locale("vi", "VN"));
            return collator.compare(str1, str2);
        }
    };

    Comparator<NhanVien> com = new Comparator<NhanVien>() {
        @Override
        public int compare(NhanVien nv1, NhanVien nv2) {
            String lastName1 = getLastName(nv1.getTenNV());
            String lastName2 = getLastName(nv2.getTenNV());

            int lastNameComparison = vietnameseComparator.compare(lastName1, lastName2);
            if (lastNameComparison != 0) {
                return lastNameComparison;
            }

            String middleName1 = getMiddleName(nv1.getTenNV());
            String middleName2 = getMiddleName(nv2.getTenNV());

            int middleNameComparison = vietnameseComparator.compare(middleName1, middleName2);
            if (middleNameComparison != 0) {
                return middleNameComparison;
            }

            String firstName1 = getFirstName(nv1.getTenNV());
            String firstName2 = getFirstName(nv2.getTenNV());

            return vietnameseComparator.compare(firstName1, firstName2);
        }
    };

    Collections.sort(list, com);
    if (!tangdan) {
        Collections.reverse(list);
    }
    fillTable();
}
    public int getMaNV(String id) {
        int maNV = Integer.parseInt(id.substring(2));
        return maNV;
    }

    public void orderByID(boolean tangdan) {
        Comparator<NhanVien> com = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return Integer.compare(getMaNV(o1.getMaNV()), getMaNV(o2.getMaNV()));
            }
        };
        Collections.sort(list, com);
        if (!tangdan) {
            Collections.reverse(list);
        }
        fillTable();
    }
    
    private void addKeyListenerToTxtSearch() {
        txtSearch.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                if (searchTimer != null && searchTimer.isRunning()) {
                    searchTimer.restart(); // Reset thời gian chờ nếu đã có đang chạy
                } else {
                    searchTimer = new Timer(SEARCH_DELAY, new ActionListener() {
                        public void actionPerformed(ActionEvent actionEvent) {
                            performSearch();
                        }
                    });
                    searchTimer.setRepeats(false); // Chỉ chạy một lần
                    searchTimer.start(); // Khởi động thời gian chờ
                }
            }
        });
    }

    private void performSearch() {
        String searchText = txtSearch.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);

        for (NhanVien nhanVien : list) {
            if (nhanVien.getTenNV().toLowerCase().contains(searchText) || nhanVien.getMaNV().equals(searchText)
                    || String.valueOf(nhanVien.getTuoi()).equals(searchText)
                    || String.valueOf(nhanVien.getLuong()).equals(searchText)
                    || nhanVien.getEmail().equals(searchText)) {
                model.addRow(new Object[]{nhanVien.getMaNV(), nhanVien.getTenNV(), nhanVien.getTuoi(), nhanVien.getEmail(), nhanVien.getLuong()});

            }
            if (txtSearch.getText().equals("")) {
                fillTable();
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
