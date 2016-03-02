package com.k;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;


public class Utils {

	static ArrayList<BigInteger> fillArrayFromTxt(String filepath){
		try{	
			ArrayList<BigInteger> list = new ArrayList<BigInteger>();
			File file = new File(filepath);	
			if(!file.exists()){
				file.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine())!=null){
				list.add(new BigInteger(line));
			}
			reader.close();
			return list;
		}catch(IOException e){
			e.printStackTrace();
		}
		return new ArrayList<BigInteger>();
	}
	
	static void appendTxtFromArray(String text, String filename){
		try{		
			File file = new File(filename);	
			if(!file.exists()){
				file.createNewFile();
			}
			PrintWriter out = new PrintWriter(
							  new BufferedWriter(
							  new FileWriter(file, true)));
			out.println(text);
			out.close();
			System.out.println("Done");					
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
}
