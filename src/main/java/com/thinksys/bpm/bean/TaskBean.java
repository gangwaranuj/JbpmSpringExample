package com.thinksys.bpm.bean;

import java.util.Date;
import java.util.Map;

public class TaskBean {

	String assignee;
	Date createTime;
	String description;
	Date dueDate;
	String owner;
	int priority;
	String taskId;
	String taskName;
	String currentStatus;
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	//Map<String,Object> pathVariable;
	
/*	public Map<String, Object> getPathVariable() {
		return pathVariable;
	}
	public void setPathVariable(Map<String, Object> pathVariable) {
		this.pathVariable = pathVariable;
	}*/
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public TaskBean(String assignee, Date createTime, String description, Date dueDate, int priority, String owner, String id, String taskName) {
		// TODO Auto-generated constructor stub
		this.setAssignee(assignee);
		this.setCreateTime(createTime);
		this.setDescription(description);
		this.setDueDate(dueDate);
		this.setOwner(owner);
		this.setPriority(priority);
		this.setTaskId(id);
		this.setTaskName(taskName);
		//this.setPathVariable(map);
		//this.setCurrentStatus((String) map.get("currentStatus"));
	}

}
