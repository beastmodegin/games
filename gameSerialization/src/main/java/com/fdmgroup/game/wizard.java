package com.fdmgroup.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.fdmgroup.serialization.game.Backpack;
import com.fdmgroup.serialization.game.HealthPack;
import com.fdmgroup.serialization.game.Player;

public class wizard extends Player implements Serializable,shields,powers{

	private static final long serialVersionUID = -7434092343836281477L;

	Backpack bpack=new Backpack();
	
	public Backpack getBpack() {
		return bpack;
	}

	
	public wizard() {
		
		super();
		
		bpack.addHealthPack(new HealthPack(50));
		bpack.addHealthPack(new HealthPack(50));

	}
	
	public wizard(String name) {
		
		super();
		
		bpack.addHealthPack(new HealthPack(50));
		bpack.addHealthPack(new HealthPack(50));

		this.setName(name);
	
	}
	
	

	public void usePots() {
		
		int maxHP=100;
		if (bpack.getNumPacks()==0) {
			System.out.println("No more Healthpack!!");
		}
		
		else {
			if (this.getHealthPoints()<maxHP) {
				
				System.out.println(this.getName()+" used a health pack!");
				HealthPack hpack=bpack.useHealthPack();
				int currentHP=this.getHealthPoints();
				this.setHealthPoints(currentHP+hpack.getHealthPoints());
				if(this.getHealthPoints()>maxHP)
					this.setHealthPoints(100);
			}
			
			else {
				System.out.println("Max HP!!");
			}

		}

		
	}
		
	
	public void writeObject(ObjectOutputStream os) throws IOException{
		
		os.writeObject(this.getName());
		os.writeInt(this.getHealthPoints());
		os.writeObject(this.getBpack());;
	}
	
	public void readObject(ObjectInputStream is) throws IOException,ClassNotFoundException, IOException {
		
		this.setName((String) is.readObject());
		this.setHealthPoints(is.readInt());
		
	}

	
		
	



	
}
