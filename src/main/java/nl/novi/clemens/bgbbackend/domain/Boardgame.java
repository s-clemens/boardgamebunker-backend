package nl.novi.clemens.bgbbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @Column(columnDefinition = "serial", name = "id")
    private long boardgameid;

    @Column
    private int totalstock;

    @Column
    private int minplayers;

    @Column
    private int maxplayers;

    @Column
    private String description;

    @JsonIgnore
    @OneToOne(mappedBy = "boardgame")
    private Product product;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "boardgametype_id")
    private BoardgameType boardgametype;

    public Boardgame() {

    }

    public Boardgame(int totalstock, int minplayers, int maxplayers,
                     String description, BoardgameType boardgametype) {
        this.totalstock = totalstock;
        this.minplayers = minplayers;
        this.maxplayers = maxplayers;
        this.description = description;
        this.boardgametype = boardgametype;
    }

    public long getBoardgameid() {
        return boardgameid;
    }

    public void setBoardgameid(long boardgame_id) {
        this.boardgameid = boardgame_id;
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
