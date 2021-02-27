package nl.novi.clemens.bgbbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.novi.clemens.bgbbackend.domain.enums.EBoardgameType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "boardgametype" )
public class BoardgameType {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long boardgametype_id;

    @Enumerated(EnumType.STRING)
    private EBoardgameType name;

    @JsonIgnore
    @OneToMany (mappedBy = "boardgametype")
    private Set<Boardgame> boardgames;

    public long getBoardgametype_id() {
        return boardgametype_id;
    }

    public EBoardgameType getName() {
        return name;
    }

    public Set<Boardgame> getBoardgames() {
        return boardgames;
    }

    public void setName(EBoardgameType name) {
        this.name = name;
    }
}