package com.example.demo.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CarritoEntity;
import com.example.demo.repository.CarritoRepository;
import com.example.demo.service.CarritoService;





@Service
public class CarritoServiceLmpl implements CarritoService {

	
   @Autowired
	private  CarritoRepository carritoRepository;
	
	@Override
	public List<CarritoEntity> buscarProductosElectronicos() {
		
		return carritoRepository.findAll();
	}


}