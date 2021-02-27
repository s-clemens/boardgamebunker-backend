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
@Table(name = "consumable" )
public class Consumable {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @Column(columnDefinition = "serial", name = "id")
    private long consumableid;

    @Column
    private String ingredients;

    @JsonIgnore
    @OneToOne(mappedBy = "consumable")
    private Product product;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "consumabletype_id")
    private ConsumableType consumabletype;

    public Consumable() {

    }

    public Consumable(String ingredients, ConsumableType consumabletype) {
        this.ingredients = ingredients;
        this.consumabletype = consumabletype;
    }



    public long getConsumableid() {
        return consumableid;
    }

    public void setConsumableid(long consumable_id) {
        this.consumableid = consumable_id;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Consumable{" +
                "consumableid=" + consumableid +
                ", ingredients='" + ingredients + '\'' +
                ", product=" + product +
                ", consumabletype=" + consumabletype +
                '}';
    }
}
