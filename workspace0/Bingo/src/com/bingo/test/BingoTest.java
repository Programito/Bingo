package com.bingo.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.bingo.utils.utils;


public class BingoTest {
	

	@Test
	public void betweenMinMaxTest(){
		//valor,minimo,maximo
		Assert.assertEquals(true, utils.betweenMinMax(12, 1, 15));
		Assert.assertEquals(false, utils.betweenMinMax(20, 12, 18));
		Assert.assertEquals(false, utils.betweenMinMax(1, 15, 20));
	}
	
	@Test
	public void checkArrayMinMaxTest(){
		int[] valores={16,17,18,19,20,21}; 
		Assert.assertEquals(true, utils.checkArrayMinMax(valores, 16,30));
		Assert.assertEquals(false, utils.checkArrayMinMax(valores, 16,20));
		Assert.assertEquals(false, utils.checkArrayMinMax(valores, 17,30));
		valores[3]=31;
		Assert.assertEquals(false, utils.checkArrayMinMax(valores, 16,30));
	}
	
	@Test
	public void getColTest(){
		int[][] card={{3,17,35,54,61},{8,28,41,48,68},{4,23,-1,52,70},{7,29,37,55,74},{11,19,33,50,73}};
		Assert.assertArrayEquals(new int[] {3,8,4,7,11},utils.getCol(card, 0));
		Assert.assertArrayEquals(new int[] {17,28,23,29,19},utils.getCol(card, 1));
		Assert.assertArrayEquals(new int[] {35,41,37,33},utils.getCol(card, 2));
		Assert.assertArrayEquals(new int[] {54,48,52,55,50},utils.getCol(card, 3));
		Assert.assertArrayEquals(new int[] {61,68,70,74,73},utils.getCol(card, 4));
	}
	
	@Test
	public void checkMinMaxTest(){
		int[][] card={{3,17,35,54,61},{8,28,41,48,68},{4,23,-1,52,70},{7,29,37,55,74},{11,19,33,50,73}};
		Assert.assertTrue(utils.checkMinMax(card, 0));
		Assert.assertTrue(utils.checkMinMax(card, 1));
		Assert.assertTrue(utils.checkMinMax(card, 2));
		Assert.assertTrue(utils.checkMinMax(card, 3));
		Assert.assertTrue(utils.checkMinMax(card, 4));
	}
	
	
	
	
	
	
	
	
	
	/*@Test
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
		int[][] card= {{-1,8,15,7,11},{17,-1,23,20,19},{35,41,-1,37,33},{54,48,52,-1,50},{61,68,70,74,-1}};
		
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
		
	}*/
	
	
	
}
