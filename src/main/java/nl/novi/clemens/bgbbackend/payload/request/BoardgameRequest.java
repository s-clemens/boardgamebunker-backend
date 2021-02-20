package nl.novi.clemens.bgbbackend.payload.request;

import nl.novi.clemens.bgbbackend.domain.enums.EBoardgameType;
import nl.novi.clemens.bgbbackend.domain.enums.EProductType;

import javax.validation.constraints.NotBlank;
import java.sql.Blob;

public class BoardgameRequest {

    // Product level
    @NotBlank
    private String name;

    @NotBlank
    private EProductType producttype;

    private Blob coverimage;

    @NotBlank
    private float price;

    // Boardgame level
    private String description;
    @NotBlank
    private int minplayers;
    @NotBlank
    private int maxplayers;
    @NotBlank
    private int totalstock;
    @NotBlank
    private EBoardgameType boardgametype;

    public BoardgameRequest(@NotBlank String name, @NotBlank EProductType producttype,
                            Blob coverimage, @NotBlank float price, String description,
                            @NotBlank int minplayers, @NotBlank int maxplayers,
                            @NotBlank int totalstock, @NotBlank EBoardgameType boardgametype) {
        this.name = name;
        this.producttype = producttype;
        this.coverimage = coverimage;
        this.price = price;
        this.description = description;
        this.minplayers = minplayers;
        this.maxplayers = maxplayers;
        this.totalstock = totalstock;
        this.boardgametype = boardgametype;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinplayers() {
        return minplayers;
    }

    public void setMinplayers(int minplayers) {
        this.minplayers = minplayers;
    }

    public int getMaxplayers() {
        return maxplayers;
    }

    public void setMaxplayers(int maxplayers) {
        this.maxplayers = maxplayers;
    }

    public int getTotalStock() {
        return totalstock;
    }

    public void setTotalStock(int totalStock) {
        this.totalstock = totalStock;
    }

    public EBoardgameType getBoardgametype() {
        return boardgametype;
    }

    public void setBoardgametype(EBoardgameType boardgametype) {
        this.boardgametype = boardgametype;
    }
}
