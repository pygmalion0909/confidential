package com.confidential.confidential.controller;

import com.confidential.confidential.service.CommunityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/api/v1/community")
@Slf4j
public class CommunityController {

  @Autowired
  CommunityService communityService;
  
  /**
   * 카테고리에 맞는 커뮤니티 홈
   */
  @GetMapping("/home/{category}")
  public String getCommunityHome(@PathVariable("category") String category, Model model) {
    model.addAttribute("test", "test");
    log.info("category : {}", category);
    communityService.getCommunityHome(category);
    return "community/home";
  }

}