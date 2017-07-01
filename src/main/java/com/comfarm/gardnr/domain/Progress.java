package com.comfarm.gardnr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "progress")
@NoArgsConstructor
public class Progress extends BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tanim_id")
    @Getter
    @Setter
    private Tanim tanim;

    @Getter
    @Setter
    private String image;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private Date progressDate;
}
