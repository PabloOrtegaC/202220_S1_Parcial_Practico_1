package main.java.co.edu.uniandes.dse.parcialejemplo.repositories;


import main.java.co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {


    List<HotelEntity> findByDireccion(String direccion);

    List<HotelEntity> findByNombre(String nombre);

    List<HotelEntity> findByEstellas(int estrellas);

    void deleteById(HotelEntity hotelEntity);
}