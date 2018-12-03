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
import java.io.*;

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


    @RequestMapping(params = {"Action=CreateKey4"})
    public ResponseEntity<String> downloadFile1() throws IOException {
        String privatekey = "徐冰浩fdaf999jkljfdlksajflkadfadfxxxxxxxxxxxxxxxxlkjlkjljlkjlkjfadkjkfajlkdsjfkajsdlfj";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + "test");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok().headers(headers).body(privatekey);
    }

    @RequestMapping(params = {"Action=CreateKey5"})
    public ResponseEntity<InputStreamResource> downloadFile22( Long id)
            throws IOException {
        FileSystemResource file = new FileSystemResource("e:\\cat\\settings.xml");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

    @RequestMapping(params = {"Action=CreateKey6"})
    public ResponseEntity<byte[]> downloadFile2332( Long id)
            throws IOException {
        byte[] body = null;
        FileSystemResource file = new FileSystemResource("e:\\cat\\settings.xml");
        InputStream inputStream = file.getInputStream();
        try {
            body = new byte[inputStream.available()];
            inputStream.read(body);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        //"attachment;filename*=UTF-8''" + URLEncoder.encode(fileName,"UTF-8")
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(body);
    }
}
