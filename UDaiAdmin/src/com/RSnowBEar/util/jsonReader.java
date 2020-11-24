package com.RSnowBEar.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jsonReader<T> {
    public Object getMessage(HttpServletRequest request,Class<T> tClass) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        ObjectMapper mapper = new ObjectMapper();
        Object t = mapper.readValue(sb.toString(),tClass);
        return t;
    }
}
