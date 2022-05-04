package ct.ct360task;

import ct.ct360task.models.HelloWorlds;
import ct.ct360task.models.HelloWorldsDetails;
import ct.ct360task.models.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
