package com.fitmate.fit_mate_server.domain.body;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyInfoRepository extends JpaRepository<BodyInfo, Long> {

    // 특정 회원의 체성분 기록을 측정일(measureDate) 기준 최신순으로 10개만 가져옴
    List<BodyInfo> findTop10ByMemberIdOrderByMeasureDateDesc(Long memberId);
}
