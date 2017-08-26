package com.tms.tmsprod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tms.tmsprod.model.Task;

@Transactional
@Repository
public class TaskDaoImpl implements TaskDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getAllTasks() {
		return (List<Task>)entityManager.createQuery("from Task").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getAssignedTo(String user) {
		String hql = "select t from Task t left join t.assignedTo u where u.username = ?";
		return (List<Task>)entityManager.createQuery(hql).setParameter(1, user).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getAssignedBy(String user) {
		String hql = "select t from Task t left join t.assignedBy u where u.username = ?";
		return (List<Task>)entityManager.createQuery(hql).setParameter(1, user).getResultList();
	}

	@Override
	public Task getTaskById(Integer id) {
		return entityManager.find(Task.class, id);
	}

	@Override
	public void addTask(Task task) {
		entityManager.persist(task);
	}

	@Override
	public boolean taskExists(Integer id) {
		String hql = "FROM Task as task WHERE task.taskid = ?";
		int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
		return count > 0 ?  true: false;
	}
}
