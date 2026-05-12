package com.fitmate.fit_mate_server.domain.body;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/body-info")
@RequiredArgsConstructor
public class BodyInfoController {
    private final BodyInfoService bodyInfoService;

    @PostMapping
    public String create(@RequestBody BodyInfoRequest request) {
        bodyInfoService.saveBodyInfo(request);
        return "체성분 기록 완료!";
    }

    @GetMapping("/list/recent")
    public List<BodyInfo> getRecentList(@RequestParam(name = "memberId") Long memberId) {
    return bodyInfoService.getRecentBodyInfos(memberId);
    }
    
}
