package nl.novi.clemens.bgbbackend.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name = "store_product" )
public class Product {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @Column(columnDefinition = "serial")
    private long productid;

    @Column
    private String product_name;

    @Column
    private float product_price;

    @Column
    @Lob
    private byte[] image_cover;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "producttype_id")
    private ProductType producttype;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "consumable_id", nullable = true)
    private Consumable consumable;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "boardgame_id", nullable = true)
    private Boardgame boardgame;

    @OneToMany(mappedBy = "product")
    private Set<BookingLine> bookinglines;

}
