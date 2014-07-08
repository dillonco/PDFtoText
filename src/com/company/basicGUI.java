package com.company;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Denny on 7/3/2014.
 */
public class basicGUI extends JFrame {
    private JButton runButton;
    private JTextField browseFileTextField;
    private JTextField saveAsTextField;
    private JButton browseButton;
    private JButton saveAsButton;
    private JPanel rootPanel;
    private JLabel runningLabel;

    private String browseLocation;
    private String saveLocation;
    private String fileName;

    public basicGUI() {
        super("PDF to Text");
        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setIconImage(Toolkit.getDefaultToolkit().getImage("paper_icon.png"));

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Images", "jpg", "gif", "tif", "pdf");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(getParent());
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    browseLocation = String.valueOf((chooser.getSelectedFile()));
                    fileName =  chooser.getSelectedFile().getName();
                    browseFileTextField.setText(browseLocation);
                    saveLocation = browseLocation.replace(browseLocation.substring(browseLocation.length() - 4), ".txt");
                    saveAsTextField.setText(saveLocation);

                    runningLabel.setText("Image loaded");
                }
            }
        });

        saveAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Save As");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);

                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                        saveLocation = String.valueOf(chooser.getSelectedFile());
                        saveLocation = saveLocation + "\\" + fileName.replace(fileName.substring(fileName.length() - 4), ".txt");
                        saveAsTextField.setText(saveLocation);
                    } else {
                    System.out.println("No Selection ");
                }

            }
                  });



        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (browseLocation.equals("")) {
                    JOptionPane.showMessageDialog(new JFrame(), "Please select a file");
                }
                setRunningLabel("Starting...");
                Main.runOCR(browseLocation, saveLocation);
                setRunningLabel("Finished");
                Main.openFile(saveLocation);
            }
        });

        setVisible(true);
    }

    private void setRunningLabel(String content) {
        runningLabel.setText(content);
    }
}
