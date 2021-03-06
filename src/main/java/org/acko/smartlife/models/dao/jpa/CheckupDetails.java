package org.acko.smartlife.models.dao.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.acko.smartlife.constants.DataType;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author prabodh.hend
 */
@Data
@Entity
@Table(name = "checkup_details", indexes = {@Index(name = "idx_checkup_id", columnList = "checkup_id")})
@Where(clause = "is_deleted = 0")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckupDetails extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "checkup_id")
    private Checkup checkup;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "value")
    private String value;

    @Column(name = "data_type")
    @Enumerated(EnumType.STRING)
    private DataType dataType;


}
