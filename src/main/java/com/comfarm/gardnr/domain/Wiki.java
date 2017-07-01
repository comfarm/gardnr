package com.comfarm.gardnr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wiki")
@NoArgsConstructor
public class Wiki extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @NotNull
    @Getter
    @Setter
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wiki", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)
    @Getter
    @Setter
    private Set<Steps> steps=new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wiki", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)
    @Getter
    @Setter
    private Set<Checklist> checklists=new HashSet<>();

    @Getter
    @Setter
    @NotNull
    private Long itemId;
}
