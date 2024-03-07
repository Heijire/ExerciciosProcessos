package view;
import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {
	public static void main(String[] args) {		
		RedesController redes = new RedesController();
	int num = 0;
	while(num!= 9) {
		num = Integer.parseInt(JOptionPane.showInputDialog(" Digite a opção desejada \n 1 - Configuração de IPv4"
				+ "\n 2 - Tempo medio do Ping\n 9 - Finalizar"));
		switch (num) {
		case 1: redes.ip();
			break;
		case 2:	redes.ping();
			break;
		case 9: System.out.println("Programa Finalizado");
			break;
		default: System.out.println("Opcão invalida");
			break;
		}
	}

}}

