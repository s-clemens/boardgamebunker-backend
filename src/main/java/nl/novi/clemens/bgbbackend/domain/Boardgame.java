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
    @Column(columnDefinition = "serial")
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
    private Product boardgame_product_ref;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "boardgametype_id")
    private BoardgameType boardgametype;

    public long getBoardgame_id() {
        return boardgame_id;
    }

    public void setBoardgame_id(long boardgame_id) {
        this.boardgame_id = boardgame_id;
    }

    public int getTotalStuck() {
        return totalstock;
    }

    public void setTotalStuck(int totalStuck) {
        this.totalstock = totalStuck;
    }

    public int getMinPlayers() {
        return minplayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minplayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxplayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxplayers = maxPlayers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getBoardgame_product_ref() {
        return boardgame_product_ref;
    }

    public void setBoardgame_product_ref(Product boardgame_product_ref) {
        this.boardgame_product_ref = boardgame_product_ref;
    }

    public BoardgameType getBoardgametype() {
        return boardgametype;
    }

    public void setBoardgametype(BoardgameType boardgametype) {
        this.boardgametype = boardgametype;
    }
}
