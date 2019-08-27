package interfaceGrafica;

import javax.swing.JOptionPane;

import progPrincipal.EntradaSaida;
import classesObjetosConta.Conta;
import classesObjetosConta.Movimentacao;

public class MenuOpcoes {

	Conta conta = new Conta();
	EntradaSaida entradaSaida = new EntradaSaida();

	public void exibirMenu(){
		while(true){

			int acao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opcoes abaixo: \n"
					+ "1 - Depositar \n"
					+ "2 - Sacar \n"
					+ "3 - Consultar Saldo \n" 
					+ "4 - Extrato \n"
					+ "5 - Extrato Depositos \n"
					+ "6 - Extrato Saques \n"
					+ "7 - Sair"));

			switch(acao){
			case 1:
				entradaSaida.infoDeposito(conta);
				break;
			case 2:
				entradaSaida.infoSaque(conta);
				break;
			case 3:
				entradaSaida.infoSaldo(conta);
				break;
			case 4:
				entradaSaida.infoExtrato(conta);
				break;
			case 5:
				entradaSaida.infoExtratoDeposito(conta);
				break;
			case 6:
				entradaSaida.infoExtratoSaque(conta);
				break;
			case 7:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Op��o Inexistente", "Erro", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}
}