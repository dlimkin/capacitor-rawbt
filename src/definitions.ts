/**
 * Options for the print method.
 */
export interface PrintOptions {
  /**
   * The text content to print.
   *
   * @since 1.0.0
   */
  text: string;

  /**
   * Title shown in the app chooser dialog (Android only).
   *
   * @since 1.0.0
   */
  title?: string;

  /**
   * MIME type of the content, e.g. "text/plain".
   * Defaults to "text/plain".
   *
   * @since 1.0.0
   */
  mimetype?: string;
}

export interface RawBtPlugin {
  /**
   * Send text to the RawBT thermal printer app via Android Intent.
   * On web, throws an error (not supported).
   *
   * @since 1.0.0
   * @platform android
   */
  print(options: PrintOptions): Promise<void>;
}
