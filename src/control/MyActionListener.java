package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionListener implements ActionListener {


	public MyActionListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// objeto componente que dispara el evento
		JButton boton =  (JButton)e.getSource();
		String[] split = boton.getName().split(":");
		System.out.println("posicion x"+split[0]);
		System.out.println("posicion y"+split[1]);
	}

}
