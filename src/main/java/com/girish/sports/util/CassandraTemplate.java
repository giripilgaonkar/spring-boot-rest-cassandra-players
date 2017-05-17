package com.girish.sports.util;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

/**
 * Utility class for handling all CRUD Operations.
 * @author Giri Pilgaonkar
 */
@Repository
public class CassandraTemplate {

	@Autowired
	private CassandraOperations cassandraTemplate;

	/** CassandraTemplate Default constructor*/
	public CassandraTemplate() {
		System.out.println("CassandraTemplate()");
	}

	/**
	 * Creating the entity.
	 * @param entity
	 * @return {@link Object}
	 */
	public <T> T create(T entity) {
		return cassandraTemplate.insert(entity);
	}

	/**
	 * Creating the list of entities.
	 * @param entity
	 */
	public <T> void createList(List<T> entities) {
		/*
		 * as of 1.5. This method accepts a List of entities and inserts all entities in a batch. 
		 * That's not transparent to users and a Cassandra anti-pattern if used with multiple partition keys. 
		 * Please use batchOps() for if your intent is batching or issue multiple calls to insert(Object) 
		 * as that's the preferred approach. This method will be removed in Version 2.0.
		 * 
		 */
		cassandraTemplate.insert(entities);     
	}

	/**
	 * Updating the entity.
	 * @param entity
	 * @param claz
	 * @return T
	 */
	public <T> T update(T entity) {     
		return (T) cassandraTemplate.update(entity);
	}

	/**
	 * Updating the list of entities.
	 * @param entity
	 * @param claz
	 * @return T
	 */
	public <T> void updateList(List<T> entities) {  
		/**
		 * Deprecated.  as of 1.5. This method accepts a List of entities and updates all entities in a batch. 
		 * That's not transparent to users and a Cassandra anti-pattern if used with multiple partition keys. 
		 * Please use batchOps() for if your intent is batching or issue multiple calls to update(Object) as that's the preferred approach. 
		 * This method will be removed in Version 2.0.
		 */
		cassandraTemplate.update(entities);
	}

	/**
	 * Updating the entity.
	 * @param entity
	 * @param claz
	 * @return T
	 */
	public <T> T update(T entity, Class<T> claz) {      
		return (T) cassandraTemplate.update(entity);
	}

	/**
	 * Get the Entity using Id.
	 * @param id
	 * @param claz
	 * @return T
	 */
	public <T> T findById(Object id, Class<T> claz) {
		return cassandraTemplate.selectOneById(claz, id);
	}

	/**
	 * Delete the Entity using Id.
	 * @param id
	 * @param claz
	 */
	public <T> void deleteById(Object id, Class<T> claz) {
		cassandraTemplate.deleteById(claz, id);
	}

	/**
	 * Delete the Entity using object.
	 * @param entity    
	 */
	public void delete(Object entity) {
		cassandraTemplate.delete(entity);
	}

	/**
	 * Deleting the list of entities 
	 * @param entities
	 */
	public <T> void delete(List<T> entities) {
		/*
		 * Deprecated.  as of 1.5. This method accepts a List of entities and deletes all entities in a batch. 
		 * That's not transparent to users and a Cassandra anti-pattern if used with multiple partition keys. Please use batchOps() for if your intent is batching or issue multiple calls to delete(Object) as that's the preferred approach. 
		 * This method will be removed in Version 2.0.
		 */
		cassandraTemplate.delete(entities);
	}

	/**
	 * Deleting the all entities.   
	 * @param claz
	 */
	public <T> void deleteAll(Class<T> claz) {
		cassandraTemplate.deleteAll(claz);
	}

	/**
	 * Getting the all entities.
	 * @param claz
	 * @return List of entities
	 */
	public <T> List<T> findAll(Class<T> claz) {
		/**
		 * Deprecated.  Calling this method could result in OutOfMemoryError, as this is a brute force selection.
		 */
		return (List<T>) cassandraTemplate.selectAll(claz);
	}

	/**
	 * Getting the all entity values using specific id's data.
	 * @param ids
	 * @param claz
	 * @return
	 */
	public <T> List<T> findAll(List<Object> ids, Class<T> claz) {
		return cassandraTemplate.selectBySimpleIds(claz, ids);
	}

	/**
	 * Getting the count of records.
	 * @param claz
	 * @return the count value.
	 */
	public <T> void truncate(Class<T> claz) {
		cassandraTemplate.truncate(claz.getName());
	}

	/**
	 * Getting the count of records.
	 * @param claz
	 * @return the count value.
	 */
	public <T> long getCount(Class<T> claz) {
		return cassandraTemplate.count(claz);
	}   


	/**
	 * Checking the object exists or not.
	 * @param id
	 * @param claz
	 * @return true if the object exists in the database otherwise it will return false.
	 */
	public <T> boolean exists(Object id, Class<T> claz) {
		return cassandraTemplate.exists(claz, id);
	}

}