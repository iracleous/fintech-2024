package gr.oteshop.tech.models;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    private Brand brand;
    private String model;
    private String color;
    private BigDecimal price;
}

/*
{
    "name":"E37",
        "brandId":15,
        "model":"black",
        "color":"light",
        "price":300
}

{
    "name":"E37",
        "brand":{
            "id":15,
            "name":"Samsung",
            "description":"xxx"
        },
        "model":"black",
        "color":"light",
        "price":300
}


*/