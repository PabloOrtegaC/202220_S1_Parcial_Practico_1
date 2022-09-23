package main.java.co.edu.uniandes.dse.parcialejemplo.repositories;


import main.java.co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEntity;
import main.java.co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<HabitacionEntity, Long> {


    List<HabitacionEntity> findByIndentificacion(int identificacion);

    List<HabitacionEntity> findByCamas(int camas);

    List<HabitacionEntity> findByCapacidad(int capacidad);

    List<HabitacionEntity> findByBanos(int banos);

    void deleteById(HabitacionEntity habitacionEntity);
}