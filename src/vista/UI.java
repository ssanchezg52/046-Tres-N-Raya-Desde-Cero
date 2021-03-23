package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.MyActionListener;

import java.awt.GridLayout;

public class UI extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public UI() {
		int dimension=3;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel botonera = new JPanel();
		botonera.setBounds(122, 58, 228, 181);
		contentPane.add(botonera);
		botonera.setLayout(new GridLayout(3, 3, 0, 0));
		MyActionListener myActionListener=new MyActionListener();
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				MyJButton comp = new MyJButton(i,j);
				comp.addActionListener(myActionListener);
				botonera.add(comp);
			}
		}
	}
}
