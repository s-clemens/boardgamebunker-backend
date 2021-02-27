package nl.novi.clemens.bgbbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.novi.clemens.bgbbackend.domain.enums.EConsumableType;
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
@Table(name = "consumabletype" )
public class ConsumableType {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long consumabletype_id;

    @Enumerated(EnumType.STRING)
    private EConsumableType name;

    @JsonIgnore
    @OneToMany (mappedBy = "consumabletype")
    private Set<Consumable> consumables;

    public long getConsumabletype_id() {
        return consumabletype_id;
    }

    public EConsumableType getName() {
        return name;
    }

    public Set<Consumable> getConsumables() {
        return consumables;
    }
}