package com.xubh.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author xubh
 * @date 2018-03-14
 * @modify
 * @copyright
 */
@Controller
@RequestMapping(value = "/", params = {"Service=kec", "Action", "Version"}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class MyTestController {

    @RequestMapping(params = {"Action=CreateKey"})
    public void createKey(HttpServletRequest request, HttpServletResponse response) {
        String privatekey = "daf999jkljfdlksajflkadfadfxxxxxxxxxxxxxxxxlkjlkjljlkjlkjfadkjkfajlkdsjfkajsdlfj";
        OutputStream out = null;
        OutputStreamWriter writer = null;
        BufferedWriter bw = null;
        String fileName = "id_rsa";
        try {
            out = response.getOutputStream();
            writer = new OutputStreamWriter(out, "utf-8");
            bw = new BufferedWriter(writer);
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            bw.write(privatekey);

        } catch (Exception e) {
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
            }
        }
    }

    @RequestMapping(params = {"Action=CreateKey2"})
    public void createKey2(HttpServletRequest request, HttpServletResponse response) {
        String privatekey = "fdaf999jkljfdlksajflkadfadfxxxxxxxxxxxxxxxxlkjlkjljlkjlkjfadkjkfajlkdsjfkajsdlfj";
        String fileName = "id_rsa";
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        try {
            response.getWriter().write(privatekey);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(params = {"Action=CreateKey3"})
    public ResponseEntity<InputStreamResource> downloadFile() throws IOException {
        String fileName = "id_rsa";
        String privatekey = "徐fdaf999jkljfdlksajflkadfadfxxxxxxxxxxxxxxxxlkjlkjljlkjlkjfadkjkfajlkdsjfkajsdlfj";
        FileSystemResource file = new FileSystemResource("E:/cat/settings.xml");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok().headers(headers).contentLength(file.contentLength()).body(new InputStreamResource(file.getInputStream()));
    }

}
