package classesObjetosConta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movimentacao {
	
	private String status; //1-Deposito  2-Saque
	
	private double valor;
	
	private String data;
	
	private String hora;
	
	//========================================================
	
	public String getstatus(){
		return status;
	}
	
	public void setstatus(String status){
		this.status = status;
	}
	
	public double getvalor(){
		return valor;
	}
	
	public void setvalor(double valor){
		this.valor = valor;
	}
	
	public String getdata(){
		return data;
	}
	
	public void setdata(String data){
		this.data = data;
	}
	
	public String gethora(){
		return hora;
	}
	
	public void sethora(String hora){
		this.hora = hora;
	}
}
