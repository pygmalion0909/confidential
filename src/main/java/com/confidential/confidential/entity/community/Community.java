package com.confidential.confidential.entity.community;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Table(name = "tb_community_bas")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Community {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "community_id")
  private Long communityId;

  @Column(name = "member_bas_id")
  private Long memberBasId;

  @Column(name = "category_code")
  private String categoryCode;

  @Column(name = "title")
  private String title;

  @Column(name = "contents")
  private String contents;

  @Column(name = "view")
  private int view;

  @Column(name = "create_date")
  private LocalDateTime createDate;

  @Column(name = "modify_date")
  private LocalDateTime modifyDate;

  @Builder
  private Community(Long memberBasId, String categoryCode, String title, String contents) {
    this.memberBasId = memberBasId;
    this.categoryCode = categoryCode;
    this.title = title;
    this.contents = contents;
    this.createDate = LocalDateTime.now();
  }

  public void update(String categoryCode, String title, String contents) {
    this.categoryCode = categoryCode;
    this.title = title;
    this.contents = contents;
    this.modifyDate = LocalDateTime.now();
  }

}