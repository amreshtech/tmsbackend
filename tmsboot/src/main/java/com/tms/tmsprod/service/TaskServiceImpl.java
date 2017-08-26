package com.tms.tmsprod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.tmsprod.dao.TaskDao;
import com.tms.tmsprod.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;
	@Override
	public List<Task> getAllTasks() {
		return taskDao.getAllTasks();
	}

	@Override
	public List<Task> getAssignedTo(String user) {
		return taskDao.getAssignedTo(user);
	}

	@Override
	public List<Task> getAssignedBy(String user) {
		return taskDao.getAssignedBy(user);
	}

	@Override
	public Task getTaskById(Integer id) {
		return taskDao.getTaskById(id);
	}

	@Override
	public boolean addTask(Task task) {
		if(taskDao.taskExists(task.getTaskid())){
			return false;
		} else {
			taskDao.addTask(task);
			return true;
		}
	}

}
