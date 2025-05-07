package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ReservationRepository;
import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationRepository repository;
	
	// 등록
	@Override
	public void register(ReservationDTO dto) {
		
		System.out.println(dto);
		
		Reservation entity = dtoToEntity(dto);
		repository.save(entity);
	}
	
	// 리스트로 목록 조회
	@Override
	public List<ReservationDTO> reservationList() {
		List<Reservation> result = repository.findAll();
		List<ReservationDTO> list = new ArrayList<>();
		
		list = result.stream().
				map(entity -> entityToDTO(entity))
				.collect(Collectors.toList());
		
		
		return list;
	}
	
	// 인자로 게시물 번호 받기
	@Override
	public ReservationDTO read(int no) {
		Optional<Reservation> result = repository.findById(no);
		if(result.isPresent()) {
			Reservation reservation = result.get();
			ReservationDTO dto = entityToDTO(reservation);
			return dto;
		}
		else {
			return null;			
		}
	}
	
	
	
	
}
