package classesObjetosConta;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Conta {

	private List<Movimentacao> listaDeMovimentacao = new ArrayList();

	private String titularDaConta;

	private int status; //1-Conta Corrente  2-Conta Poupanca

	private double saldo;

	//===============================================================

	public void movimento(Movimentacao movimentacao){
		listaDeMovimentacao.add(movimentacao);
	}

	public String gettitularDaConta(){
		return titularDaConta;
	}

	public void settitularDaConta(String titularDaConta){
		this.titularDaConta = titularDaConta;
	}

	public int getstatus(){
		return status;
	}

	public void setstatus(int status){
		this.status = status;
	}

	public double getsaldo(){
		return saldo;
	}

	public void depositar(Double valor){
		this.saldo = valor;
	}

	public void sacar(double saldo){
		this.saldo = saldo;
	}

	public String consultarSaldo(){
		
		String msg;

		msg = "Titular da conta: "+titularDaConta+"\n";

		if(status == 1){
			msg += "Tipo da conta: Conta Corrente \n";
		}else if(status == 2){
			msg += "Tipo da conta: Conta Poupanca \n";
		}

		msg += "Saldo: "+saldo;

		return msg;
		
	}

	public String gerarExtrato(){
		
		String msg = "";

		for(Movimentacao movimentacao : listaDeMovimentacao){
			msg += "Tipo da transacao: " + movimentacao.getstatus() + "\n";
			msg += "Valor: " + movimentacao.getvalor() + "\n";
			msg += "Data: " + movimentacao.getdata() + "\n";
			msg += "Horario: " + movimentacao.gethora() + "\n";
			msg += "################################################# \n";
		}
		
		return msg;
		
	}

	public String gerarExtratoDepositos(){
		
		String msg = "";

		for(Movimentacao movimentacao : listaDeMovimentacao){
			if(movimentacao.getstatus() == "Deposito"){
				msg += "Tipo da transacao: " + movimentacao.getstatus() + "\n";
				msg += "Valor: " + movimentacao.getvalor() + "\n";
				msg += "Data: " + movimentacao.getdata() + "\n";
				msg += "Horario: " + movimentacao.gethora() + "\n";
				msg += "################################################# \n";
			}
		}

		return msg;
		
	}

	public String gerarExtratoSaques(){
		
		String msg = "";

		for(Movimentacao movimentacao : listaDeMovimentacao){
			
			if(movimentacao.getstatus() == "Saque"){

				msg += "Tipo da transacao: " + movimentacao.getstatus() + "\n";
				msg += "Valor: " + movimentacao.getvalor() + "\n";
				msg += "Data: " + movimentacao.getdata() + "\n";
				msg += "Horario: " + movimentacao.gethora() + "\n";
				msg += "################################################# \n";
			}

		}
		
		return msg;
		
	}

}
