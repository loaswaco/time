/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.thp.time.stamp.domain;

import ch.thp.time.utilties.database.LocalDateConverter;
import ch.thp.time.utilties.database.DurationConverter;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.Duration;
import org.joda.time.LocalDate;

/**
 *
 * @author Thierry
 */
@Entity
@Getter
@Setter
public class TimesheetEntry {
    
    @Id
    private String uuId;
    @Convert(converter = DurationConverter.class)
    private Duration duration; 
    @Convert(converter = LocalDateConverter.class)
    private LocalDate entryDate; 
    private String description;
    
    
}
