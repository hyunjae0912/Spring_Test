package com.example.demo.dto;
import java.time.LocalDate;

import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDTO {
	int no;
	String guestName;
	String guestPhone;
	int roomNo;
	LocalDate regDate;
}
