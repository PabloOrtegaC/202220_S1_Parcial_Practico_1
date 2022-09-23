
package main.java.co.edu.uniandes.dse.parcialejemplo.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;
import main.java.co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import main.java.co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import main.java.co.edu.uniandes.dse.parcialejemplo.exceptions.ErrorMessage;
import main.java.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import main.java.co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import main.java.co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;
import main.java.co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import main.java.co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;


@Slf4j
@Service
public class HabitacionService {

	@Autowired
	HabitacionRepository habitacionRepository;
	

	@Transactional
	public HabitacionEntity createHabitacion(HabitacionEntity habitacion) throws IllegalOperationException {
		log.info("Inicia proceso de creación de una habitacion");
		
		if(habitacion.getIdentificacion() > habitacion.getCamas()) {
			throw new IllegalOperationException("Id mayor que camas");
	    }
     
		return habitacionRepository.save(habitacion);
	}

}