package com.learningstuff.jasperreportswithspringboot.controller;

import com.learningstuff.jasperreportswithspringboot.service.EmployService;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ১৯/৯/১৯
 * Time: ৯:২৮ PM
 * Mail: mdshamim723@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

@AllArgsConstructor
@Controller
public class EmployeeController {

    private final EmployService employService;

    @GetMapping(value = "/pdf")
    public void export(HttpServletResponse response) throws IOException, JRException {

        response.setContentType("application/pdf");
//        response.setHeader("Content-Disposition", String.format("attachment; filename=\"employee.pdf\""));
        response.setHeader("Content-Disposition", String.format("inline; filename=\"employee.pdf\""));

        OutputStream out = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(employService.generateReportExport(), out);
    }

    @GetMapping(value = "/pdf-one", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<?> exportToPdf() throws JRException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"output.pdf\"");

        return ResponseEntity.ok().headers(httpHeaders).body(employService.generateReportExportToByte() );
    }

}
