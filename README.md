# capacitor-rawbt

Capacitor plugin for printing via RawBT thermal printer app

## Install

To use npm

```bash
npm install capacitor-rawbt
```

To use yarn

```bash
yarn add capacitor-rawbt
```

Sync native files

```bash
npx cap sync
```

> The plugin is auto-discovered by Capacitor — no changes to `MainActivity.kt` are needed.

## Usage

```typescript
import { RawBt } from 'capacitor-rawbt';

// Encode your content to Base64 before sending
const base64data = btoa('Hello, thermal printer!');

await RawBt.printBase64({ base64: base64data });
```

> **Note:** This plugin is Android-only. Calling `printBase64()` on web will throw an error.

## API

<docgen-index>

* [`printBase64(...)`](#printbase64)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### printBase64(...)

```typescript
printBase64(options: PrintBase64Options) => Promise<void>
```

Send base64-encoded data to the RawBT thermal printer app via Android Intent
using the `rawbt:base64,{data}` URI scheme.
On web, throws an error (not supported).

| Param         | Type                                                          |
| ------------- | ------------------------------------------------------------- |
| **`options`** | <code><a href="#printbase64options">PrintBase64Options</a></code> |

**Since:** 1.0.0

--------------------


### Interfaces


#### PrintBase64Options

Options for the printBase64 method.

| Prop         | Type                | Description                                         | Since |
| ------------ | ------------------- | --------------------------------------------------- | ----- |
| **`base64`** | <code>string</code> | Base64-encoded content to send to the RawBT app.   | 1.0.0 |

</docgen-api>
