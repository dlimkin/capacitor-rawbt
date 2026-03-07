# capacitor-rawbt

Capacitor plugin for printing via RawBT thermal printer app

## Install

To use npm

```bash
npm install capacitor-rawbt
````

To use yarn

```bash
yarn add capacitor-rawbt
```

Sync native files

```bash
npx cap sync
```

## Register the plugin

In your app's `MainActivity.kt`, register the plugin:

```kotlin
import com.rawbt.plugin.RawBtPlugin

class MainActivity : BridgeActivity() {
  override fun registerPlugins(bridge: Bridge) {
    super.registerPlugins(bridge)
    bridge.registerPlugin(RawBtPlugin::class.java)
  }
}
```

## Usage

```typescript
import { RawBt } from 'capacitor-rawbt';

await RawBt.print({
  text: 'Hello, thermal printer!',
  title: 'Print Receipt',    // optional
  mimetype: 'text/plain',    // optional, default: 'text/plain'
});
```

> **Note:** This plugin is Android-only. Calling `print()` on web will throw an error.

## API

<docgen-index>

* [`print(...)`](#print)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### print(...)

```typescript
print(options: PrintOptions) => Promise<void>
```

Send text to the RawBT thermal printer app via Android Intent.
On web, throws an error (not supported).

| Param         | Type                                                  |
| ------------- | ----------------------------------------------------- |
| **`options`** | <code><a href="#printoptions">PrintOptions</a></code> |

**Since:** 1.0.0

--------------------


### Interfaces


#### PrintOptions

Options for the print method.

| Prop           | Type                | Description                                                            | Since |
| -------------- | ------------------- | ---------------------------------------------------------------------- | ----- |
| **`text`**     | <code>string</code> | The text content to print.                                             | 1.0.0 |
| **`title`**    | <code>string</code> | Title shown in the app chooser dialog (Android only).                  | 1.0.0 |
| **`mimetype`** | <code>string</code> | MIME type of the content, e.g. "text/plain". Defaults to "text/plain". | 1.0.0 |

</docgen-api>
