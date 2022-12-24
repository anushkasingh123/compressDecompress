/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import CodeFiles.Compress;
import CodeFiles.Decompress;
import javax.swing.JOptionPane;


/**
 *
 * @author MY PC
 */
public class View extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select File to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 200, 200, 30);
        
        decompressButton = new JButton("Select File to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250, 200, 200, 30);
        
        this.add(compressButton);
        this.add(decompressButton);
        
        this.setSize(500,300);
        this.getContentPane().setBackground(Color.cyan);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compress.compressFunction(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        
        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompress.decompressFunction(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
    }
    
    public static void main(String[] args){
        View view = new View();
        view.setVisible(true);
    }
    
}
