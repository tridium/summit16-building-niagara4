package com.niagarasummit.barcode.ui;

import com.niagarasummit.barcode.BBarcodeNumeric;
import javax.baja.sys.BDouble;
import javax.baja.sys.BString;
import javax.baja.ui.BValueBinding;
import javax.baja.sys.BValue;
import javax.baja.sys.Property;
import javax.baja.sys.BObject;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import javax.baja.nre.annotations.NiagaraType;

@NiagaraType

/**
 * BBarcodeBinding implements the binding between the BarcodeNumeric point and the BarcodeGenerator widget.
 */
public class BBarcodeBinding
  extends BValueBinding
{
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBarcodeBinding.class);
  @Override
  public BValue getOnWidget(Property prop)
  {
    BObject from = get();
    if (from instanceof BBarcodeNumeric)
    {
      String name = prop.getName();
      if (name.equals("imageBuffer"))
      {
        return BString.make(((BBarcodeNumeric)from).getImageBuffer());
      }
      if (name.equals("barcodeHeight"))
      {
        return BDouble.make(((BBarcodeNumeric)from).getBarcodeHeight());
      }
      if (name.equals("barcodeWidth"))
      {
        return BDouble.make(((BBarcodeNumeric)from).getBarcodeWidth());
      }
    }
    return super.getOnWidget(prop);
  }
}

