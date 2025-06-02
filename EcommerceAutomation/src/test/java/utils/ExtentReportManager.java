package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports createInstance(String reportFilePath) {
        ExtentSparkReporter spark = new ExtentSparkReporter(reportFilePath);
        spark.config().setReportName("Automation Test Report");
        spark.config().setDocumentTitle("Automation Exercise Test Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Hrishikesh Dahule");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Project", "AutomationExercise");

        return extent;
    }
}
