package ct.ct360task.models;

public class HelloWorldsDetails {

    public String lang;
    public String translation;

    public HelloWorldsDetails(String lang, String translation) {
        this.lang = lang;
        this.translation = translation;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
