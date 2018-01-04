package com.thinksys.bpm.listeners;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ListenerClass2 implements JavaDelegate 
{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("going to resolve the ticket");
		execution.setVariable("mailSubject","Hi,Ticket no "+ execution.getProcessInstanceId()+" has been resolved ");
		execution.setVariable("mailBody","Ticket has been resolved with comments that " +execution.getVariable("description"));
	}

}
