package com.thinksys.bpm.listeners;

import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class ListenerClass implements JavaDelegate 
{

	@Autowired RuntimeService runtimeService;
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside the service task delegate method when days not equal to 5");
		String id=execution.getProcessInstanceId();
		if(execution.getVariable("status").equals("2"))
		{
			String mailbody= (String) execution.getVariable("mailBody");
			System.out.println(mailbody);
			execution.setVariable("newTicket", 2);
			execution.setVariable("mailBody","Hi ticket "+execution.getProcessInstanceId()+" has been assigned to you saying '"+execution.getVariable("description")+"'");
			execution.setVariable("mailSubject","A ticket no "+ execution.getProcessInstanceId() +"has been assigned to you");
			
			// 
//			 val.put("mailSubject", "Employee "+processObject.getEmployee()+" has raised a ticket ");
//			 val.put("mailBody", "Hi Manager employee ', "+processObject.getEmployee()+"'  has raised a ticket saying '" +"'"+processObject.getDescription()+"'");
//			 val.put("status",processObject.getStatus());
			
		}
	
	}

}
