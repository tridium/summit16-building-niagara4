package testng.niagarasummit.barcode;

import com.niagarasummit.barcode.BBarcodeNumeric;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import javax.baja.status.BStatusNumeric;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

public class BTestBarcodeNumeric
  extends BTestNg
{
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTestBarcodeNumeric.class);

  @Test//(expectedExceptions = NullPointerException.class)
  public void nullImage()
  {
    BBarcodeNumeric bcn = new BBarcodeNumeric();
    bcn.setOut(null);
    String image = bcn.getImageBuffer();
  }

  @Test(dataProvider = "valueProvider")
  public void generateImage(Double out)
  {
    BBarcodeNumeric bcn = new BBarcodeNumeric();
    bcn.setOut(new BStatusNumeric(out.doubleValue()));
    String image = bcn.getImageBuffer();
    Assert.assertNotNull(image);
  }

  @DataProvider(name="valueProvider")
  public Object[][] valueProvider()
  {
    return new Object[][] {
      { new Double(0) },
      { new Double(-100) },
      { new Double(200) },
      { new Double(123.766) }
    };
  }
}