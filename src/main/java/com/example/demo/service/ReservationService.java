package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;

public interface ReservationService {
	
	// Entity간의 변환, 등록, 목록 조회, 상세 조회 기능
	
	// 등록
	void register(ReservationDTO dto);
	
	// 목록조회
	List<ReservationDTO> reservationList();
	
	// 상세조회
	ReservationDTO read(int no);
	
	
	default Reservation dtoToEntity(ReservationDTO dto) {
		
		Reservation reservation = 
				Reservation.builder()
				.no(dto.getNo())
				.guestName(dto.getGuestName())
				.guestPhone(dto.getGuestPhone())
				.roomNo(dto.getRoomNo())
				.regDate(dto.getRegDate())
				.build();
		
		return reservation;
	}
	
	default ReservationDTO entityToDTO(Reservation entity) {
		
		ReservationDTO dto =
				ReservationDTO.builder()
				.no(entity.getNo())
				.guestName(entity.getGuestName())
				.guestPhone(entity.getGuestPhone())
				.roomNo(entity.getRoomNo())
				.regDate(entity.getRegDate())
				.build();
		
		return dto;
	}
	
}