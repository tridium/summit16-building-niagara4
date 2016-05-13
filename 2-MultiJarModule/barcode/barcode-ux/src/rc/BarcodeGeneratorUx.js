
define(['baja!',
        'jquery',
        'nmodule/webEditors/rc/fe/baja/BaseEditor',
        'Promise',
        'nmodule/webEditors/rc/util/htmlUtils',
        'bajaux/mixin/subscriberMixIn'], function (
        baja,
        $,
        BaseEditor,
        Promise,
        htmlUtils,
        subscriberMixIn) {

  'use strict';

  /**
   * A BarcodeGeneratorUx is the field editor for barcode:BarcodeNumeric.
   */

  var BarcodeGeneratorUx = function BarcodeGeneratorUx() {
    BaseEditor.apply(this, arguments);
    var that = this;
    var props = this.properties();
    that.properties().add({readonly: true});
    subscriberMixIn(that);
  };

  BarcodeGeneratorUx.prototype = Object.create(BaseEditor.prototype);
  BarcodeGeneratorUx.prototype.constructor = BarcodeGeneratorUx;

  BarcodeGeneratorUx.prototype.doInitialize = function (dom) {
    // Initialize the image class reference for the component display to use
    dom.html('<img class="barcodeImage" src="" width="200" height="150"/>');
  };
  
  BarcodeGeneratorUx.prototype.updateDisplay = function (arrayBuffer) {
    // Set the image source to the Base64-encoded string containing the JPG
    this.jq().find('.barcodeImage').attr('src', 'data:image/jpg;base64,' + arrayBuffer);
  };

  BarcodeGeneratorUx.prototype.doLoad = function (value) {
    var that = this;
    var arrayBuffer = value.getImageBuffer();

    // Get the contents of the imageBuffer property and generate a jpeg image to display
    this.updateDisplay(arrayBuffer);

    // Refresh the display each time the component changes value
    this.getSubscriber().attach('changed', function (prop) {
      if (prop.getName() === 'imageBuffer') {
        that.updateDisplay(this.get(prop));
      }
    });
  };

  return BarcodeGeneratorUx;
});
