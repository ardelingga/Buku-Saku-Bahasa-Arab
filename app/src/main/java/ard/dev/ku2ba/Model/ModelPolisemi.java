package ard.dev.ku2ba.Model;

public class ModelPolisemi {
    private int id;
    private String kata;
    private String makna1;
    private String arti_makna1;
    private String makna2;
    private String arti_makna2;


    public ModelPolisemi(int id, String kata, String makna1, String arti_makna1, String makna2, String arti_makna2) {
        this.id = id;
        this.kata = kata;
        this.makna1 = makna1;
        this.arti_makna1 = arti_makna1;
        this.makna2 = makna2;
        this.arti_makna2 = arti_makna2;
    }

    public ModelPolisemi() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKata() {
        return kata;
    }

    public void setKata(String kata) {
        this.kata = kata;
    }

    public String getMakna1() {
        return makna1;
    }

    public void setMakna1(String makna1) {
        this.makna1 = makna1;
    }

    public String getArti_makna1() {
        return arti_makna1;
    }

    public void setArti_makna1(String arti_makna1) {
        this.arti_makna1 = arti_makna1;
    }

    public String getMakna2() {
        return makna2;
    }

    public void setMakna2(String makna2) {
        this.makna2 = makna2;
    }

    public String getArti_makna2() {
        return arti_makna2;
    }

    public void setArti_makna2(String arti_makna2) {
        this.arti_makna2 = arti_makna2;
    }
}
