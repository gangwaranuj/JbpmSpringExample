package com.thinksys.bpm.bean;

import java.util.List;

public class ProcessBean {
	
	String employee;
	int priority;
	String description;
	String processID;
	String status;
	List <String> comments;
	String assignedTo;
	
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getProcessID() {
		return processID;
	}
	public void setProcessID(String processID) {
		this.processID = processID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String assigned) {
		this.status = assigned;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public String getTaskID() {
		return processID;
	}
	public void setTaskID(String taskID) {
		this.processID = taskID;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int noOfdays) {
		this.priority = noOfdays;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String reason) {
		this.description = reason;
	}
	
	
	

}
