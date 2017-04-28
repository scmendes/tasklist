package org.smendes.tasklist;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TaskListController {
    
    @RequestMapping("/")
    public String index() {
        return "Hi from Silvio! My task list starts here.";
    }
    
}
