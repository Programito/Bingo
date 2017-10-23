package com.finder.main;

import java.util.ArrayList;

public class Finder<T,P> {
		public interface PatternFinder<T,P>{
			boolean hasPattern(T item,P reference);
		}
		
		final PatternFinder<T,P> patternCheker;
		/**
		 * Constructor
		 * @param patternCheker patterFinder
		 */
		public Finder(PatternFinder<T,P> patternCheker){
			this.patternCheker= patternCheker;
		}
		
		public ArrayList<T> finder(ArrayList<T> list,P reference){
			ArrayList<T> result= new ArrayList<T>();
			
			for(int i=0;i<list.size();i++){
				T item = list.get(i);
				if(patternCheker.hasPattern(item,reference)){
					result.add(item);
				}
			}
			return result;
		}
		
		
}
