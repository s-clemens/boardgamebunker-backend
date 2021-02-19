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
    @Column(columnDefinition = "serial", name = "id")
    private long consumable_id;

    @Column
    private String ingredients;

    @OneToOne(mappedBy = "consumable")
    private Product product;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "consumabletype_id")
    private ConsumableType consumabletype;

    public long getConsumable_id() {
        return consumable_id;
    }

    public void setConsumable_id(long consumable_id) {
        this.consumable_id = consumable_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ConsumableType getConsumabletype() {
        return consumabletype;
    }

    public void setConsumabletype(ConsumableType consumabletype) {
        this.consumabletype = consumabletype;
    }
}
