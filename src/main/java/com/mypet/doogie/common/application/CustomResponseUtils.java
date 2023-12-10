package com.mypet.doogie.common.application;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.http.HttpStatus;

public class CustomResponseUtils {

    public static <T> CustomResponse<T> success(T data) {
        return new CustomResponse<>("SUCCESS", data, HttpStatus.OK.value());
    }

    public static <T> CustomResponse<T> success(T data, int statusCode) {
        return new CustomResponse<>("SUCCESS", data, statusCode);
    }

    public static CustomResponse<?> error(String message, int statusCode) {
        return new CustomResponse<>(message, null, statusCode);
    }

    @Getter
    public static class CustomResponseError {
        private final String message;
        private final int statusCode;

        CustomResponseError(Throwable throwable, HttpStatus statusCode) {
            this(throwable.getMessage(), statusCode);
        }

        CustomResponseError(String message, HttpStatus statusCode) {
            this.message = message;
            this.statusCode = statusCode.value();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("message", message)
                    .append("statusCode", statusCode)
                    .toString();
        }
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CustomResponse<T> {
        private final String message;
        private final T data;
        private final int statusCode;

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("message", message)
                    .append("data", data)
                    .append("statusCode", statusCode)
                    .toString();
        }
    }
}