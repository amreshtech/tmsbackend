package com.tms.tmsprod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tms.tmsprod.model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as user ORDER BY user.username";
		return (List<User>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User getUserById(String username) {
		return entityManager.find(User.class, username);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public boolean userExist(String username) {
		String hql = "FROM User as user WHERE user.username = ?";
		int count = entityManager.createQuery(hql).setParameter(1, username).getResultList().size();
		return count > 0 ?  true: false;
	}
}
