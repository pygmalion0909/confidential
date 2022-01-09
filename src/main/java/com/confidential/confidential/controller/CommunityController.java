package com.confidential.confidential.controller;

import com.confidential.confidential.dto.CommunityDto;
import com.confidential.confidential.service.CommunityService;

import org.springframework.beans.factory.annotation.Autowired;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/community")
@Api(tags = {"Community"})
@Slf4j
public class CommunityController {

  @Autowired
  CommunityService communityService;
  
  @GetMapping("/home/{category}")
  @ApiOperation(value="커뮤니티 홈", notes = "커뮤니티 홈 페이지")
  public String getCommunityHome(@PathVariable("category") String categoryCd, Model model) {
    model.addAttribute("cmList", communityService.getCommunityListByCt(categoryCd));
    return "community/home";
  }

  @GetMapping("/new")
  @ApiOperation(value="커뮤니티 생성", notes = "커뮤니티 생성 페이지")
  public String getCommunityNew() {
    return "community/new";
  }
  
  @PostMapping("/api/new")
  @ResponseBody
  @ApiOperation(value="커뮤니티 생성Api", notes = "커뮤니티 글 생성Api")
  public ResponseEntity apiCreateCommunity(@RequestBody CommunityDto communityDto) {
    log.info("[Community Create Api] communityDto: {}", communityDto);
    return communityService.createCommunity(communityDto);
  }

  @PutMapping("/api/update")
  @ResponseBody
  @ApiOperation(value="커뮤니티 수정Api", notes = "커뮤니티 글 수정Api")
  public ResponseEntity apiUpdateCommunity(@RequestBody CommunityDto communityDto) {
    log.info("[Update Community] communityDto: {}", communityDto);
    return communityService.updateCommunity(communityDto);
  }

  @DeleteMapping("/api/delete")
  @ResponseBody
  @ApiOperation(value="커뮤니티 삭제Api", notes = "커뮤니티 글 삭제Api")
  public ResponseEntity apiDeleteCommunity(@RequestParam("communityId") Long communityId) {
    return communityService.deleteCommunity(communityId);
  }

}