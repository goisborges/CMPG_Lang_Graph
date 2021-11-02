package com.example.cmpg_lang_graph;

public class Answer {
    private Integer response_id;
    private String country;
    private String age;
    private String years_coding;
    private String op_sys;
    private Integer converted_yearly_compensation;

    public Answer(Integer response_id, String country, String age, String years_coding, String op_sys, Integer converted_yearly_compensation) {
        setResponseId(response_id);
        setCountry (country);
        setAge (age);
        setYears_coding (years_coding);
        setOp_sys (op_sys);
        setConverted_yearly_compensation(converted_yearly_compensation);
    }

    public Integer getResponseId() {
        return response_id;
    }

    public void setResponseId(Integer response_id) {
        this.response_id = response_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getYears_coding() {
        return years_coding;
    }

    public void setYears_coding(String years_coding) {
        this.years_coding = years_coding;
    }

    public String getOp_sys() {
        return op_sys;
    }

    public void setOp_sys(String op_sys) {
        this.op_sys = op_sys;
    }

    public Integer getConverted_yearly_compensation() {
        return converted_yearly_compensation;
    }

    public void setConverted_yearly_compensation(Integer converted_yearly_compensation) {
        this.converted_yearly_compensation = converted_yearly_compensation;
    }

    //toString
    public String toString(){
        return String.format("I have %d years old and I make %d CAD a year", age, converted_yearly_compensation);
    }
}
