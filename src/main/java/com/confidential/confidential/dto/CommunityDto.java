package com.confidential.confidential.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommunityDto {

  private Long communityId;
  private Long memberBasId;
  private String categoryCode;
  private String title;
  private String contents;
  private int view;
  private String createDate;
  private String modifyDate;
  
}
