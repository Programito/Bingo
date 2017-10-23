package com.tallerthree.main;

import java.util.ArrayList;
import java.util.Comparator;


public class ListExtGeometry extends ArrayList<IntGeometry>  {
	private static final long serialVersionUID = 174878154L;



	public ArrayList<IntGeometry> sortByPerimeter(){    	
    	ArrayList<IntGeometry> tem=new ArrayList<>(this);
		tem.sort(new Comparator<IntGeometry>(){
			@Override
			public int compare(IntGeometry o1,IntGeometry o2){
				int valor=o1.computePerimeter()<o2.computePerimeter()?1:-1;	
				return o1.computePerimeter()==o2.computePerimeter()?0:valor;
			}
		});
		return tem;
    }
    
    public ArrayList<IntGeometry> sortBySize(){    	
    	ArrayList<IntGeometry> tem=new ArrayList<>(this);
		tem.sort(new Comparator<IntGeometry>(){
			@Override
			public int compare(IntGeometry o1,IntGeometry o2){
				int valor=o1.getSide()<o2.getSide()?1:-1;	
				return o1.getSide()==o2.getSide()?0:valor;
			}
		});
		return tem;
    }


	
	public ArrayList<IntGeometry> sortByArea(){
		ArrayList<IntGeometry> tem=new ArrayList<>(this);
		tem.sort(new Comparator<IntGeometry>(){
			@Override
			public int compare(IntGeometry o1,IntGeometry o2){
				int valor=o1.computeArea()<o2.computeArea()?1:-1;	
				return o1.computeArea()==o2.computeArea()?0:valor;
			}
		});
		
		return tem;
	}
    
	
}