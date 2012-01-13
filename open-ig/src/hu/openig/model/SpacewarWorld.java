/*
 * Copyright 2008-2012, David Karnok 
 * The file is part of the Open Imperium Galactica project.
 * 
 * The code should be distributed under the LGPL license.
 * See http://www.gnu.org/licenses/lgpl.html for details.
 */

package hu.openig.model;

import java.util.List;

/**
 * Interface to tell things about the spacewar state to AI players and the Scripting.
 * @author akarnokd, 2011.12.13.
 */
public interface SpacewarWorld {
	/**
	 * @return the battle object
	 */
	BattleInfo battle();
	/** @return The list of all structures. */
	List<SpacewarStructure> structures();
	/**
	 * Returns the list of structures owned by the given player.
	 * @param owner the player
	 * @return the list of structures
	 */
	List<SpacewarStructure> structures(Player owner);
	/**
	 * Returns the list of enemies to the structure.
	 * @param s the structure 
	 * @return the list of the enemies of the structure. 
	 */
	List<SpacewarStructure> enemiesOf(SpacewarStructure s);
	/** 
	 * Returns the list of enemies in range of the structure.
	 * @param s the structure
	 * @return the list of the enemies in range of the structure. 
	 */
	List<SpacewarStructure> enemiesInRange(SpacewarStructure s);
	/**
	 * Returns a random element from the list.
	 * @param <T> the element type
	 * @param list the list of elements
	 * @return the selected element
	 */
	<T> T random(List<T> list);
	/**
	 * Set the structure to move outside of the screen as an indication of fleeing.
	 * @param s the target structure
	 */
	void flee(SpacewarStructure s);
	/**
	 * @return -1 if a forward move would decrease the X coordinate, +1 if a forward move would
	 * increase the X coordinate
	 */
	int facing();
	/**
	 * Move the specified unit to the given location.
	 * @param s the ship
	 * @param x the target location
	 * @param y the target location
	 */
	void move(SpacewarStructure s, double x, double y);
	/**
	 * Command the specified unit to attack the other unit.
	 * @param s the ship
	 * @param target the target structure
	 * @param mode the attack mode, e.g., beam, rocket, etc.
	 */
	void attack(SpacewarStructure s, SpacewarStructure target, BattleProjectile.Mode mode);
	/**
	 * Stop the given unit.
	 * <p>Disables guard mode as well.</p>
	 * @param s the unit
	 */
	void stop(SpacewarStructure s);
	/**
	 * Switch to guard mode.
	 * @param s the unit
	 */
	void guard(SpacewarStructure s);
}
