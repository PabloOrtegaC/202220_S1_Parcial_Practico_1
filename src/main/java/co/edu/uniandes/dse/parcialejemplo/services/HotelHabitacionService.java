
package main.java.co.edu.uniandes.dse.parcialejemplo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import main.java.co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;
import main.java.co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import main.java.co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import main.java.co.edu.uniandes.dse.parcialejemplo.exceptions.ErrorMessage;
import main.java.co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import main.java.co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import main.java.co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import main.java.co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;

@Slf4j
@Service
public class HotelHabitacionService {

	@Autowired
	private  HotelRepository hotelRepository;

	@Autowired
	private HabitacionRepository habitacionRepository;
	

	@Transactional
	public HabitacionEntity addHabitacion(Long idHotel, Long idHabitacion) throws EntityNotFoundException {
		log.info("Inicia proceso de agregar una habitacion al hotel");
		Optional<HotelEntity> hotelEntity = hotelRepository.findById(idHotel);
		Optional<HabitacionEntity> habitacionEntity = habitacionRepository.findById(idHabitacion);

		if (hotelEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.HOTEL_NOT_FOUND);

		if (habitacionEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.HABITACION_NOT_FOUND);

		habitacionEntity.get().getClass().add(hotelEntity.get());
		log.info("Termina proceso");
		return habitacionEntity.get();
	}

}