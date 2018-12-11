import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @Autowired
    public TaskRepository taskRepository;

    @RequestMapping("/")
    @ResponseBody
    public String mainPage(){
        return "Hello doge";
    }

    @RequestMapping("/nazista")
    @ResponseBody
    public String secondPage(){
        return "Hi Zelewski";
    }

    @RequestMapping("/db")
    @ResponseBody
    public String testMethod(){
        StringBuilder sb = new StringBuilder();

        Task taks = new Task().withName("Sprawko").withDescription("Ćwiczenie 209").withBudget(21.37).withDone(true);
        taskRepository.save(taks);

        for (Task t :
                taskRepository.findAll()) {
            sb.append(t).append("<br>");
        }
        return sb.toString();
    }
}
