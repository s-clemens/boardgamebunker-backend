package nl.novi.clemens.bgbbackend.domain;

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
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long id;

    @Enumerated(EnumType.STRING)
    private EProductType name;

    @OneToMany (mappedBy = "producttype")
    private Set<Product> products;
}
