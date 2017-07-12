package com.girish.sports.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.girish.sports.dao.PlayerDAO;
import com.girish.sports.entities.Player;
import com.girish.sports.util.CassandraTemplate;

/**
 * CRUD DAO impl class
 * @author giri pilgaokar 
 *
 */
public class PlayerDAOImpl implements PlayerDAO {

	@Autowired
	private CassandraTemplate CassandraTemplate;

	@Override
	public Player createPlayer(Player Player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player updatePlayer(Player Player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePlayer(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

}
