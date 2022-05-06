package ct.ct360task.models;

public class ExternalTranslationPojo {

    public String langFrom;
    public String langTo;
    public String text;

    public ExternalTranslationPojo(String langFrom, String langTo, String text) {
        this.langFrom = langFrom;
        this.langTo = langTo;
        this.text = text;
    }

    public String getLangFrom() {
        return langFrom;
    }

    public void setLangFrom(String langFrom) {
        this.langFrom = langFrom;
    }

    public String getLangTo() {
        return langTo;
    }

    public void setLangTo(String langTo) {
        this.langTo = langTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
