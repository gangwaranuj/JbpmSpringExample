package com.thinksys.bpm.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thinksys.bpm.bean.ProcessBean;
import com.thinksys.bpm.bean.TaskBean;
import com.thinksys.bpm.bean.UserTaskCompleteBean;
import com.thinksys.bpm.service.BPMService;
import com.thinksys.bpm.utility.JsonResponse;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {

	@Autowired BPMService bpmService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	    @RequestMapping(value = "/startProcess", method = RequestMethod.POST)
	    public JsonResponse<ProcessBean> startHireProcess(@RequestBody ProcessBean processObject) {

	    	 JsonResponse<ProcessBean> response=bpmService.startMyProcess(processObject);
			  return response;	
	        
	    }
	    
	    @ResponseStatus(value = HttpStatus.OK)
	    @RequestMapping(value = "/addUser/{user}", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public void addUser(@PathVariable String user) {

	    	bpmService.createUser(user);
	        
	    }
	    
	    
		   @ResponseStatus(value = HttpStatus.OK)
		    @RequestMapping(value = "/dashboard/{user}", method = RequestMethod.GET,
		            produces = MediaType.APPLICATION_JSON_VALUE)
		    public JsonResponse<TaskBean> dashboard(@PathVariable String user) {

			JsonResponse<TaskBean> response=bpmService.checkAssignTask(user);
			return response;
		        
		    }
		   
		   @ResponseStatus(value = HttpStatus.OK)
		    @RequestMapping(value = "/completeTask/{processId}", method = RequestMethod.POST,
		            produces = MediaType.APPLICATION_JSON_VALUE)
		    public void completeTask(@PathVariable int processId,@RequestBody UserTaskCompleteBean userBean) {

			   bpmService.completeTask(""+processId, userBean);
		        
		    }
		   
	    
}
