package com.bingo.main;

import java.util.ArrayList;

public class Bingo {

	public static void main(String[] args) {
		ArrayList<Integer> b= new ArrayList();
		ArrayList<Integer> i= new ArrayList();
		ArrayList<Integer> n= new ArrayList();
		ArrayList<Integer> g= new ArrayList();
		ArrayList<Integer> o= new ArrayList();
		
		for(int j=1;j<16;j++){
			b.add(j);
			i.add(j+15);
			n.add(j+(15*2));
			g.add(j+(15*3));
			o.add(j+(15*4));
		}
	}

}
