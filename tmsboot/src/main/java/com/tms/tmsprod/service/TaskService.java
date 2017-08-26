package com.tms.tmsprod.service;

import java.util.List;

import com.tms.tmsprod.model.Task;
import com.tms.tmsprod.model.User;

public interface TaskService {
	List<Task> getAllTasks();
	List<Task> getAssignedTo(String user);
	List<Task> getAssignedBy(String user);
	Task getTaskById(Integer id);
	public boolean addTask(Task task);
}
