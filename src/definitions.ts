/**
 * Options for the print method.
 */
export interface PrintOptions {
  /**
   * Plain text content to print. Will be UTF-8 encoded and sent to RawBT
   * via the `rawbt:base64,{data}` URI scheme.
   *
   * @since 1.0.0
   */
  text: string;
}

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
   * Send plain text to the RawBT thermal printer app.
   * The text is UTF-8 encoded to Base64 internally and sent via
   * the `rawbt:base64,{data}` Android Intent URI scheme.
   * On web, throws an error (not supported).
   *
   * @since 1.0.0
   * @platform android
   */
  print(options: PrintOptions): Promise<void>;

  /**
   * Send pre-encoded Base64 data to the RawBT thermal printer app via
   * the `rawbt:base64,{data}` Android Intent URI scheme.
   * Use this when you need to send raw ESC/POS commands.
   * On web, throws an error (not supported).
   *
   * @since 1.0.0
   * @platform android
   */
  printBase64(options: PrintBase64Options): Promise<void>;
}
