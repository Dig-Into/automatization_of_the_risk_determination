package aord.controller.handler;

import javax.persistence.EntityNotFoundException;
import org.springframework.security.access.AccessDeniedException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { Throwable.class })
	protected @ResponseBody ResponseEntity<Object> handleInternalException(Exception ex, WebRequest request) {

		final String errorMessage = ex.getMessage();
		HttpStatus status = HttpStatus.BAD_REQUEST; // default value

		if (ex instanceof EntityNotFoundException) {  // add specific exception statuses
			status = HttpStatus.NOT_FOUND;
		} else if (ex instanceof AccessDeniedException) {
			status = HttpStatus.FORBIDDEN;
		}

		log.error("exception: {}, cause: {}, message: {}", ex.toString(), ex.getCause(), ex.getMessage());

		return handleExceptionInternal(ex,
				ErrorMessageBuilder.buildMessage(errorMessage, status.value(), ex.getClass().getSimpleName()),
				new HttpHeaders(), status, request);
	}
}
