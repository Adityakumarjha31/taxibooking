package tech.codehunt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.codehunt.model.ServiceForm;

public interface ServiceFormCrud  extends JpaRepository<ServiceForm, Integer>{

}
