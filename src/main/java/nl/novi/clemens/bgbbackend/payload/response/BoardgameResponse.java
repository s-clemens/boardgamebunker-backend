package nl.novi.clemens.bgbbackend.payload.response;


public class BoardgameResponse {

    private Long id;

    private String name;

    private String boardgametype;

    private int minplayers;

    private int maxplayers;

    private String descriptions;

    private String coverimage;

    private float price;

    public BoardgameResponse(){
    }

    public BoardgameResponse(Long id, String name, String boardgametype, int minplayers,
                             int maxplayers, String descriptions, String coverimage,
                             float price) {
        this.id = id;
        this.name = name;
        this.boardgametype = boardgametype;
        this.minplayers = minplayers;
        this.maxplayers = maxplayers;
        this.descriptions = descriptions;
        this.coverimage = coverimage;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoardgametype() {
        return boardgametype;
    }

    public void setBoardgametype(String boardgametype) {
        this.boardgametype = boardgametype;
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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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
        return "BoardgameResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", boardgametype='" + boardgametype + '\'' +
                ", minplayers=" + minplayers +
                ", maxplayers=" + maxplayers +
                ", descriptions='" + descriptions + '\'' +
                ", coverimage=" + coverimage +
                ", price=" + price +
                '}';
    }
}
