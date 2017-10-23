package com.tallerthree.test;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.tallerthree.main.IntGeometry;
import com.tallerthree.main.ListExtGeometry;
import com.tallerthree.main.ListGeometry;


public class ListGeometryTest {
	
	
	
	@Test
	public void testSortByArea(){
		
		ListExtGeometry listGeometry = new ListExtGeometry();  
		IntGeometry[] expected = new IntGeometry[]{
				new Mock(4), 
				new Mock(3), 
				new Mock(2), 
				new Mock(1), 
			}; 
	
	
		listGeometry.add(expected[0]);  //4
		listGeometry.add(expected[2]);  //3
		listGeometry.add(expected[3]);  //1
		listGeometry.add(expected[1]);  //2
		
		ArrayList<IntGeometry> listResult = listGeometry.sortByArea();
		
		Assert.assertArrayEquals(expected,listResult.toArray());
		
	}
	
	
	
	@Test
	public void testSortBySide(){
		
		ListExtGeometry listGeometry = new ListExtGeometry(); 
		IntGeometry[] expected = new IntGeometry[]{
				new Mock(4), 
				new Mock(3), 
				new Mock(2), 
				new Mock(1), 
			}; 
	
	
		listGeometry.add(expected[3]);  //4
		listGeometry.add(expected[2]);  //3
		listGeometry.add(expected[0]);  //1
		listGeometry.add(expected[1]);  //2
		
		ArrayList<IntGeometry> listResult = listGeometry.sortBySize();
		
		Assert.assertArrayEquals(expected,listResult.toArray());
		
	}
	
	
	@Test
	public void testSortByPerimeter(){
		
		ListExtGeometry listGeometry = new ListExtGeometry(); 
		IntGeometry[] expected = new IntGeometry[]{
				new Mock(4), 
				new Mock(3), 
				new Mock(2), 
				new Mock(1), 
			}; 
	
	
		listGeometry.add(expected[3]);  //4
		listGeometry.add(expected[2]);  //3
		listGeometry.add(expected[0]);  //1
		listGeometry.add(expected[1]);  //2
		
		ArrayList<IntGeometry> listResult = listGeometry.sortByPerimeter();
		
		Assert.assertArrayEquals(expected,listResult.toArray());
		
		
	}
	
	
	
	public class Mock implements IntGeometry{

		float value; 
		
		public Mock(float value){
			this.value = value; 
		}
		
		@Override
		public float computeArea() {
			return value;
		}

		@Override
		public float computePerimeter() {
			return value;
		}

		@Override
		public int getSide() {
			return (int) value;
		}
		
	}
		
}
	

