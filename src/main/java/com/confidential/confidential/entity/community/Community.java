package com.confidential.confidential.entity.community;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class Community {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "community_id")
  private String communityId;

  @Column(name = "member_bas_id")
  private String memberBasId;

  @Column(name = "title")
  private String title;

  @Column(name = "contents")
  private String contents;

  @Column(name = "view")
  private int view;

  @Column(name = "create_date")
  private String createDate;

  @Column(name = "modify_date")
  private String modifyDate;

}