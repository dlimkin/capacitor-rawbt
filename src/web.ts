import { WebPlugin } from '@capacitor/core';

import type { PrintOptions, RawBtPlugin } from './definitions';

export class RawBtWeb extends WebPlugin implements RawBtPlugin {
  async print(_options: PrintOptions): Promise<void> {
    throw this.unavailable('RawBT print is only available on Android.');
  }
}
