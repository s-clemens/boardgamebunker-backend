package nl.novi.clemens.bgbbackend.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name = "store_product")
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "native"
    )
    @Column(columnDefinition = "serial", name = "id")
    private long productid;

    @Column
    private String name;

    @Column
    private float product_price;

    @Column
    @Lob
    private Blob image_cover;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producttype_id")
    private ProductType producttype;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "product_consumable",
            joinColumns =
                    {@JoinColumn(name = "store_product", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "consumable", referencedColumnName = "id")})
    private Consumable consumable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "product_boardgame",
            joinColumns =
                    {@JoinColumn(name = "store_product", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "boardgame", referencedColumnName = "id")})
    private Boardgame boardgame;

    @OneToMany(mappedBy = "product")
    private Set<BookingLine> bookinglines;

    public Product() {

    }

    public Product(String name, float product_price, Blob image_cover, ProductType producttype) {
        this.name = name;
        this.product_price = product_price;
        this.image_cover = image_cover;
        this.producttype = producttype;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public Blob getImage_cover() {
        return image_cover;
    }

    public void setImage_cover(Blob image_cover) {
        this.image_cover = image_cover;
    }

    public ProductType getProducttype() {
        return producttype;
    }

    public void setProducttype(ProductType producttype) {
        this.producttype = producttype;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }

    public Boardgame getBoardgame() {
        return boardgame;
    }

    public void setBoardgame(Boardgame boardgame) {
        this.boardgame = boardgame;
    }

    public Set<BookingLine> getBookinglines() {
        return bookinglines;
    }

    public void setBookinglines(Set<BookingLine> bookinglines) {
        this.bookinglines = bookinglines;
    }
}
