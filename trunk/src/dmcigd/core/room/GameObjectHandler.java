package dmcigd.core.room;

import java.util.ArrayList;
import java.util.Iterator;

import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.particles.Particle;
import java.util.LinkedList;

abstract class GameObjectHandler {
	
	//Initializes Linked Lists
	private ArrayList<SolidObject> solidObjects = new ArrayList<SolidObject>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<SolidObject> projectiles = new ArrayList<SolidObject>();
	private ArrayList<Region> regions = new ArrayList<Region>();
	
        private ArrayList<Particle> particles = new ArrayList<Particle>();
	
	//Object List Iterators
	private Iterator<SolidObject> solidObjectIt;
	private Iterator<Item> itemIt;
	private Iterator<SolidObject> projectileIt;
        private Iterator<Particle> particleIt;
	
	//Public Getters
	public ArrayList<SolidObject> getSolidObjects() {
		return solidObjects;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public ArrayList<SolidObject> getProjectiles() {
		return projectiles;
	}
	public ArrayList<Region> getRegions() {
		return regions;
	}
        public ArrayList<Particle> getParticles(){
            return particles;
        }
	
	//Public Setters
	public void addSolidObject(SolidObject solidObject) {
		solidObjects.add(solidObject);
	}
	public void addItem(Item item) {
		items.add(item);
	}
	public void addProjectile(SolidObject projectile) {
		projectiles.add(projectile);
	}
	public void addRegion(Region region) {
		regions.add(region);
	}
        public void addParticle(Particle particle){
            particles.add(particle);
        }
        
	public abstract void initializeSolidObjects();
	public abstract void initializeNonsolidObjects();
	
	//Iterators
	public void resetIterators() {
		solidObjectIt = solidObjects.iterator();
		itemIt = items.iterator();
		projectileIt = projectiles.iterator();
                particleIt = particles.iterator();
	}
	
	public void stepGameObjects() {
		
		resetIterators();
		
		//Step all projectiles
		while(projectileIt.hasNext()) {
			SolidObject i = projectileIt.next();
			if(i.isDestroyed()) {
				projectileIt.remove();
			} else {
				i.step();
			}
		}
		
		//Step all solid objects and player
		while(solidObjectIt.hasNext()) {
			SolidObject i = solidObjectIt.next();
			if(i.isDestroyed()) {
				solidObjectIt.remove();
			} else {
				i.step();
			}
		}
		
		//Step all items
		while(itemIt.hasNext()) {
			Item i = itemIt.next();
			if(i.isDestroyed()) {
				itemIt.remove();
			} else {
				i.step();
			}
		}
                
                // Step all particles
                while(particleIt.hasNext()) {
			Particle p = particleIt.next();
			if(p.isDestroyed()) {
				particleIt.remove();
			} else {
				p.step();
			}
		}
		
		//Step all regions
		for (Region i : regions) {
			i.step();
		}
		
	}
}
