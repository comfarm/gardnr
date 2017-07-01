package com.comfarm.gardnr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "steps")
@NoArgsConstructor
public class Steps extends BaseDomain{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wiki_id")
    @Getter
    @Setter
    private Wiki wiki;

    @Column(name="content", columnDefinition="TEXT")
    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private Long stepNum;

    @Getter
    @Setter
    private int countDays;

    @Getter
    @Setter
    private String title;

}
