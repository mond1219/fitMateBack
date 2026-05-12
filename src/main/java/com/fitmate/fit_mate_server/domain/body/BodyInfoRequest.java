package com.fitmate.fit_mate_server.domain.body;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BodyInfoRequest {
    private Long memberId;      // 누구의 기록인지 (중요!)
    private LocalDate measureDate; 
    private Double weight;
    private Double muscleMass;
    private Double fatMass;
    private String memo;
}
