package nl.novi.clemens.bgbbackend.payload.request;

import nl.novi.clemens.bgbbackend.domain.enums.EConsumableType;
import nl.novi.clemens.bgbbackend.domain.enums.EProductType;

import javax.validation.constraints.NotBlank;
import java.sql.Blob;

public class ConsumableRequest {

    // Product level
    @NotBlank
    private String name;

    @NotBlank
    private EProductType producttype;

    private Blob coverimage;

    @NotBlank
    private float price;

    // Consumable level
    private String ingredients;

    @NotBlank
    private EConsumableType consumabletype;

    public ConsumableRequest(@NotBlank String name, @NotBlank EProductType producttype,
                             Blob coverimage, @NotBlank float price, String ingredients,
                             @NotBlank EConsumableType consumabletype) {
        this.name = name;
        this.producttype = producttype;
        this.coverimage = coverimage;
        this.price = price;
        this.ingredients = ingredients;
        this.consumabletype = consumabletype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EProductType getProducttype() {
        return producttype;
    }

    public void setProducttype(EProductType producttype) {
        this.producttype = producttype;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public EConsumableType getConsumabletype() {
        return consumabletype;
    }

    public void setConsumabletype(EConsumableType consumabletype) {
        this.consumabletype = consumabletype;
    }


}
