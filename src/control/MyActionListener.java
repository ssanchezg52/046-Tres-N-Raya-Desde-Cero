package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyActionListener implements ActionListener {

	private JButton[][] miBotonera;
	
	public MyActionListener(JButton[][] miBotonera) {
		this.miBotonera=miBotonera;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("pulsado");
		//objeto componente que dispara el evento
		JButton boton=(JButton)e.getSource();
		findMyButton(boton);
	}

	private void findMyButton(JButton boton) {
		for (int i = 0; i < miBotonera.length; i++) {
			for (int j = 0; j < miBotonera[i].length; j++) {
				if(miBotonera[i][j]==boton) {
					System.out.println("en la posicion "+i+":"+j);
				}
			}
		}		
	}

}
