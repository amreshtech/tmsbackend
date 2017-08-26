package com.tms.tmsprod.dao;

import java.util.List;

import com.tms.tmsprod.model.Task;

public interface TaskDao {
	List<Task> getAllTasks();
	List<Task> getAssignedTo(String user);
	List<Task> getAssignedBy(String user);
	Task getTaskById(Integer id);
	public void addTask(Task task);
	boolean taskExists(Integer id);
}
