package com.example.suleman.countries.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Translations {

    @SerializedName("de")
    @Expose
    private String de;
    @SerializedName("es")
    @Expose
    private String es;
    @SerializedName("fr")
    @Expose
    private String fr;
    @SerializedName("ja")
    @Expose
    private String ja;
    @SerializedName("it")
    @Expose
    private String it;
    @SerializedName("br")
    @Expose
    private String br;
    @SerializedName("pt")
    @Expose
    private String pt;
    @SerializedName("nl")
    @Expose
    private String nl;
    @SerializedName("hr")
    @Expose
    private String hr;
    @SerializedName("fa")
    @Expose
    private String fa;

    /**
     * No args constructor for use in serialization
     *
     */
    public Translations() {
    }

    /**
     *
     * @param hr
     * @param de
     * @param it
     * @param pt
     * @param fa
     * @param fr
     * @param br
     * @param es
     * @param nl
     * @param ja
     */
    public Translations(String de, String es, String fr, String ja, String it, String br, String pt, String nl, String hr, String fa) {
        super();
        this.de = de;
        this.es = es;
        this.fr = fr;
        this.ja = ja;
        this.it = it;
        this.br = br;
        this.pt = pt;
        this.nl = nl;
        this.hr = hr;
        this.fa = fa;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getJa() {
        return ja;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("de", de).append("es", es).append("fr", fr).append("ja", ja).append("it", it).append("br", br).append("pt", pt).append("nl", nl).append("hr", hr).append("fa", fa).toString();
    }

}
