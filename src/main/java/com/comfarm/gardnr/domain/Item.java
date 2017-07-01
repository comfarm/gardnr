package com.comfarm.gardnr.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name="item")
public class Item extends BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_category_id")
    @Getter
    @Setter
    private ItemCategory itemCategory;

}