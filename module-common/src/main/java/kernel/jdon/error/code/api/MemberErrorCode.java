package kernel.jdon.error.code.api;

import org.springframework.http.HttpStatus;

import kernel.jdon.error.code.ErrorCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
	NOT_FOUND_JOB_CATEGORY(HttpStatus.NOT_FOUND, "존재하지 않는 직군 또는 직무입니다."),
	UNAUTHORIZED_EMAIL_OAUTH2(HttpStatus.UNAUTHORIZED, "이메일 인증에 실패하였습니다."),
	SERVER_ERROR_DECRYPTION(HttpStatus.INTERNAL_SERVER_ERROR, "복호화 과정에 실패하였습니다."),
	SERVER_ERROR_PARSE_QUERY_STRING(HttpStatus.INTERNAL_SERVER_ERROR, "쿼리스트링 파싱에 실패하였습니다."),
	NOT_FOUND_SKILL(HttpStatus.NOT_FOUND, "존재하지 않는 기술 스킬입니다."),
	NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다.");

	private final HttpStatus httpStatus;
	private final String message;

	@Override
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	@Override
	public String getMessage() {
		return message;
	}
}

