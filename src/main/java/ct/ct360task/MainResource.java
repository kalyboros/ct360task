package ct.ct360task;

import ct.ct360task.interfaces.HelloWorldsRepository;
import ct.ct360task.interfaces.IHelloWorldService;
import ct.ct360task.models.HelloWorlds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainResource {
    //TODO: reorganize files
    @Autowired
    IHelloWorldService iHelloWorldService;

    @Autowired
    HelloWorldsRepository helloWorldsRepository;

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

    @RequestMapping("/secure/hello")
    public RedirectView userEndpoint() {
        //after a secure login, user gets redirected to webpage so he can insert
        RedirectView redirect = new RedirectView();
        redirect.setUrl("/addPair");
        return redirect;
    }
/*
    @PostMapping(
            value = "/addPairDb", consumes = "application/json", produces = "application/json")
    public HelloWorlds addPairToDb(@RequestBody HelloWorlds helloWorlds) {

    }
*/
    /*
    //out of the box modern solution
    @RequestMapping(value = "/addPairDb", method = RequestMethod.POST)
    @ResponseBody
    public String set(@RequestParam("id") Integer id ,@RequestParam("lang") String lang,@RequestParam("translation") String translation){


        //HelloWorlds newPair = new HelloWorlds(id, lang, translation);
        //helloWorldsRepository.save(newPair);
        return lang;
    }
    */
    @PostMapping(value = "/insertPair", consumes = "application/json")
    public void addPairToDb(@RequestBody HelloWorlds helloWorlds) {
        helloWorldsRepository.save(helloWorlds);
        //it does receive correctly from postman
        System.out.println(helloWorlds.getTranslation());
        //return helloWorlds.getTranslation();
    }
}
