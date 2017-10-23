package com.tallerthree.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputLine {
	
	
	
	/*
	CheckBadFormat imtChekBadFormatPhome = new CheckBadFormat() {		
		@Override
		public boolean CheckBadFormat(String entrada) {
			// TODO Auto-generated method stub
			return false;
		}
	};*/
	
	
	
	/*CheckBadFormat imtChekBadFormatLine = new CheckBadFormat() {		
		@Override
		public boolean CheckBadFormat(String entrada) {
			return check(entrada,"(\\p{Alpha}|\\s)+");
		}
	};*/
	
	
	
	public String scannPhone(){
		return scannLinne("Debe entrar un numero telefonico",new CheckBadFormat() {	
			@Override
			public boolean checkFormat(String entrada) {
				return check(entrada,"\\d{9}");
			}
		}); 
	}
	
	public String scannEmail(){
		return scannLinne("Debe entrar un email", new CheckBadFormat() {			
			@Override
			public boolean checkFormat(String entrada) {
				
				return check(entrada,"\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
			}
		}); 
	}
	
	


	
	public String scannLine(){
		return scannLinne("Debe entrar una line",new CheckBadFormat() {	
			@Override
			public boolean checkFormat(String entrada) {
				return check(entrada,"(\\p{Alpha}|\\s)+");
			}
		}); 
	}
	
	protected String scannLinne(String label,CheckBadFormat checkBadFormat){
		
		boolean correcto=false;
		String entrada;
		do{
			System.out.println(label);
			entrada=Input.scannLine();
			correcto=  checkBadFormat.checkFormat(entrada);
			if(correcto==false){
				System.out.println("formato incorrecto"); 
			}
		}while(!correcto);
		
		return entrada; 
	}
	
	private boolean check(String entrada, String regex){
		Pattern pa= Pattern.compile(regex);
		Matcher ma = pa.matcher(entrada); 
		return ma.matches();
	}
	
	public interface CheckBadFormat {
		public boolean checkFormat(String entrada);
	}

}
