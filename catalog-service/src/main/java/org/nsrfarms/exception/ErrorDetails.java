package org.nsrfarms.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	private LocalDateTime timesStamp;
	private String message;
	private String path;
	private String errorCode;

}
