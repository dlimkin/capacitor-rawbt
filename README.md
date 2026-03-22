# capacitor-rawbt

Capacitor plugin for printing via RawBT thermal printer app

## Install

```bash
npm install capacitor-rawbt
npx cap sync
```

> The plugin is auto-discovered by Capacitor — no changes to `MainActivity.kt` are needed.

## Usage

### Send plain text

```typescript
import { RawBt } from 'capacitor-rawbt';

await RawBt.print({ text: 'Hello, thermal printer!\n' });
```

### Send raw ESC/POS commands (base64)

```typescript
import { RawBt } from 'capacitor-rawbt';

// Your ESC/POS byte array encoded to base64
const base64data = btoa(String.fromCharCode(...escPosBytes));

await RawBt.printBase64({ base64: base64data });
```

> **Note:** Both methods are Android-only. Calling them on web will throw an error.

## API

<docgen-index>

* [`print(...)`](#print)
* [`printBase64(...)`](#printbase64)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### print(...)

```typescript
print(options: PrintOptions) => Promise<void>
```

Send plain text to the RawBT thermal printer app.
The text is UTF-8 encoded to Base64 internally and sent via the `rawbt:base64,{data}` Android Intent URI scheme.
On web, throws an error (not supported).

| Param         | Type                                                    |
| ------------- | ------------------------------------------------------- |
| **`options`** | <code><a href="#printoptions">PrintOptions</a></code>   |

**Since:** 1.0.0

--------------------


### printBase64(...)

```typescript
printBase64(options: PrintBase64Options) => Promise<void>
```

Send pre-encoded Base64 data to the RawBT thermal printer app via the `rawbt:base64,{data}` Android Intent URI scheme.
Use this when you need to send raw ESC/POS commands.
On web, throws an error (not supported).

| Param         | Type                                                                  |
| ------------- | --------------------------------------------------------------------- |
| **`options`** | <code><a href="#printbase64options">PrintBase64Options</a></code>     |

**Since:** 1.0.0

--------------------


### Interfaces


#### PrintOptions

| Prop       | Type                | Description                                                      | Since |
| ---------- | ------------------- | ---------------------------------------------------------------- | ----- |
| **`text`** | <code>string</code> | Plain text to print. UTF-8 encoded to Base64 before sending.    | 1.0.0 |


#### PrintBase64Options

| Prop         | Type                | Description                                       | Since |
| ------------ | ------------------- | ------------------------------------------------- | ----- |
| **`base64`** | <code>string</code> | Base64-encoded content to send to the RawBT app. | 1.0.0 |

</docgen-api>
