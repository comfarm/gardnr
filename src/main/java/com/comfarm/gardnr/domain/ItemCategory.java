package com.comfarm.gardnr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="item_category")
@NoArgsConstructor
public class ItemCategory extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)@Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Item.class,mappedBy = "itemCategory", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)
    @Getter
    @Setter
    public Set<Item> items=new HashSet<>();


}