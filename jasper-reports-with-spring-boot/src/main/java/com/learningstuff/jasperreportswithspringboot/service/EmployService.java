package com.learningstuff.jasperreportswithspringboot.service;

import com.learningstuff.jasperreportswithspringboot.model.Employee;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ১৯/৯/১৯
 * Time: ৮:৫০ PM
 * Mail: mdshamim723@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

@Service
public class EmployService {

    private final String reportPath = Paths.get("src/main/resources/reports").toAbsolutePath().toString();


    private List<Employee> empList = Arrays.asList(
            new Employee(1, "Roni", "Uttara", 200000),
            new Employee(2, "Rajon", "Airport", 100000),
            new Employee(3, "Sourav", "Kollanpur", 75000),
            new Employee(4, "Roni", "Notan Bazar", 20000)
    );

    public String generateReport() {


        try {

            // Compile the Jasper report from .jrxml to .japser
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "/employee-rpt.jrxml");

            // Get your data source
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(empList);

            // Add parameters
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "Shamim");

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    jrBeanCollectionDataSource);

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "/Emp-Rpt.pdf");

            System.out.println("Done");

            return "Report successfully generated @path= " + reportPath;

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public JasperPrint generateReportExport() {

        JasperPrint jasperPrint = null;

        try {

            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "/employee-rpt.jrxml");

            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(empList);

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "Md Shamim");

            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jasperPrint;

    }

    public byte[] generateReportExportToByte() throws JRException {
        return JasperExportManager.exportReportToPdf(generateReportExport());
    }

}
