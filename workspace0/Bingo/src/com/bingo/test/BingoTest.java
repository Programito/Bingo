package com.bingo.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bingo.main.Balls;
import com.bingo.main.BingoCard;
import com.bingo.utils.utils;


public class BingoTest {
	int[][] card; //correcta
	int[][] card2; //erronea en los rangos de las columnas
	int[][] card3; //erronea en los rangos en la primea columna
	int[][] card4; //erronea en los rangos en la ultima columna
	int[][] card5; //numeros repetidos en odas las columnas
	int[][] card6; //primera columna tiene numeros repetidos
	int[][] card7; //ultima columna tiene numeros repetidos
	
	 @Before 
	 public void initialize() {
		 card=new int[][] {{3,17,35,54,61},{8,28,41,48,68},{4,23,-1,52,70},{7,29,37,55,74},{11,19,33,50,73}};
		 card2=new int[][] {{3,17,35,70,61},{20,2,41,48,68},{4,23,-1,52,70},{7,29,37,55,74},{11,19,16,50,10}};
		 card3=new int[][] {{2,17,35,54,61},{18,28,41,48,68},{4,23,-1,52,70},{7,29,37,55,74},{11,19,33,50,73}};
		 card4=new int[][] {{3,17,35,54,61},{8,28,41,48,68},{4,23,-1,52,70},{7,29,37,55,74},{11,19,33,50,5}};
		 card5=new int[][] {{3,17,35,54,61},{8,28,41,48,68},{3,23,-1,52,70},{7,29,37,52,74},{11,17,41,50,68}};
		 card6=new int[][] {{3,17,35,54,61},{8,28,41,48,68},{4,23,-1,52,70},{7,29,37,55,74},{3,19,33,50,73}};
		 card7=new int[][] {{3,17,35,54,61},{8,28,41,48,68},{4,23,-1,52,73},{7,29,37,55,74},{12,19,33,50,73}};
	 }
	

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
		Assert.assertArrayEquals(new int[] {3,8,4,7,11},utils.getCol(card, 0));
		Assert.assertArrayEquals(new int[] {17,28,23,29,19},utils.getCol(card, 1));
		Assert.assertArrayEquals(new int[] {35,41,37,33},utils.getCol(card, 2));
		Assert.assertArrayEquals(new int[] {54,48,52,55,50},utils.getCol(card, 3));
		Assert.assertArrayEquals(new int[] {61,68,70,74,73},utils.getCol(card, 4));
	}
	
	@Test
	public void checkMinMaxTest(){
		Assert.assertTrue(utils.checkMinMax(card, 0));
		Assert.assertTrue(utils.checkMinMax(card, 1));
		Assert.assertTrue(utils.checkMinMax(card, 2));
		Assert.assertTrue(utils.checkMinMax(card, 3));
		Assert.assertTrue(utils.checkMinMax(card, 4));
		
		Assert.assertEquals(false, utils.checkMinMax(card2, 0));
		Assert.assertEquals(false, utils.checkMinMax(card2, 1));
		Assert.assertEquals(false, utils.checkMinMax(card2, 2));
		Assert.assertEquals(false, utils.checkMinMax(card2, 3));
		Assert.assertEquals(false, utils.checkMinMax(card2, 4));
	}
	
	@Test
	public void checkColsMinMaxTest(){
		Assert.assertTrue(utils.checkColsMinMax(card));
		Assert.assertEquals(false, utils.checkColsMinMax(card2));
		Assert.assertEquals(false, utils.checkColsMinMax(card3));
		Assert.assertEquals(false, utils.checkColsMinMax(card4));
	}
	
	@Test
	public void checkRepeatedTest(){
		int[] valores={16,20,50,62,33,70}; 
		Assert.assertTrue(utils.checkRepeated(16,valores));
		Assert.assertTrue(utils.checkRepeated(20,valores));
		Assert.assertTrue(utils.checkRepeated(50,valores));
		Assert.assertTrue(utils.checkRepeated(62,valores));
		Assert.assertTrue(utils.checkRepeated(33,valores));
		Assert.assertTrue(utils.checkRepeated(70,valores));
		Assert.assertEquals(false, utils.checkRepeated(3,valores));
	}
	
	@Test
	public void checkArrayRepeatedTest(){
		int[] valores={16,20,50,62,33,70};
		Assert.assertTrue(utils.checkArrayRepeated(valores));
		int[] valores2={28,40,30,29,26,29};
		Assert.assertEquals(false, utils.checkArrayRepeated(valores2));
	}
	
	@Test
	public void checkPosColRepeatedTest(){
		Assert.assertTrue(utils.checkPosColRepeated(card, 0));
		Assert.assertTrue(utils.checkPosColRepeated(card, 1));
		Assert.assertTrue(utils.checkPosColRepeated(card, 2));
		Assert.assertTrue(utils.checkPosColRepeated(card, 3));
		Assert.assertTrue(utils.checkPosColRepeated(card, 4));
		Assert.assertEquals(false,utils.checkPosColRepeated(card5, 0));
		Assert.assertEquals(false,utils.checkPosColRepeated(card5, 1));
		Assert.assertEquals(false,utils.checkPosColRepeated(card5, 2));
		Assert.assertEquals(false,utils.checkPosColRepeated(card5, 3));
		Assert.assertEquals(false,utils.checkPosColRepeated(card5, 4));
	}
	
	@Test
	public void checkColsRepeatedTest(){
		Assert.assertTrue(utils.checkColsRepeated(card));
		Assert.assertTrue(utils.checkColsRepeated(card3));
		Assert.assertTrue(utils.checkColsRepeated(card2));
		Assert.assertEquals(false,utils.checkColsRepeated(card5));
		Assert.assertEquals(false,utils.checkColsRepeated(card6));
		Assert.assertEquals(false,utils.checkColsRepeated(card7));
	}
	
	@Test
	public void checkCardTest(){
		Assert.assertTrue(utils.checkCard(card));
		Assert.assertTrue(!utils.checkCard(card2));
		Assert.assertTrue(!utils.checkCard(card3));
		Assert.assertTrue(!utils.checkCard(card4));
		Assert.assertTrue(!utils.checkCard(card5));
		Assert.assertTrue(!utils.checkCard(card6));
		Assert.assertTrue(!utils.checkCard(card7));
		int[][] cardRight=new int[][] {{9,17,35,60,62},{8,28,41,48,68},{4,24,-1,53,70},{7,29,37,55,74},{11,19,33,50,73}};
		Assert.assertTrue(utils.checkCard(cardRight));
	}
	
	@Test
	public void checkArrayBall(){
		int[] valores=new int[] {4,1,3,2,7};
		int[] ball= new int[] {1,2,3,4,5,6,7};
		Assert.assertTrue(utils.checkArrayBall(valores, ball));
		int[] valores2=new int[] {4,2,3,1,8};
		Assert.assertTrue(!utils.checkArrayBall(valores2, ball));
	}
	
	@Test
	public void checkBingoTest(){
		//{{3,17,35,54,61},{8,28,41,48,68},{4,23,-1,52,70},{7,29,37,55,74},{11,19,33,50,73}};
		int[] ball= new int[] {3,17,35,54,61,8,28,41,48,68,4,23,52,70,7,29,37,55,74,11,19,33,50,73};
		Assert.assertTrue(utils.checkBingo(card,ball));
		ball= new int[] {35,17,3,61,54,8,28,41,48,68,4,23,72,52,70,7,29,37,55,74,11,19,50,73,33};
		Assert.assertTrue(utils.checkBingo(card,ball));
		ball= new int[] {35,17,3,61,54,8,28};
		Assert.assertTrue(!utils.checkBingo(card,ball));
		ball= new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
				27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,
				52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,6,68,69,71,72,73,74,75,76};
		Assert.assertTrue(!utils.checkBingo(card,ball));
	}
	
	@Test
	public void checkBallTest(){
		int[] ballsBefore={20,14,70,30,9,60,1,71};
		Assert.assertTrue(utils.checkBall(ballsBefore, 3));
		Assert.assertTrue(utils.checkBall(ballsBefore, 15));
		Assert.assertTrue(!utils.checkBall(ballsBefore, 60));
		Assert.assertTrue(!utils.checkBall(ballsBefore, 70));
	}
	
	@Test
	public void checkBingoCard(){
		BingoCard bingoCard= new BingoCard();
		bingoCard.escribirBingoCard();
		Assert.assertTrue(utils.checkCard(bingoCard.getCard()));
	}
	
	@Test
	public void checkBalls(){
		Balls balls=new Balls();
		for(int i=0;i<75;i++){
			Assert.assertTrue(utils.checkBall(balls.getAnteriores(), balls.createBall()));
		}
	}
	
}
