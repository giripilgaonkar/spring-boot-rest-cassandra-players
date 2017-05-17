package com.girish.sports.entities;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("players")
public class Players {
	@PrimaryKey("pid")
    private long pid;    
    
    @Column("firstname")
    private String firstname;  
    
    @Column("lastname")
    private String lastname;  
}
