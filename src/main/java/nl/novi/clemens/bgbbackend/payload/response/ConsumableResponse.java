package nl.novi.clemens.bgbbackend.payload.response;

import java.sql.Blob;

public class ConsumableResponse {

    private long id;
    private String name;
    private String consumabletype;
    private String ingredients;
    private String coverimage;
    private float price;

    public ConsumableResponse(){

    }

    public ConsumableResponse(Long id, String name, String consumabletype, String ingredients,
                              String coverimage, float price) {
        this.id = id;
        this.name = name;
        this.consumabletype = consumabletype;
        this.ingredients = ingredients;
        this.coverimage = coverimage;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ConsumableResponse{" +
                "name='" + name + '\'' +
                ", consumabletype='" + consumabletype + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", coverimage=" + coverimage +
                ", price=" + price +
                '}';
    }
}
