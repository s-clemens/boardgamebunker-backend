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
    private int totalStuck;

    @Column
    private int minPlayers;

    @Column
    private int maxPlayers;

    @Column
    private String description;

    @OneToOne(mappedBy = "boardgame")
    private Product boardgame_product_ref;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "boardgametype_id")
    private BoardgameType boardgametype;
}
