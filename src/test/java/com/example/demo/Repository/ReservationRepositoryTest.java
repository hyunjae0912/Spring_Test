package com.example.demo.Repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Reservation;

@SpringBootTest
public class ReservationRepositoryTest {
	@Autowired
	ReservationRepository repository;
	
	
//	@Test
//	void 등록() {
//		Reservation reservation = Reservation.builder()
//				.guestName("둘리")
//				.guestPhone("010-3955-0845")
//				.roomNo(3)
//				.build();
		
//		repository.save(reservation);
//		
//	}
	
	
	@Test
	void 조회() {
		Optional<Reservation> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Reservation reservation = optional.get();
			System.out.println(reservation);
		}
		
	}
	
	@Test
	void 게시물삭제() {
		
		//repository.deleteAll();
		//repository.deleteById(1);
	}
	
	@Test
	void 수정() {
		Optional<Reservation> optional = repository.findById(1);
		
		if(optional.isPresent()) {
			Reservation reservation = optional.get();
			reservation.setGuestName("또치");
			repository.save(reservation);
		}
		
	}
}
