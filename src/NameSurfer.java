/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import acm.graphics.GCanvas;
import acm.program.Program;

public class NameSurfer extends Program implements NameSurferConstants {

    // Instance variables
    private JFrame frame;
    private JPanel buttonPanel;
    private JLabel name;
    private JTextField textBox;
    private JButton graph;
    private JButton clear;
    private GCanvas canvas;
    private NameSurferDataBase nameDB;

    /* Method: init() */

    /**
     * This method has the responsibility for reading in the data base and
     * initializing the interactors at the bottom of the window.
     */
    public void init() {
        nameDB = new NameSurferDataBase(NAMES_DATA_FILE);
        setupGUI();
    }

    private void setupGUI() {
        frame = new JFrame("NameSurfer");
        frame.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        frame.setVisible(true);

        addGraphicCanvas();
        addButtonPanel();

    }

    private void addGraphicCanvas() {
        canvas = new GCanvas();
        frame.add(canvas);
    }

    private void addButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        name = new JLabel("Name");
        textBox = new JTextField();
        graph = new JButton("Graph");
        graph.addActionListener(new ListenToGraph());
        clear = new JButton("Clear");
        clear.addActionListener(new ListenToClear());

        buttonPanel.add(name, 0);
        buttonPanel.add(textBox, 1);
        buttonPanel.add(graph, 2);
        buttonPanel.add(clear, 3);

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    /* Method: actionPerformed(e) */

    /**
     * This class is responsible for detecting when the buttons are clicked, so
     * you will have to define a method to respond to button actions.
     */
    private class ListenToGraph implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String queryName = textBox.getText();
            println("Graph \"" + queryName + "\"");
            println(nameDB.findEntry(queryName).toString());
        }
    }

    private class ListenToClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            println("Clear");
        }
    }

}
