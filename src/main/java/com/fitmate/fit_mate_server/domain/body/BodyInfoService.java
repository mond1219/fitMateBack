package com.fitmate.fit_mate_server.domain.body;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fitmate.fit_mate_server.domain.member.Member;
import com.fitmate.fit_mate_server.domain.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BodyInfoService {
    private final BodyInfoRepository bodyInfoRepository;
    private final MemberRepository memberRepository;

    public Long saveBodyInfo(BodyInfoRequest request) {
        // 1. 회원 존재 여부 확인
        Member member = memberRepository.findById(request.getMemberId())
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        // 2. BodyInfo 엔티티 생성 및 회원 연결
        BodyInfo bodyInfo = BodyInfo.builder()
                .member(member)
                .measureDate(request.getMeasureDate())
                .weight(request.getWeight())
                .muscleMass(request.getMuscleMass())
                .fatMass(request.getFatMass())
                .memo(request.getMemo())
                .createdAt(LocalDateTime.now())
                .build();

        return bodyInfoRepository.save(bodyInfo).getId();
    }

    public List<BodyInfo> getRecentBodyInfos(Long memberId) {
    return bodyInfoRepository.findTop10ByMemberIdOrderByMeasureDateDesc(memberId);
    }
    
}
