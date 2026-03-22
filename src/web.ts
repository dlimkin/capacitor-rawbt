import { WebPlugin } from '@capacitor/core';

import type { PrintBase64Options, RawBtPlugin } from './definitions';

export class RawBtWeb extends WebPlugin implements RawBtPlugin {
  async printBase64(_options: PrintBase64Options): Promise<void> {
    throw this.unavailable('RawBT printBase64 is only available on Android.');
  }
}
