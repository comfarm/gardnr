package com.comfarm.gardnr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tanim")
@NoArgsConstructor
public class Tanim extends BaseDomain{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private Long itemId;

    @Getter
    @Setter
    private Date startDate;

    @Getter
    @Setter
    private Date endDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tanim", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)
    @Getter
    @Setter
    private Set<Progress> progress;
}
