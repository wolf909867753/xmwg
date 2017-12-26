package com.xmwg.wq.utils;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationUtils {

    /**
     * 组装错误信息
     * @param result
     * @return
     */
    public static void validate(BindingResult result,Model model){
        if(null != result){
            List<FieldError> fieldErrors = result.getFieldErrors();
            if(null != fieldErrors && !fieldErrors.isEmpty()){
                for(FieldError fieldError : fieldErrors){
                    model.addAttribute(fieldError.getField(),fieldError.getDefaultMessage());
                }
            }
        }
    }
}
