package org.example.springrest.util;

import jakarta.servlet.http.HttpServletResponse;
import org.example.springrest.domain.response.RestResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class FormatRestResponse implements ResponseBodyAdvice {

    @Override
    // trả ra true => before body write
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body, // dữ liệu khi chưa format
            MethodParameter returnType, // kiểu trả về của phương thức
            MediaType selectedContentType, // Tham số chứa kiểu nội dung (content type) đã được chọn.
            Class selectedConverterType, // Tham số chứa loại converter được sử dụng để chuyển đổi dữ liệu.
            ServerHttpRequest request, //  Tham số chứa thông tin về yêu cầu HTTP hiện tại.
            ServerHttpResponse response // Tham số chứa thông tin về phản hồi HTTP sẽ được trả về.
    ) {
        HttpServletResponse servletResponse = ((ServletServerHttpResponse) response).getServletResponse();
        int status = servletResponse.getStatus();

        RestResponse<Object> restResponse = new RestResponse<>();
        restResponse.setStatus(status);

        if(body instanceof String) {
            return body;
        }

        if (status >= 400) {
            // case error
            restResponse.setErrorMessage("Bad Request");
            restResponse.setMessage("CALL API FAILED");
            restResponse.setData(body);
        } else {
            // case success
            restResponse.setMessage("CALL API SUCCEEDED");
            if (status == 201)
                restResponse.setMessage("Created Successfully");
            restResponse.setData(body);
        }

        return restResponse;
    }
}
