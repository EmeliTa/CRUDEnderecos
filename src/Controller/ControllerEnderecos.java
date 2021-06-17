package Controller;

import View.TelaPrincipal;

public class ControllerEnderecos {
	public void run() {
	TelaPrincipal tela = new TelaPrincipal();
	boolean continuar = true;
	
	do {
		String opc = tela.menuListaEndereco();
		int escolha = Integer.parseInt(opc); 
		switch (escolha) {
		case 1:
			tela.cadastrarEndereco();
			break;
		case 2:
			tela.atualizarEndereco();
			
			break;
		case 3:
			tela.deletarEndereco();
			break;
		case 4:
			tela.listarEndereco();
			break;
		case 5:
			continuar = false;
			break;
		default:
				System.out.println("Valor inválido!");
			break;
		};
	}
	while(continuar);
	
	System.out.println("SAÍDA!!");
	}
}
