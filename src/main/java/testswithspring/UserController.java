package testswithspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private StudentJpaRepoInterface studentJpaRepoInterface;

    public void justry(){
        studentJpaRepoInterface.save(new StudentJpaRepo());
    }
}
