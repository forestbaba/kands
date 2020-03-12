package com.forestsoftware.kands.DB;

public class DictObjectModel {

    String title, song, numner;
    int number;

    public DictObjectModel()
    {}

    public DictObjectModel(String title)
    {

//        this.title = title;
//        this.song = song;
    }
    public DictObjectModel(String songn, String songt)
    {

        this.title = songt;
        this.song = songn;
    }

    public DictObjectModel(String songn, String songt, String songF)
    {

        this.title = songt;
        this.numner = songn;
        this.song= songF;
    }
    public DictObjectModel(int nomba, String songt, String songF)
    {

        this.title = songt;
        this.number = nomba;
        this.song= songF;
    }
    public String gettitle() {
        return title;
    }
    public String getNumber()
    {
        return numner;
    }

    public String getSong() {
        return song;
    }
    public int getNomba()
    {
        return number;
    }

    public void setTitle(String t)
    {
        this.title = t;
    }
    public void setSong(String s)
    {
        this.song = s;
    }
    public void setNumner(String n)
    {
        this.numner = n;
    }
    public void setNomba(int n)
    {
        this.number = n;
    }

}
