package excelCreator;

import org.apache.commons.math3.random.RandomAdaptor;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ExcelCreator {
    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        /* Create a worksheet object for the line chart. This worksheet will contain the chart */
        XSSFSheet workSheet = workbook.createSheet("Last lesson report");

        XSSFRow row;
        LocalDateTime localDate = LocalDateTime.now();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            row = workSheet.createRow(i);
            createCell(row, 0, i + 1);
            createCell(row, 1, Date.from(localDate.plusSeconds(random.nextInt(30) + 5).atZone(ZoneId.systemDefault()).toInstant()).toString());
        }


        XSSFDrawing xlsx_drawing = workSheet.createDrawingPatriarch();
        // Define anchor points in the worksheet to position the chart
        XSSFClientAnchor anchor = xlsx_drawing.createAnchor(0, 0, 0, 0, 2, 15, 12, 30);
        // Create the chart object based on the anchor point
        XSSFChart my_line_chart = xlsx_drawing.createChart(anchor);
        // Define legends for the line chart and set the position of the legend
        XSSFChartLegend legend = my_line_chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.BOTTOM);
        // Create data for the chart
        LineChartData data = my_line_chart.getChartDataFactory().createLineChartData();
        // Define chart AXIS
        ChartAxis bottomAxis = my_line_chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = my_line_chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
        /* Define Data sources for the chart */
        /* Set the right cell range that contain values for the chart */
        /* Pass the worksheet and cell range address as inputs */
        /* Cell Range Address is defined as First row, last row, first column, last column */
        ChartDataSource<Number> ys = DataSources.fromNumericCellRange(workSheet, new CellRangeAddress(0, 10, 1, 1));
        ChartDataSource<String> xs1 = DataSources.fromStringCellRange(workSheet, new CellRangeAddress(0, 10, 0, 0));

        // Add chart data sources as data to the chart
        LineChartSeries lineChartSeries = data.addSeries(xs1, ys);
        lineChartSeries.setTitle("слова с ошибками");
        //Plot the chart with the inputs from data and chart axis
        my_line_chart.plot(data, new ChartAxis[]{bottomAxis, leftAxis});
        try (FileOutputStream fileOut = new FileOutputStream("report.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createCell(XSSFRow row, int index, String value) {
        XSSFCell cell = row.createCell(index);

        cell.setCellValue(value);
    }

    private static void createCell(XSSFRow row, int index, double value) {
        XSSFCell cell = row.createCell(index);

        cell.setCellValue(value);
    }

}
