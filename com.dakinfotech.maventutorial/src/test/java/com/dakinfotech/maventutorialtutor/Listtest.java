package com.dakinfotech.maventutorialtutor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

public class Listtest {
	@Test
	public void listfunc()
	{
		/*ADD in Array list*/
		List<String> sone=new ArrayList<String>();
		sone.add("Arun Kumar");
		sone.add("Deivakumar");
		sone.add("TCS");
		sone.add("Redhills");
		sone.add("Chennai");
		sone.add("TN");
		System.out.println(sone);
		
		/*ADD in linked list*/
		List<String> listStrings = new LinkedList<String>();
		listStrings.add("Five");
		listStrings.add("Six");
		listStrings.add("Seven");
		listStrings.add("Eight");
		System.out.println(listStrings);
		
		/*Copy value from one linked list to other*/
		List<String> listStrings1 = new LinkedList<String>();
		listStrings1.addAll(listStrings);
		System.out.println(listStrings1);
		
		/*COPY*/
		String copy1=listStrings.get(3);
		System.out.println(copy1);
		
		/*REPLACE*/
		sone.set(2, "ILAMUKIL");
		System.out.println(sone);
		
		/*REMOVE*/
		sone.remove(5);
		
		/*DELETE THE ENTIRE LIST*/
		listStrings1.clear();
		System.out.println(listStrings1);
		
		/*WRITE IN EMPTY LIST USING ITERATOR*/
		Iterator<String> iterator = listStrings.iterator();
		while (iterator.hasNext()) {
			String i=iterator.next();
			System.out.println(i);
			listStrings1.add(i);			
		}
		
		System.out.println(listStrings1);
		System.out.println(sone);
		/*CONTAINS*/
		if(sone.contains("Arun Kumar"))
		{
			System.out.println("OK");
		}
		else System.out.println("NOTOK");
		
		/*PRINT THE INDEX*/
		int ind1=sone.indexOf("Arun Kumar");
		System.out.println(ind1);
		
		/*sub list*/
		System.out.println(sone.subList(1, 3));
		
		/*other functions are sort, copy, shuffle, reverse*/
				
	}
	

}
