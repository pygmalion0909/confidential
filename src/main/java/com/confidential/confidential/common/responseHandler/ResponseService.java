package com.confidential.confidential.common.responseHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
  
  /**
   * @TITLE response ok
   */
  public ResponseEntity<ResponseDto> ok(HttpStatus status) {
    return new ResponseEntity<ResponseDto>(new ResponseDto(status.value(), LocalDateTime.now()), status);
  }

  /**
   * @TITLE response ok(with data)
   */
  public ResponseEntity<ResponseDto> ok(Map<String, Object> data, HttpStatus status) {
    return new ResponseEntity<ResponseDto>(new ResponseDto(status.value(), LocalDateTime.now(), data), status);
  }

  /**
   * @TITLE response error
   */
  public ResponseEntity<ResponseDto> error(ResponseCode resCd, HttpStatus status) {
		return new ResponseEntity<ResponseDto>(new ResponseDto(status.value(), LocalDateTime.now(), new ErrorDto(resCd.code, resCd.message)), status);
  }
	
  /**
   * @TITLE response error(with error list)
   */
  public ResponseEntity<ResponseDto> error(ResponseCode resCd, List<Object> errList, HttpStatus status) {
		return new ResponseEntity<ResponseDto>(new ResponseDto(status.value(), LocalDateTime.now(), new ErrorDto(resCd.code, resCd.message, errList)), status);
  }

}