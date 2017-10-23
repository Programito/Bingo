package com.finder.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.finder.main.Finder;

public class FinderTest {
	
	@Test
	public void finderTestNormalImplementation(){
		ArrayList<MockT> list= new ArrayList<>();
		list.add(new MockT("Name0","Surname0",1));
		list.add(new MockT("Name1","Surname1",3));
		list.add(new MockT("Name2","Surname2",4));
		list.add(new MockT("Name2","Surname3",4));

		Finder<MockT,String> finder = 
				new Finder<>(new ImpPatternFinderByName());
		ArrayList<MockT> results= finder.finder(list, "Name2");
		Assert.assertEquals(2,results.size());
	}
	
	
	@Test
	public void finderTestAnonymusWithReference(){
		ArrayList<MockT> list= new ArrayList<>();
		list.add(new MockT("Name0","Surname0",1));
		list.add(new MockT("Name1","Surname1",3));
		list.add(new MockT("Name2","Surname2",4));

		Finder<MockT,String> finder = 
				new Finder<>(anonymous);
		ArrayList<MockT> results= finder.finder(list, "Surname0");
		Assert.assertEquals(1,results.size());
	}
	
	@Test
	public void finderTestAnonymusInsitu(){
		ArrayList<MockT> list= new ArrayList<>();
		list.add(new MockT("Name0","Surname0",1));
		list.add(new MockT("Name1","Surname1",3));
		list.add(new MockT("Name2","Surname2",4));

		Finder<MockT,Integer> finder = new Finder<> 
			(new  Finder.PatternFinder<MockT, Integer>() {
					@Override
					public boolean hasPattern(MockT item, Integer reference) {
						return item.age>reference;
					}
				});
		ArrayList<MockT> results= finder.finder(list, 2);
		Assert.assertEquals(2,results.size());
	}
	
	
	
	public static class MockT{
		String name;
		String surname;
		int age;
		
		public MockT(String name,String surname,int age){
			super();
			this.name=name;
			this.surname=surname;
			this.age=age;
		}
		
	}
	
	/** Clase interna, Implmentacion normal, puede ser un fichero independiente*/
	public static class ImpPatternFinderByName implements 
					Finder.PatternFinder<MockT,String>{

		@Override
		public boolean hasPattern(MockT item, String reference) {
			//no utiliza get porque es para test y se han puesto protected
			return item.name.equals(reference);
		}
		
	}
	
	/**Implementacion anonima */
	Finder.PatternFinder<MockT, String> anonymous= 
			new Finder.PatternFinder<MockT,String>(){

		@Override
		public boolean hasPattern(MockT item, String reference) {
			return item.surname.equals(reference);
		}
	};

}
