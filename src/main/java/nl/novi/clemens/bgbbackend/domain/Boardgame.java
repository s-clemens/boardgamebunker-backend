package nl.novi.clemens.bgbbackend.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "boardgame" )
public class Boardgame {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(columnDefinition = "serial", name = "id")
    private long boardgame_id;

    @Column
    private int totalstock;

    @Column
    private int minplayers;

    @Column
    private int maxplayers;

    @Column
    private String description;

    @OneToOne(mappedBy = "boardgame")
    private Product product;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "boardgametype_id")
    private BoardgameType boardgametype;

    public long getBoardgame_id() {
        return boardgame_id;
    }

    public void setBoardgame_id(long boardgame_id) {
        this.boardgame_id = boardgame_id;
    }

    public int getTotalstock() {
        return totalstock;
    }

    public void setTotalstock(int totalstock) {
        this.totalstock = totalstock;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BoardgameType getBoardgametype() {
        return boardgametype;
    }

    public void setBoardgametype(BoardgameType boardgametype) {
        this.boardgametype = boardgametype;
    }
}
