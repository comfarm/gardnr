package com.comfarm.gardnr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Entity
@Table(name = "checklist")
public class Checklist extends BaseDomain{

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "checklist_category_id")
    @Getter
    @Setter
    private ChecklistCategory checklistCategory;

    @NotNull
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String content;


}
