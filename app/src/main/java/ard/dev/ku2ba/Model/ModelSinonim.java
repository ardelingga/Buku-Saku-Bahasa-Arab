package ard.dev.ku2ba.Model;

public class ModelSinonim {
    private int id;
    private String word_indo;
    private String sinonim_arab;

    public ModelSinonim(int id, String word_indo, String sinonim_arab) {
        this.id = id;
        this.word_indo = word_indo;
        this.sinonim_arab = sinonim_arab;
    }

    public ModelSinonim() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord_indo() {
        return word_indo;
    }

    public void setWord_indo(String word_indo) {
        this.word_indo = word_indo;
    }

    public String getSinonim_arab() {
        return sinonim_arab;
    }

    public void setSinonim_arab(String sinonim_arab) {
        this.sinonim_arab = sinonim_arab;
    }
}
