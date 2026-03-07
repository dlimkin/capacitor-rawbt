import { RawBtWeb } from '../web';

describe('RawBtWeb', () => {
  let plugin: RawBtWeb;

  beforeEach(() => {
    plugin = new RawBtWeb();
  });

  it('should reject print on web with unavailable error', async () => {
    await expect(plugin.print({ text: 'Hello Printer!' })).rejects.toThrow(
      'RawBT print is only available on Android.',
    );
  });

  it('should reject print when called with all options', async () => {
    await expect(
      plugin.print({ text: 'Receipt', title: 'Print', mimetype: 'text/plain' }),
    ).rejects.toThrow('RawBT print is only available on Android.');
  });
});

