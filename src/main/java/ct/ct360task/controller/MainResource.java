package ct.ct360task.controller;

import ct.ct360task.interfaces.HelloWorldsRepository;
import ct.ct360task.interfaces.IHelloWorldService;
import ct.ct360task.models.HelloWorlds;
import ct.ct360task.models.ExternalTranslationPojo;
import ct.ct360task.services.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class MainResource {
    //TODO: https://stackoverflow.com/questions/63468269/maven-plugin-not-found-in-intellij-ide
    // do this if that maven thing gets red in pom, idk why it keeps repeating
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

    //out of the box modern solution, just use .save
    @PostMapping(value = "/insertPair", consumes = "application/json")
    public void addPairToDb(@RequestBody HelloWorlds helloWorlds) {
        helloWorldsRepository.save(helloWorlds);
    }
    //TODO: add profile
    @GetMapping(value = "/externalTranslation", consumes = "application/json")
    public String externalTranslation(@RequestBody ExternalTranslationPojo etp) throws IOException {
        // https://script.google.com/home/projects/1Nmk0jVhmK_LtrRS32ztKzA4Qv8mdHrH328OtBnRxfdbAEJE6PXbY3jyH/edit
        // i created a custom google script and im using googles free translate api
        Translator translator = new Translator();
        String result = translator.translate(etp.getLangFrom(), etp.getLangTo(), etp.getText());
        return result;
    }
}
