┌─────────────────────────────────────────────────────────┐
│                    FRAMEWORK TCP                         │
├─────────────────────────────────────────────────────────┤
│                                                          │
│  ❄️ FROZEN SPOTS (No se modifican)                      │
│  ├── startLoop() - estructura del loop                  │
│  ├── acceptAndDisplaySocket() - acepta conexiones       │
│  └── displaySocketInformation() - muestra info          │
│                                                          │
│  🔥 HOTSPOTS (Se personalizan)                          │
│  ├── handleMessage() - abstracto (OBLIGATORIO)          │
│  ├── getClosingWord() - hook (OPCIONAL)                 │
│  ├── beforeHandlingMessage() - hook (OPCIONAL)          │
│  └── afterHandlingMessage() - hook (OPCIONAL)           │
│                                                          │
└─────────────────────────────────────────────────────────┘