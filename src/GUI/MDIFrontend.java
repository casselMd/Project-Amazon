package GUI;


public class MDIFrontend extends javax.swing.JFrame {



    public MDIFrontend() { 
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        menuItemVenta = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/archivoses.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivos");

        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/salirM.png"))); // NOI18N
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/gesVenta.png"))); // NOI18N
        editMenu.setMnemonic('e');
        editMenu.setText("Ventas");

        menuItemVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuItemVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/nuevo.png"))); // NOI18N
        menuItemVenta.setMnemonic('t');
        menuItemVenta.setText("Nuieva venta");
        menuItemVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVentaActionPerformed(evt);
            }
        });
        editMenu.add(menuItemVenta);

        copyMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ventGES.png"))); // NOI18N
        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Gestión venta");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(copyMenuItem);

        menuBar.add(editMenu);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/clienteass.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Pesonas");

        contentMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contentMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/userGes.png"))); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Gestión Usuario");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/clieges.png"))); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Gestión Cliente");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/configurabis.png"))); // NOI18N
        jMenu1.setText("Configuraciones");

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/info.png"))); // NOI18N
        jMenuItem1.setText("Información");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void menuItemVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVentaActionPerformed
        JIFResgistroVenta jifventa= new JIFResgistroVenta();
        this.desktopPane.add(jifventa);
        jifventa.setVisible(true);
    }//GEN-LAST:event_menuItemVentaActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        JIFGestionVentas jifges = new JIFGestionVentas();
        this.desktopPane.add(jifges);
        jifges.setVisible(true);
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        JIFGestionUsuarios userGes = new JIFGestionUsuarios();
        this.desktopPane.add(userGes);
        userGes.setVisible(true);
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JIFGestionCliente clie = new JIFGestionCliente();
        this.desktopPane.add(clie);
        clie.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JIFConfiguracion confi = new JIFConfiguracion();
        this.desktopPane.add(confi);
        confi.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
  



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemVenta;
    // End of variables declaration//GEN-END:variables

}
