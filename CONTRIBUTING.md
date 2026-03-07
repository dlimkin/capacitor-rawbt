# Как опубликовать и использовать capacitor-rawbt

---

## Вариант 1 — Публикация на GitHub + установка через npm из GitHub

### 1. Создать репозиторий на GitHub

```bash
# На GitHub.com создайте новый репозиторий: capacitor-rawbt
# Затем привяжите локальный репозиторий:

git remote add origin https://github.com/dlimkin/capacitor-rawbt.git
git push -u origin main
```

### 2. Установить плагин в другой проект напрямую с GitHub

```bash
# Из ветки main:
npm install github:dlimkin/capacitor-rawbt

# Из конкретного тега/релиза:
npm install github:dlimkin/capacitor-rawbt#v1.0.0
```

---

## Вариант 2 — Публикация на npm (рекомендуется)

### 1. Зарегистрироваться / войти на npmjs.com

```bash
npm login
# Вводите: username, password, email, OTP (если включён 2FA)
```

### 2. Указать правильное имя пакета в package.json

Если хотите уникальное scoped-имя (рекомендуется):

```json
// package.json
{
  "name": "@ваш-npm-логин/capacitor-rawbt"
}
```

### 3. Опубликовать вручную

```bash
cd /home/drive/WORK/PROJECTS/android/capacitor-rawbt

# Собирает и публикует (prepublishOnly запускает npm run build автоматически)
npm publish --access public
```

### 4. Автоматическая публикация через GitHub Actions

Когда создаёте новый релиз на GitHub — workflow `publish.yml` сам публикует в npm.

**Настройка один раз:**
1. Зайдите на npmjs.com → Access Tokens → Generate New Token (Automation)
2. В репозитории GitHub → Settings → Secrets → Actions → New secret
   - Name: `NPM_TOKEN`
   - Value: токен с npmjs.com

После этого:
```bash
# Поднять версию
npm version patch   # 0.0.1 → 0.0.2
# или
npm version minor   # 0.0.1 → 0.1.0
# или  
npm version major   # 0.0.1 → 1.0.0

git push && git push --tags

# Затем на GitHub → Releases → Create new release → выбрать тег
# GitHub Actions автоматически соберёт и опубликует на npm
```

---

## Вариант 3 — npm link (локальная разработка без публикации)

Идеально когда плагин и приложение находятся на одной машине:

```bash
# 1. В директории плагина — зарегистрировать глобально
npm run build
npm link

# 2. В директории вашего Capacitor приложения — подключить
npm link capacitor-rawbt

# 3. Синхронизировать с нативным проектом
npx cap sync android
```

При изменениях в плагине достаточно:
```bash
npm run build   # dist/ обновится, изменения сразу видны в app
```

---

## Использование в TypeScript-проекте

### Установка (после публикации на npm)

```bash
npm install capacitor-rawbt
npx cap sync android
```

### Регистрация в MainActivity.kt

```kotlin
// android/app/src/main/java/.../MainActivity.kt
import com.rawbt.plugin.RawBtPlugin

class MainActivity : BridgeActivity() {
    override fun registerPlugins(bridge: Bridge) {
        super.registerPlugins(bridge)
        bridge.registerPlugin(RawBtPlugin::class.java)
    }
}
```

### Использование в TypeScript / Angular / React / Vue

```typescript
import { RawBt } from 'capacitor-rawbt';

// Простая печать
await RawBt.print({ text: 'Чек #1234\nИтого: 500 руб.' });

// Со всеми параметрами
await RawBt.print({
  text: 'Текст для печати',
  title: 'Печать через RawBT',   // заголовок диалога выбора
  mimetype: 'text/plain',         // MIME тип
});

// С обработкой ошибок
try {
  await RawBt.print({ text: 'Hello Printer!' });
  console.log('Отправлено на печать');
} catch (err) {
  console.error('Ошибка печати:', err);
}
```

### TypeScript типы (автоматически из пакета)

```typescript
import type { PrintOptions } from 'capacitor-rawbt';

const options: PrintOptions = {
  text: 'Текст',
  title: 'Заголовок',
  mimetype: 'text/plain',
};
```

---

## Процесс обновления плагина

```bash

# 1. Внести изменения в код
# 2. Запустить тесты
npm test
cd android && ./gradlew test && cd ..

# 3. Обновить версию
npm version patch

# 4. Запушить (CI проверит тесты)
git push && git push --tags

# 5. Создать GitHub Release → npm публикуется автоматически

# В проектах, использующих плагин:
npm update capacitor-rawbt
npx cap sync android
```
