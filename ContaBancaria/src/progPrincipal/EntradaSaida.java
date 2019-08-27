package progPrincipal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

import classesObjetosConta.Conta;
import classesObjetosConta.Movimentacao;


public class EntradaSaida {

	LocalDateTime date = LocalDateTime.now();

	public void infoDeposito(Conta conta){

		Movimentacao movimentacao = new Movimentacao();

		String titularDaConta = JOptionPane.showInputDialog("Informe o titular da conta: ");

		int tipo = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo da operacao: \n"
				+ "1 - Conta Corrente \n"
				+ "2 - Conta Poupanca"));

		while(tipo <= 0 || tipo > 2)
		{
			JOptionPane.showMessageDialog(null, "Opcao invalida!", "Erro: ", JOptionPane.WARNING_MESSAGE);
			tipo = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo da operacao: \n"
					+ "1 - Conta Corrente \n"
					+ "2 - Conta Poupanca"));
		}

		double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para deposito: "));

		while(valor <= 0)
		{
			JOptionPane.showConfirmDialog(null, "Deposito nao realizado! \n"
					+ "Realize um deposito maior que zero!", "Erro", JOptionPane.WARNING_MESSAGE);
			valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para deposito: "));
		}

		String status = "Deposito";

		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String data = formatterData.format(date);

		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String hora = formatterHora.format(date);


		movimentacao.setstatus(status);
		movimentacao.setvalor(valor);
		movimentacao.setdata(data);
		movimentacao.sethora(hora);

		conta.settitularDaConta(titularDaConta);
		conta.setstatus(tipo);
		conta.depositar(valor);

		conta.movimento(movimentacao);

		JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!");

	}

	public void infoSaque(Conta conta){

		Movimentacao movimentacao = new Movimentacao();

		double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para o saque: "));

		while(valor <= 0)
		{
			JOptionPane.showConfirmDialog(null, "Saque nao realizado! \n"
					+ "Realize um saque maior que zero!", "Erro", JOptionPane.WARNING_MESSAGE);
			valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para o saque: "));
		}

		double saldo = (conta.getsaldo() - valor);

		if(saldo < -1000)
		{
			JOptionPane.showMessageDialog(null, "Operacao cancelada! \n"
					+ "Limite de saque excedido!", "Erro", JOptionPane.WARNING_MESSAGE);
		}
		else
		{

			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			String data = formatterData.format(date);

			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
			String hora = formatterHora.format(date);

			String status = "Saque";
			movimentacao.setstatus(status);
			movimentacao.setvalor(valor);
			movimentacao.setdata(data);
			movimentacao.sethora(hora);

			conta.movimento(movimentacao);
			conta.sacar(saldo);

			JOptionPane.showMessageDialog(null, "Saque de R$"+valor+" Realizado com sucesso!");
			
		}
	}

	public void infoSaldo(Conta conta){

		String msg = conta.consultarSaldo();

		JOptionPane.showMessageDialog(null, msg);
	}

	public void infoExtrato(Conta conta){
		
		String extrato = "";
		String msg = conta.gerarExtrato();

		if(msg == ""){
			
			mensagemErro(extrato);
			
		}else{

			JOptionPane.showMessageDialog(null, msg);
		}
	}

	public void infoExtratoDeposito(Conta conta){

		String deposito = "de DEP�SITO";
		String msg = conta.gerarExtratoDepositos();

		if(msg == ""){

			mensagemErro(deposito);	

		}else{

			JOptionPane.showMessageDialog(null, msg);

		}
	}

	public void infoExtratoSaque(Conta conta){

		String saque = "de SAQUE";
		String msg = conta.gerarExtratoSaques();

		if(msg == ""){

			mensagemErro(saque);

		}else{

			JOptionPane.showMessageDialog(null, msg);

		}
	}

	public void mensagemErro(String tipo){
		
		JOptionPane.showMessageDialog(null, "Nenhum extrato "+tipo+" registrado!" , "Erro", JOptionPane.WARNING_MESSAGE);
	
	}

}
