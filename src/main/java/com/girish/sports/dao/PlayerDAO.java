package com.girish.sports.dao;

import java.util.List;

import com.girish.sports.entities.Player;
/**
 * @author giri pilgaonkar 
 *
 */
public interface PlayerDAO {
	 /**
     * Used to Create the Player Information
     * @param Player
     * @return {@link Player}
     */
    public Player createPlayer(Player Player);
    
    /**
     * Getting the Player Information using Id
     * @param id
     * @return {@link Player}
     */
    public Player getPlayer(int id);
    
    /**
     * Used to Update the Player Information
     * @param Player
     * @return {@link Player}
     */
    
    public Player updatePlayer(Player Player);
    
    /**
     * Deleting the Player Information using Id
     * @param id
     */
    public void deletePlayer(int id);
    
    /**
     * Getting the All Players information
     * @return
     */
    public List<Player> getAllPlayers();
}
