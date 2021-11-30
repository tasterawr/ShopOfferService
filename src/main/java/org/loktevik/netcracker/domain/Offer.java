package org.loktevik.netcracker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="offers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;

    @Column(name = "paidtype_id")
    private int paidTypeId;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name= "offer_characteristics", schema = "public",
            joinColumns = {@JoinColumn(name="offer_id")},
            inverseJoinColumns = {@JoinColumn(name="characteristic_id")}
    )
    private List<Characteristic> characteristics;
}
