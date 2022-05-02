package ct.ct360task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainResource {

    @GetMapping("/hello-rest")
    public String helloWorldStringEndpoint() {
        return "Hello world";
    }

    @GetMapping("/hello")
    public String helloWorldTitleEndpoint() {
        return ("<h1>Hello world</h1>");
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return ("<h1>Hello user</h1>");
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return ("<h1>Hello admin</h1>");
    }
}
