package com.enjo_eat_spring.enjo_eat_spring.common.repsonse;

import lombok.*;

import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SuccessResponse<T> {
    private T result;
    private int resultCode;
    private String resultMsg;

    @Builder
    protected SuccessResponse(final SuccessCode code){
        this.resultCode = code.getStatus();
        this.resultMsg = code.getMessage();
    }

    @Builder
    protected SuccessResponse(final SuccessCode code, final T result){
        this.result = result;
        this.resultCode = code.getStatus();
        this.resultMsg = code.getMessage();
    }

    @Builder
    public static <T> SuccessResponse<T> of(final SuccessCode code){
        return new SuccessResponse<>(code);
    }

    @Builder
    public static <T> SuccessResponse<T> of(final SuccessCode code, final T result){
        return new SuccessResponse<>(code, result);
    }

}
