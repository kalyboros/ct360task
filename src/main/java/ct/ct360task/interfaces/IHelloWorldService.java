package ct.ct360task.interfaces;

import ct.ct360task.models.HelloWorlds;

import java.util.List;

public interface IHelloWorldService {

    List<HelloWorlds> findByLang(String language);
}
