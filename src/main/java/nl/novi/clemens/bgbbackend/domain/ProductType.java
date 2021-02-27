package nl.novi.clemens.bgbbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.novi.clemens.bgbbackend.domain.enums.EProductType;
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
@Table(name = "producttype" )
public class ProductType {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long id;

    @Enumerated(EnumType.STRING)
    private EProductType name;

    @JsonIgnore
    @OneToMany (mappedBy = "producttype")
    private Set<Product> products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EProductType getName() {
        return name;
    }

    public void setName(EProductType name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}