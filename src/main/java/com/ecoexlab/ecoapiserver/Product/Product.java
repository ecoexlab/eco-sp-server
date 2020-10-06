package com.ecoexlab.ecoapiserver.Product;

import com.ecoexlab.ecoapiserver.ObOrder.ObOrder;
import lombok.*;

import javax.persistence.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="Product")
public class Product {

    @Id
    @GeneratedValue
    private Long idx;

    private String prod_name;

    private int hscode;

    private int prod_cnt;

    private int prod_amount;

}
