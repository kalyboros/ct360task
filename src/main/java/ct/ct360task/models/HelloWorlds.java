package ct.ct360task.models;

import javax.persistence.*;

@Entity
@Table(name = "helloworlds")
public class HelloWorlds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String lang;
    public String translation;

    public HelloWorlds(int id, String lang, String translation) {
        this.id = id;
        this.lang = lang;
        this.translation = translation;
    }

    public HelloWorlds() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return lang;
    }

    public void setLanguage(String language) {
        this.lang = language;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

}
