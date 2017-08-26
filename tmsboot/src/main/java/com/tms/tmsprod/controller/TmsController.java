package com.tms.tmsprod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tms.tmsprod.model.Task;
import com.tms.tmsprod.model.User;
import com.tms.tmsprod.service.TaskService;
import com.tms.tmsprod.service.UserService;

@CrossOrigin
@RestController
public class TmsController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/user/login")
	public ResponseEntity<User> getUserById(@RequestBody User user) {
		boolean str = userService.userExist(user);
		if(str) return new ResponseEntity<User>(HttpStatus.OK);
		else return new ResponseEntity<User>(HttpStatus.CONFLICT);
		
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = userService.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Void> addUser(@RequestBody User user) {
		boolean flag = userService.addUser(user);
		if(flag == false) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/task")
	public ResponseEntity<List<Task>> getAllTasks(){
		List<Task> list = taskService.getAllTasks();
		return new ResponseEntity<List<Task>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Integer id){
		Task task = taskService.getTaskById(id);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	@GetMapping("/task/by/{user}")
	public ResponseEntity<List<Task>> getAssignedBy(@PathVariable String user ){
		List<Task> list = taskService.getAssignedBy(user);
		return new ResponseEntity<List<Task>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/task/to/{user}")
	public ResponseEntity<List<Task>> getAssignedTo(@PathVariable String user ){
		List<Task> list = taskService.getAssignedTo(user);
		return new ResponseEntity<List<Task>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/task/save")
	public ResponseEntity<Void> addTask(@RequestBody Task task) {
		boolean flag = taskService.addTask(task);
		if(flag == false) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
