package Implementación;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ReportesMethod {
    
   
    public void generarPDF() {
        Document pdf = new Document(PageSize.A4);
        try {
            PdfWriter writer = PdfWriter.getInstance(pdf, new FileOutputStream("C:\\Users\\HP\\Downloads\\reporte.pdf"));
            pdf.open();
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.A4.getWidth(), PageSize.A4.getHeight());

            //DIBUJO
            
            g.setColor(Color.red);
            //guia
            // g.drawRect(1, 1, 592, 839);

            // el logo
            ImageIcon imglogo = new ImageIcon("D:\\ESTUDIOS 2024\\CICLO 2\\Curso Integrador I\\PROYECTO\\AVANCE FINAL\\ProyectoIntegrador\\src\\main\\resources\\Imagenes\\logov1.png");
            g.drawImage(imglogo.getImage(), 225, 10, null);
            // el titulo
            g.setColor(Color.black);
            g.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
            g.drawString("Reporte General Para el Spa Urban Salon", 130, 180);

            g.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
            //Bar chart de servicios
            g.drawString("1. Gráfico de Ganancia de Servicios", 20, 200);
            ImageIcon imgChartServicios = new ImageIcon("D:\\ESTUDIOS 2024\\CICLO 2\\Curso Integrador I\\PROYECTO\\AVANCE FINAL\\ProyectoIntegrador\\src\\main\\resources\\Imagenes\\graficos\\graficoServicios.png");
            g.drawImage(imgChartServicios.getImage(), 40, 220, null);

            //Bar chart de experiencia
            g.drawString("2. Gráfico de Años de Experiencia", 20, 500);
            ImageIcon imgChartExperiencia = new ImageIcon("D:\\ESTUDIOS 2024\\CICLO 2\\Curso Integrador I\\PROYECTO\\AVANCE FINAL\\ProyectoIntegrador\\src\\main\\resources\\Imagenes\\graficos\\graficoExperiencia.png");
            g.drawImage(imgChartExperiencia.getImage(), 40, 520, null);

            g.dispose();
            pdf.newPage();
            g = cb.createGraphicsShapes(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            
            //Pie Chart de pagos
            g.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
            g.drawString("3. Gráfico de pagos", 20, 40);
            ImageIcon imgChartPagos = new ImageIcon("D:\\ESTUDIOS 2024\\CICLO 2\\Curso Integrador I\\PROYECTO\\AVANCE FINAL\\ProyectoIntegrador\\src\\main\\resources\\Imagenes\\graficos\\pagosTrabajador.png");
            g.drawImage(imgChartPagos.getImage(), 40, 60, null);

            g.dispose();
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        pdf.close();
        JOptionPane.showMessageDialog(null, "PDF exportado");
    }

}
