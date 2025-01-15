package model;

import java.util.Date;

public class Eveniment {

    private int id;
    private String name;
    private Haus haus ;
    private String ereignis;
    private String date;

    @Override
    public String toString() {
        return "Eveniment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", haus=" + haus +
                ", ereignis='" + ereignis + '\'' +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Haus getHaus() {
        return haus;
    }

    public void setHaus(Haus haus) {
        this.haus = haus;
    }

    public String getEreignis() {
        return ereignis;
    }

    public void setEreignis(String ereignis) {
        this.ereignis = ereignis;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
