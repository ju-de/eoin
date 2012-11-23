/*
 * 
 * 
 */
package dmcigd.core.objects;

import dmcigd.core.enums.CollisionType;
import dmcigd.core.objects.interfaces.SolidObject;

/**
 * This Physics handler is part of Filip's core refactor -- it replaces the
 * "Entity extends ObjectCollider and ObjectCollision and so on" with "Entity
 * object contains PhysicsHandler object which handles collision constraints,
 * moving with platforms, etc".
 *
 * Currently, the refactor only moves the collision code from entity to
 * entity.physicsHandler -- to the outside world, barely anything has changed.
 *
 *
 * @author Filip
 */
public class PhysicsHandler extends BlockMapCollider {

    private Entity entity;

    public void setEntity(Entity e) {
        entity = e;
    }

    public Entity getEntity() {
        return entity;
    }
    
    //Strictly handles collisionType, see restObject() for handling RestableObjects
    @Override
    void rest(CollisionType collisionType) {

        //Determine entity states based on resting block
        switch (collisionType) {

            case DESTROY:
                isDestroyed = true;
                break;

            case KILL:
                isDead = true;
            //Falls through so death blocks are treated like solid blocks

            //On ground
            case PLATFORM:
            case SOLID:
            case SOLIDLADDER:
                hitGround = true;
                isFalling = false;
                break;

            //Fall through
            default:
                break;
        }

    }

    @Override
    void pushObject(SolidObject object, int v) {
        object.onPush(entity, v);
    }

    @Override
    void restObject() {
        restingBlock = restingBlockCheck;
        restingBlock.onRest(entity);
    }

    @Override
    void unrestObject() {

        restingBlock.onUnrest(entity);
        restingBlock = null;
    }
}
