package com.example.felipe.pokelist.communication;

/**
 * Created by felipe on 4/14/16.
 */
public class Pokemon {


    /**
     * _id : 56a588c7fe89d12508801b61
     * rowId : 5
     * number : #3
     * img : http://www.serebii.net/shuffle/pokemon/003.png
     * name : Venusaur
     * type : grass
     * basePower : 60
     * ability : Vitality Drain
     * location : Expert Stages - Stage EX7
     * captureRate : 1%
     * __v : 0
     */

    private String number;
    private String img;
    private String name;
    private String type;
    private String basePower;
    private String ability;
    private String location;
    private String captureRate;

    public String getLollipop() {
        return lollipop;
    }

    public void setLollipop(String lollipop) {
        this.lollipop = lollipop;
    }

    private String lollipop;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBasePower() {
        return basePower;
    }

    public void setBasePower(String basePower) {
        this.basePower = basePower;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(String captureRate) {
        this.captureRate = captureRate;
    }
}
