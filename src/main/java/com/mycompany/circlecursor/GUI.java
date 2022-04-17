/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.circlecursor;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolTip;
import javax.swing.Timer;
import javax.swing.ToolTipManager;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JWindow;

import java.awt.event.MouseEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Dita Darma Pangestiningrum
 */
public class GUI extends JFrame implements MouseMotionListener{
    
    private JPanel panel = new MyPanel();
    int pX, pY;

    /**
     * Creates new form GUI
     */
    public void mouseMoved(MouseEvent e) {
       System.out.println("X : " + e.getX());
       System.out.println("Y : " + e.getY());
    }
    
    public GUI() {
        
        ToolTipManager ttm = ToolTipManager.sharedInstance();
        ttm.setInitialDelay(200);
        ttm.setDismissDelay(10000);
        panel.setToolTipText("Text 1");
        final Timer timer = new Timer(50, new ActionListener() {
            private int id = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
//                PointerInfo a = MouseInfo.getPointerInfo();
//                Point b = new Point(a.getLocation());
//                SwingUtilities.convertPointFromScreen(b, panel.getComponent()));
//                int x = (int) b.getX();
//                int y = (int) b.getY();
//                double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
//                double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
//                panel.setToolTipText("x:" + x + " y:" + y);
                panel.setToolTipText("x:" + pX + " y:" + pY);
            }
        });
        timer.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        
//        panel.addMouseListener(new MouseAdapter() {
//            @Override 
//            public void mouseMoved(MouseEvent e) {
//              System.out.println(e.getX() + "," + e.getY());
//              panel.setToolTipText(e.getX() + "," + e.getY());
//            }
//        });

        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                // Get x,y and store them
                pX = me.getX();
                pY = me.getY();
            }
        });
        panel.addMouseMotionListener(new MouseAdapter() {
             public void mouseMoved(MouseEvent me) {
//                 panel.setLocation(panel.getLocation().x + me.getX() - pX, 
//                      panel.getLocation().y + me.getY() - pY);
                    pX = me.getX();
                    pY = me.getY();
             }
        });

        
        pack();
        setLocation(150, 100);
        setVisible(true);
    }
   
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Shape circleShape = new Ellipse2D.Double(100, 60, 100, 100);
        g2d.draw(circleShape);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private static final class MyPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }

        @Override
        public JToolTip createToolTip() {
            final JToolTip tip = super.createToolTip();
            final PropertyChangeListener updater = new PropertyChangeListener() {
                @Override
                public void propertyChange(final PropertyChangeEvent e) {
                    if (e.getNewValue() != null) {
                        tip.setTipText((String) e.getNewValue());
                        tip.repaint();
                    }
                }
            };
            tip.addAncestorListener(new AncestorListener() {
                @Override
                public void ancestorAdded(AncestorEvent event) {
                    //start listening for tip text changes only after the tip 
                    //is displayed, i.e. the tip is added to the component hierarchy
                    MyPanel.this.addPropertyChangeListener(TOOL_TIP_TEXT_KEY, updater);
                }

                @Override
                public void ancestorRemoved(AncestorEvent event) {
                    //stop listening for tip text changes once the tip is no longer 
                    //displayed, i.e. the tip is removed from the component hierarchy
                    MyPanel.this.removePropertyChangeListener(TOOL_TIP_TEXT_KEY, updater);
                }

                @Override
                public void ancestorMoved(AncestorEvent event) {
                }
            });
            return tip;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
