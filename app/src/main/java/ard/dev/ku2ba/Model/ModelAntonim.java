package ard.dev.ku2ba.Model;

public class ModelAntonim {
    private int id;
    private String kata_arab;
    private String arti_kata;
    private String kata_antonim_arab;
    private String arti_antonim;

    public ModelAntonim(int id, String kata_arab, String arti_kata, String kata_antonim_arab, String arti_antonim) {
        this.id = id;
        this.kata_arab = kata_arab;
        this.arti_kata = arti_kata;
        this.kata_antonim_arab = kata_antonim_arab;
        this.arti_antonim = arti_antonim;
    }

    public ModelAntonim() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKata_arab() {
        return kata_arab;
    }

    public void setKata_arab(String kata_arab) {
        this.kata_arab = kata_arab;
    }

    public String getArti_kata() {
        return arti_kata;
    }

    public void setArti_kata(String arti_kata) {
        this.arti_kata = arti_kata;
    }

    public String getKata_antonim_arab() {
        return kata_antonim_arab;
    }

    public void setKata_antonim_arab(String kata_antonim_arab) {
        this.kata_antonim_arab = kata_antonim_arab;
    }

    public String getArti_antonim() {
        return arti_antonim;
    }

    public void setArti_antonim(String arti_antonim) {
        this.arti_antonim = arti_antonim;
    }
}
