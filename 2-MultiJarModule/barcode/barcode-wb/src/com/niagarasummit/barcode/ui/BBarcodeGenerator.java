package com.niagarasummit.barcode.ui;

import javax.baja.gx.Graphics;
import javax.baja.gx.BImage;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.sys.BBlob;
import javax.baja.ui.BWidget;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;

import java.io.IOException;
import java.lang.Override;

@NiagaraType
@NiagaraProperty(name="imageBuffer", type="String", defaultValue="")
@NiagaraProperty(name="barcodeWidth", type="double", defaultValue="0")
@NiagaraProperty(name="barcodeHeight", type="double", defaultValue="0")

/**
 * BBarcodeGenerator displays the value of a BarcodeNumeric point as a barcode image widget.
 */
public class BBarcodeGenerator
  extends BWidget
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $BBarcodeGenerator(3601685469)1.0$ @*/
/* Generated Mon Apr 18 14:42:03 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "imageBuffer"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code imageBuffer} property.
   * @see #getImageBuffer
   * @see #setImageBuffer
   */
  public static final Property imageBuffer = newProperty(0, "", null);
  
  /**
   * Get the {@code imageBuffer} property.
   * @see #imageBuffer
   */
  public String getImageBuffer() { return getString(imageBuffer); }
  
  /**
   * Set the {@code imageBuffer} property.
   * @see #imageBuffer
   */
  public void setImageBuffer(String v) { setString(imageBuffer, v, null); }

////////////////////////////////////////////////////////////////
// Property "barcodeWidth"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code barcodeWidth} property.
   * @see #getBarcodeWidth
   * @see #setBarcodeWidth
   */
  public static final Property barcodeWidth = newProperty(0, 0, null);
  
  /**
   * Get the {@code barcodeWidth} property.
   * @see #barcodeWidth
   */
  public double getBarcodeWidth() { return getDouble(barcodeWidth); }
  
  /**
   * Set the {@code barcodeWidth} property.
   * @see #barcodeWidth
   */
  public void setBarcodeWidth(double v) { setDouble(barcodeWidth, v, null); }

////////////////////////////////////////////////////////////////
// Property "barcodeHeight"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code barcodeHeight} property.
   * @see #getBarcodeHeight
   * @see #setBarcodeHeight
   */
  public static final Property barcodeHeight = newProperty(0, 0, null);
  
  /**
   * Get the {@code barcodeHeight} property.
   * @see #barcodeHeight
   */
  public double getBarcodeHeight() { return getDouble(barcodeHeight); }
  
  /**
   * Set the {@code barcodeHeight} property.
   * @see #barcodeHeight
   */
  public void setBarcodeHeight(double v) { setDouble(barcodeHeight, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBarcodeGenerator.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public BBarcodeGenerator()  {  }

  @Override
  public void paint(Graphics g)
  {
    byte[] b = new byte[0];
    BBlob byteArray = BBlob.make(b);
    try
    {
      String resolvedImageBuffer = getImageBuffer();
      Double resolvedBarcodeWidth = getBarcodeWidth();
      Double resolvedBarcodeHeight = getBarcodeHeight();
      BBlob decodedBlob = (BBlob)byteArray.decodeFromString(resolvedImageBuffer);
      byte[] b2 = decodedBlob.copyBytes();
      g.drawImage(BImage.make(b2), resolvedBarcodeWidth, resolvedBarcodeHeight);
    }
    catch (IOException e)
    {
      // Do anything here?
    }
  }
}