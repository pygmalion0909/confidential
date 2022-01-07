package com.confidential.confidential.controller;

import com.confidential.confidential.dto.CommunityDto;
import com.confidential.confidential.service.CommunityService;

import org.apache.catalina.connector.Response;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/community")
@Slf4j
public class CommunityController {

  @Autowired
  CommunityService communityService;
  
  /**
   * 커뮤니티 홈
   */
  @GetMapping("/home/{category}")
  public String getCommunityHome(@PathVariable("category") String categoryCd, Model model) {
    model.addAttribute("cmList", communityService.getCommunityListByCt(categoryCd));
    return "community/home";
  }

  /**
   * 커뮤니티 생성 api
   */
  @PostMapping("/api/new")
  @ResponseBody
  public ResponseEntity apiCreateCommunity(@RequestBody CommunityDto communityDto) {
    return communityService.createCommunity(communityDto);
  }

  @PutMapping("/api/update")
  @ResponseBody
  public ResponseEntity apiUpdateCommunity(@RequestBody CommunityDto communityDto) {
    log.info("[Update Community] communityDto: {}", communityDto);
    return communityService.updateCommunity(communityDto);
  }

  @DeleteMapping("/api/delete")
  @ResponseBody
  public ResponseEntity apiDeleteCommunity(@RequestParam("communityId") Long communityId) {
    return communityService.deleteCommunity(communityId);
  }

}