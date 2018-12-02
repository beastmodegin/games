package com.fdmgroup.game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.System.Logger;

import com.fdmgroup.serialization.game.Board;

import jdk.incubator.http.internal.common.Log;

public class client {

	public static void main(String[] args) throws InterruptedException, IOException {

		wizard w1=new wizard("firzen");
		wizard w2=new wizard("julian");
		w1.setHealthPoints(100);
		w2.setHealthPoints(100);
		
		Board board=new Board();
	/*	while (w1.getHealthPoints()>0||w2.getHealthPoints()>0) {

		}*/
		board.attack(w1, w2);
	//	Thread.sleep(1000);
		board.loseHealthPoint(w2);
	//	Thread.sleep(1000);
		board.attack(w2, w1);
	//	Thread.sleep(1000);
		board.defend(w1, w2);
		
		System.out.println("Number of healthpacks left: "+w2.getBpack().getNumPacks());
	
		w2.usePots();
		
		System.out.println("Number of healthpacks left: "+w2.getBpack().getNumPacks());
		System.out.println(w2.toString());
		
		ObjectOutputStream oos=null;
		try {
			FileOutputStream fos=new FileOutputStream("game.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(w1);
			oos.writeObject(w2);
		} catch (IOException e) {
			Log.logError("Serialization failed!", e);
			
		}
		finally {
			oos.close();
		}
	}
	
	

}
