package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.MyJButton;

public class MyActionListener implements ActionListener {

	public MyActionListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// objeto componente que dispara el evento
		MyJButton boton = (MyJButton) e.getSource();
		System.out.println("posicion "+boton.getX()+":"+boton.getY());
	}

}
