/**
 * Options for the printBase64 method.
 */
export interface PrintBase64Options {
  /**
   * Base64-encoded content to send to the RawBT thermal printer app.
   *
   * @since 1.0.0
   */
  base64: string;
}

export interface RawBtPlugin {
  /**
   * Send base64-encoded data to the RawBT thermal printer app via Android Intent
   * using the `rawbt:base64,{data}` URI scheme.
   * On web, throws an error (not supported).
   *
   * @since 1.0.0
   * @platform android
   */
  printBase64(options: PrintBase64Options): Promise<void>;
}
