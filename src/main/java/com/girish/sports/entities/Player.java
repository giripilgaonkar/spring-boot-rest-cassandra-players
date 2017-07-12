package com.girish.sports.entities;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
/**
 * @author giri pilgaonkar 
 *
 */
@Table("players")
public class Player {

	@PrimaryKey("pid")
	private int pid;    

	@Column("firstname")
	private String firstname;  

	@Column("lastname")
	private String lastname;

	public Player(int pid, String fname, String lname){
		super();
		this.pid = pid;
		this.firstname=fname;
		this.lastname=lname;
	}
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
    public String toString() {
		return "PID#: "+this.pid+" Name: "+this.firstname+" "+this.lastname;
	}

}
