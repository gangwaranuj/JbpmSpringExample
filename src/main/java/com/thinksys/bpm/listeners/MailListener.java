package com.thinksys.bpm.listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;

public class MailListener implements TaskListener,ExecutionListener{

	@Override
	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		System.out.println("inside the mail listener class");
		if(("approved").equalsIgnoreCase((String) delegateTask.getVariable("approved")))
				{
					delegateTask.setVariable("approvalBody", "Ticket has been approved with comments ' " +delegateTask.getVariable("description"));
				}
		else
		{
			delegateTask.setVariable("approvalBody", "Ticket has been not been approved");
		}
		
	}

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside the notify method of delegateExecution");
		
	}

}
