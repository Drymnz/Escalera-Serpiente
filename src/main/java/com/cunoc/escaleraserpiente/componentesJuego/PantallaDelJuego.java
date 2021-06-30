/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cunoc.escaleraserpiente.componentesJuego;

import com.cunoc.escaleraserpiente.ManejadorArchivos.ManejoEscrituraLectura;
import com.cunoc.escaleraserpiente.Start;
import com.cunoc.escaleraserpiente.Usuario.Usuario;
import com.cunoc.escaleraserpiente.guardarPartidaCargar.ManejoGuardarPartida;
import java.awt.Color;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author drymnz
 */
public class PantallaDelJuego extends javax.swing.JPanel implements Runnable {

    private Usuario[] listado;
    private Ficha[] listadoFichas;
    private int CantidadDeJugadores;
    private int turno = 0;
    private int fila, columna;
    private ReglaJuegoSS reglas;
    private Thread hiloCronometro;

    /**
     * Creates new form PantallaDelJuego
     */
    public PantallaDelJuego(int fila, int columna, Usuario[] listado, int CantidadDeJugadores) {
        initComponents();
        this.CantidadDeJugadores = CantidadDeJugadores;
        turnoAcutal.setDado(dado);
        hiloCronometro = new Thread(cronometro1);
        hiloCronometro.start();
        this.fila = fila;
        this.columna = columna;
        jugadores(listado);
        tablero1.botones(fila, columna);
        reglas = new ReglaJuegoSS(listadoFichas, tablero1, CantidadDeJugadores, turno);

    }

    public PantallaDelJuego(int fila, int columna, Usuario[] listado, int CantidadDeJugadores, Tablero tablero) {
        initComponents();
        this.tablero1 = tablero;
        this.tablero1 = tablero;
        this.tablero1 = tablero;
        this.tablero1 = tablero;
        this.CantidadDeJugadores = CantidadDeJugadores;
        this.columna = columna;
        this.fila = fila;

        jugadores(listado);
        reglas = new ReglaJuegoSS(listadoFichas, tablero1, CantidadDeJugadores, turno);

        turnoAcutal.setDado(dado);
        hiloCronometro = new Thread(cronometro1);
        hiloCronometro.start();

    }

    private void jugadores(Usuario[] Revisar) {
        if (Revisar != null) {
            listado = new Usuario[CantidadDeJugadores];
            for (int i = 0; i < Revisar.length; i++) {
                if (Revisar[i] != null) {
                    listado[i] = Revisar[i];
                }
            }
            asignarTurnos();
        }
    }

    public void cargarTablero() {
        tablero1.removeAll();
        tablero1.cargar();
        this.repaint();
    }

    private void asignarTurnos() {
        if (listado != null) {
            int mazar = 10;
            do {
                int mover = (int) (Math.random() * listado.length - 1);
                int con = (int) (Math.random() * listado.length - 1);
                Usuario auxiliar = listado[mover];
                listado[mover] = listado[con];
                listado[con] = auxiliar;
                mazar--;
            } while (mazar == 0);
            asignarFichas();
        }

    }

    private void asignarFichas() {
        if (listado != null) {
            listadoFichas = new Ficha[listado.length];
            for (int i = 0; i < listado.length; i++) {
                listadoFichas[i] = new Ficha(colorAleatorio(), listado[i], null);
            }
        }
        turnoAcutal.turnoDe(listadoFichas[0]);
        mostrarListadoJugadores();
    }

    private void mostrarListadoJugadores() {
        DefaultTableModel modificar = (DefaultTableModel) JTableLIstadoJugadores.getModel();
        for (int i = 0; i < listado.length; i++) {
            if (listado[i] != null) {
                modificar.addRow(new Object[]{listado[i].getId(), listado[i].getNombre(), listado[i].getApellido()});
            }
        }
    }

    private Color colorAleatorio() {
        int numero = (int) (Math.random() * 5);
        return (numero == 0) ? Color.BLUE : (numero == 1) ? Color.CYAN : (numero == 2) ? Color.DARK_GRAY : (numero == 3) ? Color.GRAY : Color.LIGHT_GRAY;
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
        dado = new com.cunoc.escaleraserpiente.componentesJuego.Dado();
        JButtonLanzar = new javax.swing.JButton();
        turnoAcutal = new com.cunoc.escaleraserpiente.componentesJuego.TurnoAcutal();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableLIstadoJugadores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cronometro1 = new com.cunoc.escaleraserpiente.Cronometro.Cronometro();
        jButton1 = new javax.swing.JButton();
        Registro = new javax.swing.JLabel();
        JPanelTablero = new javax.swing.JPanel();
        tablero1 = new com.cunoc.escaleraserpiente.componentesJuego.Tablero();

        jPanel1.setBackground(new java.awt.Color(177, 193, 118));

        javax.swing.GroupLayout dadoLayout = new javax.swing.GroupLayout(dado);
        dado.setLayout(dadoLayout);
        dadoLayout.setHorizontalGroup(
            dadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        dadoLayout.setVerticalGroup(
            dadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        JButtonLanzar.setText("Lanzar");
        JButtonLanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonLanzarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout turnoAcutalLayout = new javax.swing.GroupLayout(turnoAcutal);
        turnoAcutal.setLayout(turnoAcutalLayout);
        turnoAcutalLayout.setHorizontalGroup(
            turnoAcutalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        turnoAcutalLayout.setVerticalGroup(
            turnoAcutalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        JTableLIstadoJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTableLIstadoJugadores);

        jLabel1.setText("Listado de jugadores.");

        jLabel2.setText("Este es el dado :");

        javax.swing.GroupLayout cronometro1Layout = new javax.swing.GroupLayout(cronometro1);
        cronometro1.setLayout(cronometro1Layout);
        cronometro1Layout.setHorizontalGroup(
            cronometro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        cronometro1Layout.setVerticalGroup(
            cronometro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jButton1.setText("Guardar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Registro.setText("El truno acabo en .");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(turnoAcutal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(cronometro1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JButtonLanzar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cronometro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turnoAcutal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(JButtonLanzar)))
                .addGap(18, 18, 18)
                .addComponent(Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        JPanelTablero.setBackground(new java.awt.Color(174, 74, 180));

        tablero1.setBackground(new java.awt.Color(149, 237, 44));

        javax.swing.GroupLayout tablero1Layout = new javax.swing.GroupLayout(tablero1);
        tablero1.setLayout(tablero1Layout);
        tablero1Layout.setHorizontalGroup(
            tablero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );
        tablero1Layout.setVerticalGroup(
            tablero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JPanelTableroLayout = new javax.swing.GroupLayout(JPanelTablero);
        JPanelTablero.setLayout(JPanelTableroLayout);
        JPanelTableroLayout.setHorizontalGroup(
            JPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
            .addGroup(JPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tablero1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelTableroLayout.setVerticalGroup(
            JPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(JPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tablero1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JPanelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonLanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonLanzarActionPerformed
        // TODO add your handling code here:
        if (dado.isDisponible()) {
            new Thread(this).start();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor espere que acabe el dado");
        }
    }//GEN-LAST:event_JButtonLanzarActionPerformed
// aqui es para aguardar la partidad
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Start.ejecutar.irMenuPrincipal();
        new Thread(new ManejoGuardarPartida(tablero1, listado)).start();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonLanzar;
    private javax.swing.JPanel JPanelTablero;
    private javax.swing.JTable JTableLIstadoJugadores;
    private javax.swing.JLabel Registro;
    private com.cunoc.escaleraserpiente.Cronometro.Cronometro cronometro1;
    private com.cunoc.escaleraserpiente.componentesJuego.Dado dado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.cunoc.escaleraserpiente.componentesJuego.Tablero tablero1;
    private com.cunoc.escaleraserpiente.componentesJuego.TurnoAcutal turnoAcutal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        tablero1.setFichaEnMovimiento(listadoFichas[turno]);
        new Thread(dado).start();
        do {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        } while (!dado.isDisponible());
        int pasos = dado.getNumeroSalio();
        tablero1.setFichaEnMovimiento(listadoFichas[turno]);
        tablero1.setPasosMoverFicha(pasos);
        Thread p = new Thread(tablero1);
        p.start();
        while (p.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
        // aqui verificar si caso en una casillla en vanzar o retorceder ************************
        dado.setNumeroSalio(pasos);
        //turno = 
        reglas.aplicarRegla(listadoFichas[turno]);
        turno = reglas.getTurno();
        Registro.setText(reglas.getMencionar());
        turnoAcutal.turnoDe(listadoFichas[turno]);

        if ((listadoFichas[turno].getUbicacion() != null && listadoFichas[turno].getUbicacion().getId() > fila * columna) || tablero1.getGanadorUsuario() != null) {
            hiloCronometro.stop();
            for (int i = 0; i < listado.length; i++) {
                if (listado[i] == tablero1.getGanadorUsuario()) {
                    listado[i].setVictoria(listado[i].getVictoria() + 1);
                } else {
                    listado[i].setPerdida(listado[i].getPerdida() + 1);
                }
                listado[i].setCantidadPartidad(listado[i].getCantidadPartidad() + 1);
                (new ManejoEscrituraLectura()).escribirArchivo(listado[i], new File(".Archivo/Usuario/" + listado[i].getId() + ".usuario"));
            }
            Start.ejecutar.irMenuPrincipal();
        }
    }

    public void setTablero1(Tablero tablero1) {
        this.tablero1 = tablero1;
    }

}
