package com.agg.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.agg.repo.AutomobileRepo;
import com.agg.service.Automobile;
import com.agg.service.AutomobileService;
import com.agg.service.Categoria;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AutomobileServiceImpl implements AutomobileService {
	private AutomobileRepo automobileRepo;

	public AutomobileServiceImpl(AutomobileRepo automobileRepo) {
		this.automobileRepo = automobileRepo;
	}

	@Override
	public Automobile findById(long id) {
		return automobileRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Non esiste un automobile con id " + id));
	}

	@Override
	public void save(Automobile automobile){
		automobileRepo.save(automobile);
	}

	@Override
	public List<Automobile> findAll() {
		return automobileRepo.findAll();
	}

	@Override
	public void update(Automobile automobile) {
		automobileRepo.findById(automobile.getId())
		.orElseThrow(() -> new IllegalArgumentException("Non esiste un automobile con id " + automobile.getId()));
		automobileRepo.save(automobile);
	}

	@Override
	public Automobile findByTarga(String targa) {
		return automobileRepo.findByTarga(targa);
	}

	@Override
	public void delete(Automobile automobile) {
		automobileRepo.delete(automobile);
	}

	@Override
	public List<Automobile> findByCategoria(Categoria categoria) {
		return automobileRepo.findByCategoria(categoria);
	}

	@Override
	public List<Automobile> findByMarca(String marca) {
		return automobileRepo.findByMarca(marca);
	}

	@Override
	public List<Automobile> findByModello(String modello) {
		return automobileRepo.findByModello(modello);
	}


}
