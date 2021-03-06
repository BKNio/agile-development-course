package ru.unn.agile.leftistHeap.view;

import javax.swing.*;

import ru.unn.agile.leftistHeap.viewModel.ViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeapManager {
    private JPanel mainPanel;
    private JTextField addKeyTextField;
    private JTextField addValueTextField;
    private JButton addButton;
    private JButton getButton;
    private JButton deleteButton;
    private JLabel statusLabel;
    private JLabel minKeyLabel;
    private JLabel minValueLabel;

    private ViewModel viewModel;

    public HeapManager(ViewModel viewModel) {
        this.viewModel = viewModel;
        backBind();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bind();
                HeapManager.this.viewModel.addToLeftistHeap();
                backBind();
            }
        });

        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bind();
                HeapManager.this.viewModel.getMinFromLeftistHeap();
                backBind();
            }
        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bind();
                HeapManager.this.viewModel.deleteMinFromLeftistHeap();
                backBind();
            }
        });
    }

    public void bind() {
        viewModel.keyAdd = addKeyTextField.getText();
        viewModel.valueAdd = addValueTextField.getText();
        viewModel.keyGetDel = minKeyLabel.getText();
        viewModel.valueGetDel = minValueLabel.getText();
        viewModel.status = statusLabel.getText();
    }

    public void backBind() {
        addKeyTextField.setText(viewModel.keyAdd);
        addValueTextField.setText(viewModel.valueAdd);
        minKeyLabel.setText(viewModel.keyGetDel);
        minValueLabel.setText(viewModel.valueGetDel);
        statusLabel.setText(viewModel.status);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HeapManager");
        frame.setContentPane(new HeapManager(new ViewModel()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
