package gr.oteshop.tech.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<Mobile> mobiles = new ArrayList<>();

}
