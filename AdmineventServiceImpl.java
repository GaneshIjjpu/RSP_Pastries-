package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Adminevent;
import com.example.demo.repository.AdmineventRepository;

@Service
public class AdmineventServiceImpl implements AdmineventService{

	@Autowired
	
	private AdmineventRepository admineventRepository;
	@Override
	public List<Adminevent> getAllEvents() {
		return admineventRepository.findAll();
	}
	@Override
	public void saveEvents(Adminevent adminevent) {
		this.admineventRepository.save(adminevent);
		
	}
	@Override
	public Adminevent getAdmineventById(long id) {
		java.util.Optional<Adminevent> optional = admineventRepository.findById(id);
		Adminevent adminevent=null;
		if(optional.isPresent()) {
			adminevent=optional.get();
		}
		else {
			throw new RuntimeException("Event not found for id::"+id);
		}
		return adminevent;
	}
	@Override
	public void deleteEventbyId(long id) {
		this.admineventRepository.deleteById(id);
		
	}

	

}
