package com.employee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.employee.model.RegisterUser;

@Repository
public class UserRepositoryImpl implements UserRepository {
	 @PersistenceContext
	    private EntityManager entityManager;
	@Override
	@Transactional
	public void persist(final RegisterUser registerUser) {
		entityManager.persist(registerUser);
	}
	@Override
	public List<RegisterUser> getAllUsers()
		
		{
	        return entityManager.createQuery("select registerUser from RegisterUser registerUser where registerUser.username!='admin' ").getResultList();
	    }
	
	 @Override
	 @Transactional
	    public void updateUser(RegisterUser registerUser)
	    {
	        entityManager.merge(registerUser);
	    }
	 @Override
	  @Transactional
	    public void deleteUser(int id)
	    {
		 RegisterUser registerUser = entityManager.find(RegisterUser.class,id);
	        entityManager.remove(registerUser);
	        
	    }
	 
	 
		@Override
		 @Transactional
		public int getUserCount(String username) {
			
			Query query = entityManager.createQuery("select registerUser from RegisterUser registerUser WHERE LOWER(registerUser.username) = ?1");

			query.setParameter(1, username.toLowerCase());
			return query.getResultList().size();
		
			
		}
		
		@Override
		 @Transactional
		public List<RegisterUser> getUser(String username,String password) {
			
			Query query = entityManager.createQuery("select registerUser from RegisterUser registerUser WHERE LOWER(registerUser.username) = ?1 and LOWER(registerUser.password)= ?2 ");

			query.setParameter(1, username.toLowerCase());
			query.setParameter(2, password.toLowerCase());
			return query.getResultList();
		
			
		}

		@Override
		public List<RegisterUser> getUser(int userId)
			
			{
			Query query= entityManager.createQuery
		        		("select registerUser from RegisterUser registerUser where registerUser.id=?1 ");
		        		query.setParameter(1, userId);
		        		return query.getResultList();
		    }
		
		
		
}
	 
