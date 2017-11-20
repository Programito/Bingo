package com.bingo.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class BingoTest {
	@Test
	public void CallingNumberTest(){
		CardT cardT=new CardT();
		int max=15;
		int min=1;
		//que cumplan el valor maximo y minimo
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(i!=j){
					Assert.assertTrue(cardT.getCardT(i, j)<=max);
					Assert.assertTrue(cardT.getCardT(i, j)>=min);
				}
			}
			max=max+15;
			min=min+15;
		}
		//que no tenga valores repetidos
		for(int i=0;i<5;i++){
			for(int k=0;k<5;k++){
			int total=0;
			for(int j=0;j<5;j++){
				int valor=cardT.getCardT(k,i);
				if(valor==cardT.getCardT(k, j)){
					total++;
				}
			}
			Assert.assertTrue(total==1);
		}
		}
	}
	
	@Test
	public void CheckBingo(){
		CardT cardT=new CardT();
		ArrayList<Integer> numbers=new ArrayList(); 
		for(int i=0;i<numbers.size();i++){
			int valor=numbers.get(i);
			int total=0;
			for(int j=0;j<5;j++){
				for(int k=0;k<5;k++){
					if(valor==cardT.getCardT(j, k)){
						total++;
					}
				}
			}
			Assert.assertTrue(total==1);
		}
	}
	
	public static class CardT{
		int[][] card= {{-1,8,4,7,11},{17,-1,23,28,19},{35,41,-1,37,33},{54,48,52,-1,50},{61,68,70,74,-1}};
		
		public CardT(){
			
		}
		
		public int getCardT(int i, int j){
			return card[i][j];
		}
		
		public int getSizeJ(){
			return card[0].length;
		}
		
		public int getSizeI(){
			return card.length;
		}
		
	}
	
	
	
}
