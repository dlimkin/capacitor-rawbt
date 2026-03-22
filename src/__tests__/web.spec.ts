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

  it('should reject printBase64 on web with unavailable error', async () => {
    await expect(plugin.printBase64({ base64: 'SGVsbG8gUHJpbnRlciE=' })).rejects.toThrow(
      'RawBT printBase64 is only available on Android.',
    );
  });

  it('should reject printBase64 when called with empty base64', async () => {
    await expect(plugin.printBase64({ base64: '' })).rejects.toThrow(
      'RawBT printBase64 is only available on Android.',
    );
  });
});
