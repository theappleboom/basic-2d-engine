package coreEngine;

import java.util.Collection;

public abstract class GameObject {
	private Boolean isCreated;
	private Collection<HitBox> hitBoxes;
	
	/**
	 * This method is the primary initializing method that must be called every time a GameObject is created.
	 * 
	 * @return
	 */
	public GameObject create() {
		
		//Flags that this object has been through the creation process
		isCreated = true;
		
		return this;
	}
	
	/**
	 * This method checks if the current object is colliding with another object.
	 * 
	 * @param otherObject
	 * @return collided
	 */
	public Boolean collisionCheck(GameObject otherObject) {
		Boolean collided;
		Collection<HitBox> otherHitBoxes;
		
		otherHitBoxes = otherObject.getHitBoxes();
		
		//initialize collided in case otherObject has no HitBox
		collided = false;
		
		//check if each HitBox collided
		for(HitBox h1: hitBoxes) {
			for(HitBox h2: otherHitBoxes) {
				
				//circle and circle interaction
				if(!h1.getIsSquare() && !h2.getIsSquare()) {
					//check distance
					collided = true;
				}
				else {
					collided = false;
				}
			}
		}
		
		return collided;
	}
	
	//constructor
	public GameObject() {
		
		//Flags that this object has not yet been created
		isCreated = false;
	}

	//getters and setters
	public Collection<HitBox> getHitBoxes() {
		return hitBoxes;
	}

	public void setHitBoxes(Collection<HitBox> hitBoxes) {
		this.hitBoxes = hitBoxes;
	}
}
