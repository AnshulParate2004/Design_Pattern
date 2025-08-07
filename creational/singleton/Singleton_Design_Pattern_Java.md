# 🧠 Singleton Design Pattern in Java

The **Singleton Design Pattern** is a creational pattern that ensures a class has **only one instance** and provides a **global access point** to it.

---

## 🔧 When to Use

- When exactly **one instance** of a class is needed across the application.
- To manage **shared resources** like configuration objects, logging, thread pools, etc.

---

## 🧪 Core Intent

> Ensure a class has only one instance, and provide a global point of access to it.

---

## 🎯 Key Concepts

- **Private constructor** to prevent external instantiation.
- **Static instance** variable to hold the singleton.
- **Public static method** to access the instance.

---

## 📄 Basic Singleton (Non-thread-safe)

```java
public class Singleton {
    private static Singleton instance;

    private String data;
    private int num;

    private Singleton() { }

    private Singleton(String data, int num) {
        this.data = data;
        this.num = num;
    }

    public static Singleton getInstance(String data, int num) {
        if (instance == null) {
            instance = new Singleton(data, num);
        }
        return instance;
    }
}
```

### ⚠️ Limitation

- **Not thread-safe**. Multiple threads calling `getInstance()` simultaneously can create multiple instances.

---

## 🔐 Thread-Safe Singleton (Double-Checked Locking)

```java
public class SyncSingleton {
    private static volatile SyncSingleton instance;

    private String data;
    private int num;

    private SyncSingleton() { }

    private SyncSingleton(String data, int num) {
        this.data = data;
        this.num = num;
    }

    public static SyncSingleton getInstance(String data, int num) {
        if (instance == null) {
            synchronized (SyncSingleton.class) {
                if (instance == null) {
                    instance = new SyncSingleton(data, num);
                }
            }
        }
        return instance;
    }
}
```

### ✅ Why Double-Checked Locking?

- Reduces overhead of synchronized access.
- Ensures only the first thread creates the instance.
- All other threads skip synchronization once the instance is created.

### 📌 Role of `volatile`

- Prevents **instruction reordering** and ensures **visibility** across threads.

---

## 🧊 Alternatives to Singleton

### 1. Static Holder Pattern

```java
public class HolderSingleton {
    private String data;
    private int num;

    private HolderSingleton() { }

    private static class Holder {
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

- ✅ Thread-safe
- ✅ Lazy-loaded
- ✅ No synchronization needed

### 2. Enum Singleton

```java
public enum EnumSingleton {
    INSTANCE;

    private String data;

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
```

- ✅ Thread-safe
- ✅ Handles serialization & reflection issues automatically
- ✅ Simplest, most robust form of singleton in Java

---

## 📉 Limitations of Singleton

| Issue                        | Description |
|-----------------------------|-------------|
| Global state                | Can act like a hidden global variable |
| Difficult to test           | Hard to mock or replace |
| Parameter confusion         | Only first call’s parameters used |
| Thread safety complexity    | Must be explicitly handled (unless using enum) |

---

## ✅ Best Practices

- Prefer **enum singleton** in most real-world Java applications.
- Avoid using parameters for `getInstance()` unless absolutely needed.
- If using classic pattern, ensure **thread safety** with double-checking or static holder.

---

## 🧠 Summary Table

| Version         | Thread-safe | Lazy-loaded | Simple | Notes |
|----------------|-------------|-------------|--------|-------|
| Basic           | ❌          | ✅           | ✅     | Not for multi-threaded apps |
| Sync (DCL)      | ✅          | ✅           | ⚠️     | Needs `volatile` |
| Static Holder   | ✅          | ✅           | ✅     | Best classic pattern |
| Enum            | ✅          | ✅           | ✅     | Best for most Java use cases |

---

## 🛠️ Use Cases

- Logger
- Configuration manager
- Database connection pool manager
- Caches

---

### 🔚 Conclusion

The Singleton pattern is simple but powerful when used correctly. Be aware of its pitfalls and choose the appropriate implementation based on the application’s complexity and concurrency needs.

