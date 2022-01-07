package com.confidential.confidential.service;

import java.util.List;

import com.confidential.confidential.dto.CommunityDto;
import com.confidential.confidential.entity.community.Community;
import com.confidential.confidential.repository.CommunityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommunityService {

  @Autowired
  CommunityRepository communityRepository;

  /**
   * 카테고리별 커뮤니티 리스트
   */
  public List<Community> getCommunityListByCt(String categoryCd) {

    List<Community> cmList = communityRepository.findAllByCategoryCode(categoryCd);
    return cmList;
  }

  /**
   * 커뮤니티 생성
   */
  public ResponseEntity createCommunity(CommunityDto communityDto) {

    Community cm = Community.builder()
                            .memberBasId(1L)
                            .categoryCode("A")
                            .title("sss")
                            .contents("안녕하세요")
                            .build();
    communityRepository.save(cm);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * 커뮤니티 수정
   */
  public ResponseEntity updateCommunity(CommunityDto communityDto) {

    Community cm = communityRepository.findByCommunityId(communityDto.getCommunityId());
    if(cm != null) {
      cm.update(communityDto.getCategoryCode(), communityDto.getTitle(), communityDto.getContents());
      communityRepository.save(cm);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * 커뮤니티 삭제
   */
  public ResponseEntity deleteCommunity(Long communityId) {
    if (communityRepository.existsById(communityId)) communityRepository.deleteById(communityId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}