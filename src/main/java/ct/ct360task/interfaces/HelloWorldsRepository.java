package ct.ct360task.interfaces;

import ct.ct360task.models.HelloWorlds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface HelloWorldsRepository extends JpaRepository<HelloWorlds, Long> {

    //use the parameter language to query
    @Query(value = "SELECT helloworld FROM HelloWorlds helloworld WHERE helloworld.lang = :language")
    List<HelloWorlds> findByLang(String language);

}
