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
@Table(name = "consumable" )
public class Consumable {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long consumable_id;

    @OneToOne(mappedBy = "consumable")
    private Product consumable_product_ref;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "consumabletype_id")
    private ConsumableType consumabletype;


}
