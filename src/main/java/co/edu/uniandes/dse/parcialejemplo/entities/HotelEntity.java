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

public class HotelEntity extends BaseEntity{
    private String nombre;
    private String direccion;
    private int estrellas;
    
	@PodamExclude
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<HabitacionEntity> habitaciones = new ArrayList<>();

  
    

}
