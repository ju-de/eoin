package dmcigd.core.objects;

import dmcigd.core.enums.*;
import dmcigd.core.objects.interfaces.*;

import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class ObjectCollider extends MovingObject {

    private ArrayList<SolidObject> solidObjects;
    public RestableObject restingBlock, restingBlockCheck;

    //Public setters
    public void setSolidObjects(ArrayList<SolidObject> solidObjects) {
        this.solidObjects = solidObjects;
    }

    abstract void rest(CollisionType collisionType);

    abstract void pushObject(SolidObject object, int v);

    abstract void restObject();

    abstract void unrestObject();

    public boolean objectsCollide(Rectangle boundingBox, SolidObject object) {

        //Checks if objects overlap
        //And that player collided into object, object was not formed over player
        //Actions that take place when an object forms over the player should be handled
        //By the object itself, not in a collision check

        if (boundingBox.intersects(object.getBounds()) && (restingBlock == object || !getBounds().intersects(object.getBounds()))) {
            return true;
        } else {
            return false;
        }
    }

    public void checkSolidObjectCollisionDown(int v) {

        boolean obstructMovement = false;

        //Get bounding box of destination
        //v+1 is necessary to deal with resting objects
        Rectangle boundingBox = getBounds(0, v + 1);

        //Loop through all solid objects
        for (SolidObject i : solidObjects) {

            //Check for collision
            if (objectsCollide(boundingBox, i)) {
                switch (i.getCollisionType()) {
                    case PLATFORM:
                    case SOLID:
                        restingBlockCheck = (RestableObject) i;
                        setY(i.getY() - getHeight());
                        setVY(0);
                        obstructMovement = true;
                    default:
                        break;
                }
            }
        }

        if (!obstructMovement) {
            //Advance normally
            addY(v);
        }
    }

    public void checkSolidObjectCollisionUp(int v) {

        boolean obstructMovement = false;

        //Get bounding box of destination
        //v+1 is necessary to deal with resting objects (while being pushed up)
        Rectangle boundingBox = getBounds(0, v + 1);

        //Loop through all solid objects
        for (SolidObject i : solidObjects) {

            //Check for collision
            if (objectsCollide(boundingBox, i)) {
                if (restingBlock == i) {
                    //Check if object is being pushed up by resting block
                    restingBlockCheck = (RestableObject) i;
                } else {
                    switch (i.getCollisionType()) {
                        case SOLID:
                            //Hit ceiling
                            setY(i.getY() + i.getHeight());
                            obstructMovement = true;
                        default:
                            break;
                    }
                }
            }
        }

        if (!obstructMovement) {
            //Advance normally
            addY(v);
        }
    }

    public void checkSolidObjectCollisionX(int v) {

        boolean obstructMovement = false;

        //Get bounding box of destination
        Rectangle boundingBox = getBounds(v, 0);

        //Loop through all solid objects
        for (SolidObject i : solidObjects) {

            //Check for collision
            if (objectsCollide(boundingBox, i)) {

                pushObject(i, v);

                //Determine collision type
                switch (i.getCollisionType()) {
                    case SOLID:
                        if (v > 0) {
                            //Push against left edge (if moving right)
                            setX(i.getX() - getWidth());
                        } else {
                            //Push against right edge (if moving left)
                            setX(i.getX() + i.getWidth());
                        }
                        obstructMovement = true;
                        break;
                    default:
                        break;
                }
            }
        }

        if (!obstructMovement) {
            //Advance normally
            addX(v);
        }
    }
}
