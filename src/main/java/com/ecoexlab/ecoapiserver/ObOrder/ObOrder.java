package com.ecoexlab.ecoapiserver.ObOrder;

import com.ecoexlab.ecoapiserver.Product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="outbound")
public class ObOrder {

    @GeneratedValue
    private Long idx;

    @Id
    @Column(nullable=false, unique = true)
    private String cl_order_no;

    private String seller_order_no;

    private String seller_master_no;

    private String sender_name;

    private String sender_code;

    private String sender_tel;

    private String sender_addr1;

    private String sender_addr2;

    private String buyer_name;

    private String buyer_country;

    private String buyer_tel;

    private String buyer_addr1;

    private String buyer_addr2;

    private String zipcode;

    private int w_size;

    private int l_size;

    private int h_size;

    private int vgt;

    private int wgt;

    private String order_stat;

    private int prod_cnt;

    private int tot_amount;

    private String vone_order_no;

    private int cwgt;

    private String bl_no;

    private String bl_img_url;

    private String track_code;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_dt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_dt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date canceled_dt;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="orderNo")
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p){
        if( products == null){
            products = new ArrayList<Product>();
        }
        products.add(p);
    }
}