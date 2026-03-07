import { registerPlugin } from '@capacitor/core';

import type { RawBtPlugin } from './definitions';

const RawBt = registerPlugin<RawBtPlugin>('RawBt', {
  web: () => import('./web').then((m) => new m.RawBtWeb()),
});

export * from './definitions';
export { RawBt };
