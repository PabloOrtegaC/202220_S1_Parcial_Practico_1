package main.java.co.edu.uniandes.dse.parcialejemplo.entities;


import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

public class HabitacionEntity extends BaseEntity{
    private int identificacion;
    private int capacidad;
    private int camas;
    private int banos;

    @PodamExclude
	@ManyToOne
	private HotelEntity hotel;

 
}