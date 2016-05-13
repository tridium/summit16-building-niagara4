package com.niagarasummit.barcode.ux;

import javax.baja.naming.BOrd;
import javax.baja.sys.BSingleton;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.BIFormFactorMini;
import javax.baja.web.js.BIJavaScript;
import javax.baja.web.js.JsInfo;

import java.lang.Override;
import java.text.DecimalFormat;

/**
 * BBarcodeGeneratorUx is a required singleton class for implementing the bajaux field editor.
 */
public class BBarcodeGeneratorUx
  extends BSingleton
  implements BIJavaScript, BIFormFactorMini
{
  @SuppressWarnings("unused")
  public static final BBarcodeGeneratorUx INSTANCE = new BBarcodeGeneratorUx();

  public static final Type TYPE = Sys.loadType(BBarcodeGeneratorUx.class);
  public Type getType() { return TYPE; }

  @Override
  public JsInfo getJsInfo(Context cx) {
    return JS_INFO;
  }

  private static final JsInfo JS_INFO = JsInfo.make(
    BOrd.make("module://barcode/rc/BarcodeGeneratorUx.js"),
    BBarcodeJsBuild.TYPE
  );

  private static DecimalFormat df3 = new DecimalFormat("000.000");
}