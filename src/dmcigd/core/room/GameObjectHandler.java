package dmcigd.core.room;

import java.util.ArrayList;
import java.util.LinkedList;

import dmcigd.core.objects.VisibleObject;
import dmcigd.core.objects.interfaces.*;
import dmcigd.core.objects.particles.Particle;
import dmcigd.core.objects.particles.ParticleEmitter;

public abstract class GameObjectHandler {

    //Initializes Linked Lists
    private ArrayList<SolidObject> solidObjects = new ArrayList<SolidObject>();
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<SolidObject> projectiles = new ArrayList<SolidObject>();
    private ArrayList<Region> regions = new ArrayList<Region>();
    private ArrayList<Particle> particles = new ArrayList<Particle>();
    private LinkedList<String> imageResources = new LinkedList<String>();
    private ArrayList<VisibleObject> backgroundObjects = new ArrayList<VisibleObject>();
    private ArrayList<VisibleObject> foregroundObjects = new ArrayList<VisibleObject>();
    private ArrayList<ParticleEmitter> emitters = new ArrayList<ParticleEmitter>();

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

    public ArrayList<Particle> getParticles() {
        return particles;
    }

    public ArrayList<VisibleObject> getBackgroundObjects() {
        return backgroundObjects;
    }

    public ArrayList<VisibleObject> getForegroundObjects() {
        return foregroundObjects;
    }

    public LinkedList<String> getImageResources() {
        return imageResources;
    }

    //Public Setters
    public void addSolidObject(SolidObject solidObject) {
        solidObjects.add(solidObject);
        addImageResource(solidObject.getImagePath());
    }

    public void addItem(Item item) {
        items.add(item);
        addImageResource(item.getImagePath());
    }

    public void addProjectile(SolidObject projectile) {
        projectiles.add(projectile);
        addImageResource(projectile.getImagePath());
    }

    public void addRegion(Region region) {
        regions.add(region);
        addImageResource(region.getImagePath());
    }

    public void addParticle(Particle particle) {
        particles.add(particle);
        addImageResource(particle.getImagePath());
    }

    public void addBackgroundObject(VisibleObject backgroundObject) {
        backgroundObjects.add(backgroundObject);
        addImageResource(backgroundObject.getImagePath());
    }

    public void addForegroundObject(VisibleObject foregroundObject) {
        foregroundObjects.add(foregroundObject);
        addImageResource(foregroundObject.getImagePath());
    }

    public void addImageResource(String imagePath) {
        imageResources.add(imagePath);
    }

    public void addParticleEmitter(ParticleEmitter pe) {
        emitters.add(pe);
        pe.room = this;
    }

    public abstract void initializeRoom();

    public void stepGameObjects() {

        //Step all projectiles
        for(int i = 0; i < projectiles.size(); i++) {
            if (projectiles.get(i).isDestroyed()) {
            	projectiles.remove(i);
            } else {
            	projectiles.get(i).step();
            }
        }

        //Step all solid objects
        for(int i = 0; i < solidObjects.size(); i++) {
            if (solidObjects.get(i).isDestroyed()) {
                solidObjects.remove(i);
            } else {
            	solidObjects.get(i).step();
            }
        }

        //Step all items
        for(int i = 0; i < items.size(); i++) {
            if (items.get(i).isDestroyed()) {
                items.remove(i);
            } else {
            	items.get(i).step();
            }
        }


        // Step all particles
        for(int i = 0; i < particles.size(); i++) {
            if (particles.get(i).isDestroyed()) {
                particles.remove(i);
            } else {
            	particles.get(i).step();
            }
        }

        // step all particle emitters
        for(int i = 0; i < emitters.size(); i++) {
            if (emitters.get(i).isDestroyed()) {
                emitters.remove(i);
            } else {
            	emitters.get(i).step();
            }
        }

        //Step all regions
        for (Region i : regions) {
            i.step();
        }

    }
}
