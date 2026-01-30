# AION2meter-TW(RUS)

**Это не оригинальный DPS-метр, а лишь перевод уже созданного ранее. Ничего в коде не изменено и меняться не будет.**

Инструмент для анализа урона для **AION 2**. Оригинал - [Aion2-Dps-Meter](https://github.com/TK-open-public/Aion2-Dps-Meter). Перевод этого форка - [Aion2-Dps-Meter](https://github.com/taengu/Aion2-Dps-Meter)

🔗 **GitHub Repository:** https://github.com/taengu/Aion2-Dps-Meter  
💬 **Discord (Support & Community): https://discord.gg/Aion2Global**

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> **Важно!**  
> Этот проект будет **приостановлен или сделан приватным** по запросу разработчика игры, в случае введения шифрования пакетов или других контрмер, а также в случае появления официального заявления, запрещающего его использование.

---

## Установка.

1. Установите **Npcap**:  
   https://npcap.com/#download  
   - Ты **должен** поставить галочку **“Install Npcap in WinPcap API-compatible Mode”**

2. Скачай последний релиз:  
   👉 https://github.com/Vuradu/Aion2-Dps-Meter-RUS-/releases

3. Если AION 2 уже запущен, **перейди на экран выбора персонажа**.

4. Запусти `aion2meter-tw.exe` **от администратора** *(по дефолту устанавливается в C:\Program Files\aion2meter-tw)*

5. Если появится UI, приложение запущено успешно.

6. Если DPS метр не появился:
   - Телепортируйся используя **киск**, **убежище** или зайди\выйди в данж
   - Затем повтори шаги **3–4**

7. Если счетчик перестал работать после того, как ранее функционировал:
   - Телепортируйся или снова войди в подземелье, чтобы обновить захват пакетов.
   - Если не помогло, начни с шага **3**

---

## Объяснение интерфейса.

- **Blue box** – Monster name display (planned)
- **Brown box** – Reset current combat data
- **Pink box** – Expand / collapse DPS meter
- **Red box** – Class icon (shown when detected)
- **Orange box** – Player nickname (click for details)
- **Light blue box** – DPS for current target
- **Purple box** – Contribution percentage
- **Green box** – Combat timer  
  - Green: in combat  
  - Yellow: no damage detected (paused)  
  - Grey: combat ended

Clicking a player row opens detailed statistics.

> **Hit count** refers to **successful hits**, not skill casts.


---

## FAQ

**Q: What's different from the original meter?**
- The original was written for KR servers and uses a hard-coded method for finding game packets.
- This version adds auto-detection and support for VPNs/Ping Reducers. It also has been translated to English skills/spells and UI.


**Q: The UI appears, but no damage is shown.**  
- Verify Npcap installation  
- Exit the app, go to character select, then relaunch

**Q: I see DPS from others but not myself.**  
- DPS is calculated based on the monster with the highest total damage  
- Use the same training dummy as the player(s) already showing on the meter.

**Q: Contribution is not 100% while solo.**  
- Name capture may have failed

**Q: Are chat or command features supported?**  
- Not currently

**Q: Hit count is higher than skill casts.**  
- Multi-hit skills count each hit separately

**Q: Some skills show as numbers.**  
- These are usually Theostones  
- Report others via GitHub Issues

---

## Download

👉 https://github.com/taengu/Aion2-Dps-Meter/releases

Please do not harass players based on DPS results.  
Use at your own risk.

---

## Community & Support

- 💬 **Join our Discord:** https://discord.gg/Aion2Global
- ☕ [Buy me a Coffee](https://ko-fi.com/hiddencube)
- 🎁 [Donate with Crypto](https://nowpayments.io/donation/thehiddencube)
