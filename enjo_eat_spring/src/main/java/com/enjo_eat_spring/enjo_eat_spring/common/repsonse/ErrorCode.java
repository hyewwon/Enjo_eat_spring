package com.enjo_eat_spring.enjo_eat_spring.common.repsonse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST_ERROR(400, "G001", "Bad Request Exception"),
    REQUEST_BODY_MISSING_ERROR(400, "G002", "Required request body is missing"),
    INVALID_TYPE_VALUE(400, "G003", " Invalid Type Value"),
    MISSING_REQUEST_PARAMETER_ERROR(400, "G004", "Missing Servlet RequestParameter Exception"),
    IO_ERROR(400, "G005", "I/O Exception"),
    JSON_PARSE_ERROR(400, "G006", "JsonParseException"),
    JACKSON_PROCESS_ERROR(400, "G007", "com.fasterxml.jackson.core Exception"),
    FORBIDDEN_ERROR(403, "G008", "Forbidden Exception"),
    NOT_FOUND_ERROR(404, "G009", "Not Found Exception"),
    NULL_POINT_ERROR(404, "G010", "Null Point Exception"),
    NOT_VALID_ERROR(404, "G011", "handle Validation Exception"),
    NOT_VALID_HEADER_ERROR(404, "G012", "Header에 데이터가 존재하지 않는 경우 "),
    INTERNAL_SERVER_ERROR(500, "G999", "Internal Server Error Exception"),
    INSERT_ERROR(200, "9999", "Insert Transaction Error Exception"),
    UPDATE_ERROR(200, "9999", "Update Transaction Error Exception"),
    DELETE_ERROR(200, "9999", "Delete Transaction Error Exception");

    private final int status;
    private final String divisionCode;
    private final String message;


}
