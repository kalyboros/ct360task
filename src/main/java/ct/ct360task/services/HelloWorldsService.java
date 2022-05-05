package ct.ct360task.services;

import ct.ct360task.interfaces.HelloWorldsRepository;
import ct.ct360task.interfaces.IHelloWorldService;
import ct.ct360task.models.HelloWorlds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloWorldsService implements IHelloWorldService {

    @Autowired
    HelloWorldsRepository helloWorldsRepository;

    @Override
    public List<HelloWorlds> findByLang(String language) {
        List<HelloWorlds> helloWorlds = helloWorldsRepository.findByLang(language);
        return helloWorlds;
    }

}
