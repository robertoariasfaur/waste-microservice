package com.rafaur.wastemicroservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@SuperBuilder
@Getter
@Setter
@MappedSuperclass
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public abstract class Waste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, insertable=false)
    @Basic(fetch = FetchType.EAGER)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "Create", insertable = false, updatable = false)
    private Date createdDate;
    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "Last Modified", insertable = false, updatable = false)
    private Date lastModifiedDate;

    @Column(name = "Activo")
    private Boolean isEnabled = Boolean.TRUE;

    @Version
    private Long version = 0L;
}