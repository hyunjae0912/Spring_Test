package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;

@SpringBootTest
public class ReservationServiceTest {
	
	@Autowired
	ReservationService service;
	
	
	@Test
	void 서비스조회() {
		System.out.println("서비스는 여기 : " + service);
	}
	
	@Test
	void 등록() {
		ReservationDTO reservation = ReservationDTO.builder()
				.guestName("도우너")
				.guestPhone("010-6549-8135")
				.roomNo(205)
				.build();
		
		
		service.register(reservation);
		
	}
	
	@Test
	void 조회() {
		List<ReservationDTO> list = service.reservationList();
		
	    list.forEach(dto -> System.out.println(dto));
	}
	
	@Test
	void 단일조회() {
		ReservationDTO dto = service.read(3);
		
		System.out.println(dto);
		
	}
}
