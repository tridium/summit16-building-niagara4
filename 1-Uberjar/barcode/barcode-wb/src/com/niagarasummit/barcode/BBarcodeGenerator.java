package com.niagarasummit.barcode;

import javax.baja.gx.Graphics;
import javax.baja.gx.BImage;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.ui.BWidget;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraSlots;
import javax.baja.nre.annotations.NiagaraType;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.lang.Override;
import java.text.DecimalFormat;

import org.krysalis.barcode4j.BarcodeDimension;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

@NiagaraType
@NiagaraProperty(name="value", type="double", defaultValue="0")
@NiagaraProperty(name="text", type="String", defaultValue="")

public class BBarcodeGenerator
  extends BWidget
{
  public BBarcodeGenerator()  {  }

  @Override
  public void paint(Graphics g)
  {
    try
    {
      //Create the barcode bean
      Code39Bean bean = new Code39Bean();

      //Configure the barcode generator
      final int dpi = 150;
      bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar width exactly one pixel
      bean.setWideFactor(3);
      bean.doQuietZone(false);

      //Initialize the text for the barcode
      String barcodeText = df3.format(getValue());

      //Set up the barcode canvas provider for monochrome JPEG output
      ByteArrayOutputStream out = new ByteArrayOutputStream(8*1024);
      BitmapCanvasProvider canvas = new BitmapCanvasProvider(
        out, "image/jpeg", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

      //Generate the barcode
      bean.generateBarcode(canvas, barcodeText);

      //Signal end of generation
      canvas.finish();

      // Paint the image
      BarcodeDimension size = bean.calcDimensions(barcodeText);
      double w = size.getWidth();
      double h = size.getHeight();
      g.drawImage(BImage.make(out.toByteArray()), w, h);

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  private static DecimalFormat df3 = new DecimalFormat("000.000");
}