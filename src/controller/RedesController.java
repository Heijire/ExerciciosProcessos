package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	private String os() {
		String os = System.getProperty("os.name");
		System.out.println(os);
		return os;
	}
	
	public  void ip () {
	 String sistema = os();
	 String ip;
	if(sistema.contains("Windows")) {
		ip = "IPCONFIG";
	}	else if(sistema.contains("Linux")) {
		ip = "ifconfig";
	} else {
		System.out.println("Sistema não suportado");
		return;
	}
		try{
			Process proc = Runtime.getRuntime().exec(ip);
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if(linha.contains("IPv4")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	public void ping() {		
		String SO = os();
		String PING;
		if(SO.contains("Windows")) {
			PING = "ping -4 -n 10 www.google.com.br";
		}	else if(SO.contains("Linux")) {
			PING = "ping -4 -c 10 www.google.com.br";
		} else {
			System.out.println("Sistema não suportado");
			return;
		}
			try{
				Process proc = Runtime.getRuntime().exec(PING);
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if(linha.contains("dia = ")) {
					String[] valor = linha.split("dia ="); 
					System.out.println(" O tempo medio do ping obtido é de " + valor[1]);
					}
					//System.out.println(linha);
					linha = buffer.readLine();
				}
			}catch (IOException e) {
				e.printStackTrace();
				}
	}
}