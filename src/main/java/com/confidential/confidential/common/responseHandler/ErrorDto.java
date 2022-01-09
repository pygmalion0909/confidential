package com.confidential.confidential.common.responseHandler;

import java.util.List;

import lombok.Getter;

@Getter
public class ErrorDto {

  private String code;
  private String message;
  private List<Object> list;
  
  protected ErrorDto(String code, String message) {
    this.code = code;
    this.message = message;
  }

  protected ErrorDto(String code, String message, List<Object> list) {
    this.code = code;
    this.message = message;
    this.list = list;
  } 

}