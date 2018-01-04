package com.thinksys.bpm.listeners;

import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

public class Listener implements ActivitiEventListener, TaskListener, ExecutionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void onEvent(ActivitiEvent event) {
		// TODO Auto-generated method stub
		 switch (event.getType()) {
    case ACTIVITY_STARTED:
        System.out.println("Activi started ");
        break;
    case ACTIVITY_COMPLETED:
        System.out.println("Activi completed ");
        break;

    case TASK_CREATED : 
        System.out.println("Task Created ");
        break;

    case TASK_COMPLETED:
        System.out.println("Task completed ");
        break;

    case JOB_EXECUTION_SUCCESS:
      System.out.println("A job well done!");
      break;

    case JOB_EXECUTION_FAILURE:
      System.out.println("A job has failed...");
      break;
      
    case TASK_ASSIGNED:
        System.out.println("task has been assigned to someone");
        break;  
      
    default:
      System.out.println("Event received: " + event.getType());
  }
	}

	@Override
	public boolean isFailOnException() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		System.out.println("Notify Delegate task called at" +System.currentTimeMillis());
		//logic to assign it goes here
		if(delegateTask.getAssignee()==null ||delegateTask.getAssignee()=="" )
		{
			
		delegateTask.setAssignee((String)delegateTask.getVariable("assignedTo"));
		System.out.println(delegateTask.getAssignee());
		}
		else
		{
			System.out.println("inside the notify method of Listener class");
			/*
			delegateTask.setAssignee(delegateTask.getAssignee());
			delegateTask.setVariable("mailSubject", "Ticket has been assigned back to you" );
			delegateTask.setVariable("mailBody", "Hi " +delegateTask.getOwner() +" Ticket has been assigned back to you saying that Mouse is not available in inventory" );
			delegateTask.setAssignee("sachin");
			
			
			runtimeService.setVariable(id, "days", processObject.getNoOfdays());
			runtimeService.setVariable(id, "employee", processObject.getEmployee());
			runtimeService.setVariable(id, "manager","manager");
			runtimeService.setVariable(id, "comments", processObject.getComments());
			runtimeService.setVariable(id, "mailSubject", "Employee "+processObject.getEmployee()+" has raised a ticket ");
			runtimeService.setVariable(id, "mailBody", "Hi "+processObject.getEmployee()+" has raised a ticket saying '" +"'"+processObject.getDescription());
			runtimeService.setVariable(id, "comments", processObject.getComments());
			//runtimeService.setVariable(id, "status", "assigned");
		*/}
		
		
	}

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside the another notify method"+execution.getEventName());
		
	}


	
}
