package com.thinksys.bpm.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.spring.annotations.ProcessVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinksys.bpm.bean.ProcessBean;
import com.thinksys.bpm.bean.TaskBean;
import com.thinksys.bpm.bean.UserTaskCompleteBean;
import com.thinksys.bpm.service.BPMService;
import com.thinksys.bpm.utility.JsonResponse;


@Service
public class BPMServiceImpl implements BPMService {

	@Autowired
	 RepositoryService repositoryService;
	 
	@Autowired
	 RuntimeService runtimeService;
	 
	@Autowired
	 TaskService taskService;
	 
	@Autowired
	 IdentityService identityService;
	
	
	@Override
	public void createUser(String name) {
		// TODO Auto-generated method stub
		User user = identityService.newUser(name);
		 identityService.saveUser(user);
		 System.out.println(user.getId()+" -->"+" has been created");
	}
	
	@Override
	public JsonResponse<ProcessBean> startMyProcess(ProcessBean processObject) {
		// TODO Auto-generated method stub
		JsonResponse<ProcessBean> response=new JsonResponse<ProcessBean>();
		if (repositoryService != null) {
			 System.out.println("Running");
			 Map<String,Object> val= new HashMap<String, Object>();
			 val.put("employee",processObject.getEmployee());
			 val.put("mailSubject", processObject.getEmployee()+" has raised a ticket ");
			 val.put("mailBody", "Hi, A Ticket has been raised by "
			 		+ processObject.getEmployee()+" saying " +"'"+processObject.getDescription()+"',Please log in to the ticketing tool for further action");
			 val.put("status","Assigned");
			 val.put("description",processObject.getDescription());
			 val.put("assignedTo",processObject.getAssignedTo());
			 val.put("ackMailBody","This is a acknowledge mail for the ticket num.You will be informed once the ticket is resolved");
			 val.put("ackMailSubject","[Request received]" +processObject.getDescription());
			 val.put("newTicket", 1);
			 
			 
			 
			   repositoryService
			   .createDeployment()
			   .addClasspathResource("NewProcess.bpmn").deploy();
			   
			 
			 String id = runtimeService.startProcessInstanceByKey("ticketProcess", val).getProcessInstanceId();
			 processObject.setTaskID(id);
			 processObject.setPriority(processObject.getPriority());
			 processObject.setStatus("assigned");
			 
			this.complete(id, processObject.getEmployee());
			response.setRecord(processObject);
			 }
		return response;
	}



	private void complete(String id,String employee) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				TaskQuery task=taskService.createTaskQuery().processInstanceId(id);
				for(Task taskk:task.list())
				{
					System.out.println("inside the task complete method");
					
					//taskService.setOwner(id, employee);
					taskService.complete(taskk.getId());
				}
				System.out.println("task has been completed at" +System.currentTimeMillis());
	}

	private void checkUser(String employee) {
		// TODO Auto-generated method stub
						
	}

	@Override
	public JsonResponse<TaskBean> checkAssignTask(String assigneeName) {
		// TODO Auto-generated method stub
		JsonResponse<TaskBean> response = new JsonResponse<TaskBean>();
		TaskQuery taskQuery =  taskService.createTaskQuery().taskInvolvedUser(assigneeName).active();
		List <TaskBean>record = new ArrayList<TaskBean>();
		for(Task task : taskQuery.list())
		{
			System.out.println(task.getExecutionId());
			System.out.println(task.getId());
			System.out.println(task.getProcessInstanceId());
			Map<String, Object> map1=this.runtimeService.getVariables(task.getExecutionId());
			//Map<String, Object> map=task.getProcessVariables();
			/*System.out.println(map1.get("description"));*/
			TaskBean bean=new TaskBean(task.getAssignee(),task.getCreateTime(),(String)map1.get("descripton"),task.getDueDate(),task.getPriority(),task.getOwner(),task.getProcessInstanceId(),task.getName());
			bean.setDescription((String)map1.get("description"));
			bean.setCurrentStatus((String)map1.get("status"));
			bean.setOwner((String)map1.get("employee"));
					
			record.add(bean);
			
		}
		response.setRecords(record);
		response.setTotalRecordCount(record.size());
		return response;
	}
	@Override
	public void completeTask(String instantID, UserTaskCompleteBean userBean) {
		// TODO Auto-generated method stub
		TaskQuery task=taskService.createTaskQuery().processInstanceId(instantID);
		System.out.println(task.list());
		for(Task taskk:task.list())
		{
			
				runtimeService.setVariable(instantID,"approved", userBean.getApproved());
				runtimeService.setVariable(instantID,"description", userBean.getDescription());
				runtimeService.setVariable(instantID,"status", userBean.getStatus());
				runtimeService.setVariable(instantID,"needApproval", userBean.getNeedApproval());
				runtimeService.setVariable(instantID,"approver", userBean.getApprover());
				taskk.setAssignee(userBean.getAssignedTo());
				//runtimeService.setVariable(instantID,"description", userBean.getDescription());
				taskService.complete(taskk.getId());			
		
		}
		
	}

}
