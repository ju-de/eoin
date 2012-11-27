package dmcigd.core.room;

import java.util.ArrayList;
import java.util.Iterator;
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
    //Object List Iterators
    private Iterator<SolidObject> solidObjectIt;
    private Iterator<Item> itemIt;
    private Iterator<SolidObject> projectileIt;
    private Iterator<Particle> particleIt;
    private Iterator<ParticleEmitter> emitterIt;

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

        projectileIt = projectiles.iterator();
        //Step all projectiles
        while (projectileIt.hasNext()) {
            SolidObject i = projectileIt.next();
            if (i.isDestroyed()) {
                projectileIt.remove();
            } else {
                i.step();
            }
        }

        solidObjectIt = solidObjects.iterator();
        //Step all solid objects and player
        while (solidObjectIt.hasNext()) {
            SolidObject i = solidObjectIt.next();
            if (i.isDestroyed()) {
                solidObjectIt.remove();
            } else {
                i.step();
            }
        }

        itemIt = items.iterator();
        //Step all items
        while (itemIt.hasNext()) {
            Item i = itemIt.next();
            if (i.isDestroyed()) {
                itemIt.remove();
            } else {
                i.step();
            }
        }


        particleIt = particles.iterator();
        // Step all particles
        while (particleIt.hasNext()) {
            Particle p = particleIt.next();
            if (p.isDestroyed()) {
                //System.out.println("killing particle");
                particleIt.remove();
            } else {
                p.step();
            }
        }

        emitterIt = emitters.iterator();
        // step all particle emitters
        while (emitterIt.hasNext()) {
            ParticleEmitter pe = emitterIt.next();
            if (pe.isDestroyed()) {
                //System.out.println("kill");
                emitterIt.remove();
                continue;
            }
            //System.out.println("emitter: " + pe.getX() + " " + pe.getY());
            pe.step();

        }

        //Step all regions
        for (Region i : regions) {
            i.step();
        }

    }
}
