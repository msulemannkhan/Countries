package com.example.suleman.countries.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Countries {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("topLevelDomain")
    @Expose
    private List<String> topLevelDomain = null;
    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    private String alpha3Code;
    @SerializedName("callingCodes")
    @Expose
    private List<String> callingCodes = null;
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("altSpellings")
    @Expose
    private List<String> altSpellings = null;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("subregion")
    @Expose
    private String subregion;
    @SerializedName("population")
    @Expose
    private int population;
    @SerializedName("latlng")
    @Expose
    private List<Float> latlng = null;
    @SerializedName("demonym")
    @Expose
    private String demonym;
    @SerializedName("area")
    @Expose
    private float area;
    @SerializedName("gini")
    @Expose
    private float gini;
    @SerializedName("timezones")
    @Expose
    private List<String> timezones = null;
    @SerializedName("borders")
    @Expose
    private List<String> borders = null;
    @SerializedName("nativeName")
    @Expose
    private String nativeName;
    @SerializedName("numericCode")
    @Expose
    private String numericCode;
    @SerializedName("currencies")
    @Expose
    private List<Currency> currencies = null;
    @SerializedName("languages")
    @Expose
    private List<Language> languages = null;
    @SerializedName("translations")
    @Expose
    private Translations translations;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("regionalBlocs")
    @Expose
    private List<RegionalBloc> regionalBlocs = null;
    @SerializedName("cioc")
    @Expose
    private String cioc;

    /**
     * No args constructor for use in serialization
     *
     */
    public Countries() {
    }

    /**
     *
     * @param cioc
     * @param region
     * @param currencies
     * @param numericCode
     * @param callingCodes
     * @param alpha3Code
     * @param nativeName
     * @param topLevelDomain
     * @param alpha2Code
     * @param capital
     * @param altSpellings
     * @param languages
     * @param subregion
     * @param timezones
     * @param flag
     * @param area
     * @param name
     * @param regionalBlocs
     * @param translations
     * @param latlng
     * @param demonym
     * @param gini
     * @param borders
     * @param population
     */
    public Countries(String name, List<String> topLevelDomain, String alpha2Code, String alpha3Code, List<String> callingCodes, String capital, List<String> altSpellings, String region, String subregion, int population, List<Float> latlng, String demonym, float area, float gini, List<String> timezones, List<String> borders, String nativeName, String numericCode, List<Currency> currencies, List<Language> languages, Translations translations, String flag, List<RegionalBloc> regionalBlocs, String cioc) {
        super();
        this.name = name;
        this.topLevelDomain = topLevelDomain;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.callingCodes = callingCodes;
        this.capital = capital;
        this.altSpellings = altSpellings;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.latlng = latlng;
        this.demonym = demonym;
        this.area = area;
        this.gini = gini;
        this.timezones = timezones;
        this.borders = borders;
        this.nativeName = nativeName;
        this.numericCode = numericCode;
        this.currencies = currencies;
        this.languages = languages;
        this.translations = translations;
        this.flag = flag;
        this.regionalBlocs = regionalBlocs;
        this.cioc = cioc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Float> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Float> latlng) {
        this.latlng = latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getGini() {
        return gini;
    }

    public void setGini(float gini) {
        this.gini = gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Translations getTranslations() {
        return translations;
    }

    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<RegionalBloc> getRegionalBlocs() {
        return regionalBlocs;
    }

    public void setRegionalBlocs(List<RegionalBloc> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("topLevelDomain", topLevelDomain).append("alpha2Code", alpha2Code).append("alpha3Code", alpha3Code).append("callingCodes", callingCodes).append("capital", capital).append("altSpellings", altSpellings).append("region", region).append("subregion", subregion).append("population", population).append("latlng", latlng).append("demonym", demonym).append("area", area).append("gini", gini).append("timezones", timezones).append("borders", borders).append("nativeName", nativeName).append("numericCode", numericCode).append("currencies", currencies).append("languages", languages).append("translations", translations).append("flag", flag).append("regionalBlocs", regionalBlocs).append("cioc", cioc).toString();
    }

}
