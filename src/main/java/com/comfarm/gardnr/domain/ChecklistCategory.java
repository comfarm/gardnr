package com.comfarm.gardnr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "checklist_category")
public class ChecklistCategory extends BaseDomain{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "checklistCategory",cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)
    @Getter
    @Setter
    private Set<Checklist> checklists;

    @Getter
    @Setter
    private String name;
}
