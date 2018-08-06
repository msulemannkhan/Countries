package com.example.suleman.countries.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Language {

    @SerializedName("iso639_1")
    @Expose
    private String iso6391;
    @SerializedName("iso639_2")
    @Expose
    private String iso6392;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nativeName")
    @Expose
    private String nativeName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Language() {
    }

    /**
     *
     * @param iso6391
     * @param iso6392
     * @param name
     * @param nativeName
     */
    public Language(String iso6391, String iso6392, String name, String nativeName) {
        super();
        this.iso6391 = iso6391;
        this.iso6392 = iso6392;
        this.name = name;
        this.nativeName = nativeName;
    }

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getIso6392() {
        return iso6392;
    }

    public void setIso6392(String iso6392) {
        this.iso6392 = iso6392;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("iso6391", iso6391).append("iso6392", iso6392).append("name", name).append("nativeName", nativeName).toString();
    }

}
