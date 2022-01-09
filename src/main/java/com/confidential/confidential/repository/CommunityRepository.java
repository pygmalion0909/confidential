package com.confidential.confidential.repository;

import java.util.List;

import com.confidential.confidential.entity.community.Community;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long>{
  
  List<Community> findAllByCategoryCode(String categoryCd, Sort sort);
  Community findByCommunityId(Long communityId);

}
