package com.thinksys.bpm.listeners;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class ApproverTaskCreateListener implements TaskListener {

	@Override
	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		System.out.println("Inside the approver task create method");
		delegateTask.setAssignee((String)delegateTask.getVariable("approver"));
		System.out.println(delegateTask.getAssignee());
		
		
	}

}
