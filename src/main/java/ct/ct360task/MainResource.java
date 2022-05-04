package ct.ct360task;

import ct.ct360task.models.HelloWorlds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainResource {

    @Autowired
    IHelloWorldService iHelloWorldService;

    @GetMapping("/hello-rest")
    public String helloWorldStringEndpoint(@RequestBody String language) {
        //source for this task: https://zetcode.com/springboot/datajpaquery/
        List<HelloWorlds> list = new ArrayList<>();
        list = iHelloWorldService.findByLang(language);
        //its only one element in the array, but i made it in case there are more entries for same language as in there are more accents
        String translation = list.get(0).getTranslation();
    return translation;
    }

    @GetMapping("/hello")
    public String helloWorldTitleEndpoint() {
        return ("<h1>Hello world</h1>");
    }

    //TODO: change to post
    @GetMapping("/secure/hello")
    public String userEndpoint() {
        return ("<h1>Hello user</h1>");
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return ("<h1>Hello admin</h1>");
    }
}
