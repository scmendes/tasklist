package org.smendes.tasklist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskListController {
    
    @RequestMapping("/")
    public String index() {
    	return "index";
    }
    
}
