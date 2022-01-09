package com.confidential.confidential.common.responseHandler;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Getter;

@Getter
public class ResponseDto {

  private int status;
  private Map<String, Object> data;
  private ErrorDto error;
  private LocalDateTime responseTime;

  protected ResponseDto(int status, LocalDateTime responseTime) {
    this.status = status;
    this.responseTime = responseTime;
  }

  protected ResponseDto(int status, LocalDateTime responseTime, Map<String, Object> data) {
    this.status = status;
    this.responseTime = responseTime;
    this.data = data;
  }

  protected ResponseDto(int status, LocalDateTime responseTime, ErrorDto error) {
    this.status = status;
    this.responseTime = responseTime;
    this.error = error;
  }

}