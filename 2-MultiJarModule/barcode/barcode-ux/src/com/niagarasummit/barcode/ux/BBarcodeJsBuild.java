package com.niagarasummit.barcode.ux;

import javax.baja.naming.BOrd;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.js.BJsBuild;

/**
 * BBarcodeJsBuild maps the barcode module to the minifies JavaScript file for Bajaux.
 */
public class BBarcodeJsBuild extends BJsBuild
{
  public static final BBarcodeJsBuild INSTANCE = new BBarcodeJsBuild(
    "barcode",
    new BOrd[] {
      BOrd.make("module://barcode/rc/barcode.built.min.js")
    }
    // If a new Type[] is needed here, enable the 3-argument constructor
  );

  public static final Type TYPE = Sys.loadType(BBarcodeJsBuild.class);

  @Override
  public Type getType() { return TYPE; }

  private BBarcodeJsBuild(String id, BOrd[] files) {
    super(id, files);
  }
}
