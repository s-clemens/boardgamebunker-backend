package nl.novi.clemens.bgbbackend.payload.response;

import java.sql.Blob;

public class ConsumableResponse {

    private String name;
    private String consumabletype;
    private String ingredients;
    private Blob coverimage;
    private float price;

    public ConsumableResponse(){

    }

    public ConsumableResponse(String name, String consumabletype, String ingredients,
                              Blob coverimage, float price) {
        this.name = name;
        this.consumabletype = consumabletype;
        this.ingredients = ingredients;
        this.coverimage = coverimage;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsumabletype() {
        return consumabletype;
    }

    public void setConsumabletype(String consumabletype) {
        this.consumabletype = consumabletype;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Blob getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(Blob coverimage) {
        this.coverimage = coverimage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
