package com.thinksys.bpm.service;

import org.springframework.stereotype.Service;

import com.thinksys.bpm.bean.ProcessBean;
import com.thinksys.bpm.bean.TaskBean;
import com.thinksys.bpm.bean.UserTaskCompleteBean;
import com.thinksys.bpm.utility.JsonResponse;

public interface BPMService {

	 public JsonResponse<ProcessBean> startMyProcess(ProcessBean processObject);
	 public void createUser(String name);
	 public JsonResponse<TaskBean> checkAssignTask(String assigneeName);
	
	void completeTask(String instantID, UserTaskCompleteBean userBean);
}
