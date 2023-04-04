package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Adminevent;

public interface AdmineventService {
	List<Adminevent> getAllEvents();
	void saveEvents(Adminevent adminevent);
	Adminevent getAdmineventById(long id);
	void deleteEventbyId(long id);
}
