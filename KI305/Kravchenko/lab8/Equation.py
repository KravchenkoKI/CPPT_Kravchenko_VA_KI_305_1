# module: Equation.py
# Лабораторна робота №8
# Автор: Кравченко В.А., група КІ305

"""
Ціль програми: реалізувати обчислення функції y = sin(x) / tg(4x),
забезпечити запис та зчитування результатів у текстовий і бінарний файли,
а також обробку типових помилок (некоректний ввід, ділення на нуль, відсутні файли).

Функції:
 - writeResTxt(fName, result)  — запис результату у текстовий файл
 - readResTxt(fName)           — читання результату з текстового файлу
 - writeResBin(fName, result)  — запис результату у двійковий файл (формат 'f')
 - readResBin(fName)           — читання результату з двійкового файлу (формат 'f')
 - calculate(x)                — обчислення y = sin(x) / tan(4x)

"""

import os
import struct
import sys
import math


def writeResTxt(fName, result):
    """
    Запис результату у текстовий файл.
    fName  — ім'я файлу (рядок)
    result — числовий результат (float)
    Файл створюється/перезаписується у поточному каталозі.
    """
    with open(fName, 'w') as f:
        f.write(str(result))


def readResTxt(fName):
    """
    Читання результату з текстового файлу.
    Якщо файл існує — повертає рядок, прочитаний з файлу.
    Якщо файлу немає — виводить повідомлення і повертає 0.0.
    """
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r') as f:
                result = f.read()
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result


def writeResBin(fName, result):
    """
    Запис результату у двійковий файл.
    Використовується формат 'f' (float, 4 байти) — як у демонстраційній програмі методички.
    fName  — ім'я файлу (рядок)
    result — числовий результат (float)
    """
    with open(fName, 'wb') as f:
        f.write(struct.pack('f', result))


def readResBin(fName):
    """
    Читання результату з двійкового файлу.
    Якщо файл існує — повертає розпаковане значення (float).
    Якщо файлу немає — виводить повідомлення і повертає 0.0.
    """
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                result = struct.unpack('f', f.read())[0]
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result


def calculate(x):
    """
    Обчислення функції за варіантом:
      y = sin(x) / tan(4x)

    Якщо знаменник дорівнює нулю — піднімає ZeroDivisionError.
    Параметри:
      x — число (float)
    Повертає:
      y — float
    """
    denominator = math.tan(4 * x)
    if denominator == 0:
        raise ZeroDivisionError("Ділення на нуль: tan(4x) = 0")
    return math.sin(x) / denominator


if __name__ == "__main__":
    try:
        data = float(input("Введіть x: "))
        result = calculate(data)
        print(f"Результат: y = {result}")

        writeResTxt("textRes.txt", result)
        writeResBin("binRes.bin", result)

        print("Результат із binRes.bin:", readResBin("binRes.bin"))
        print("Результат із textRes.txt:", readResTxt("textRes.txt"))

    except ValueError:
        print("Помилка: потрібно ввести числове значення.")
        sys.exit(1)
    except ZeroDivisionError as e:
        print("Помилка:", e)
        sys.exit(1)
    except FileNotFoundError as e:
        print(e)
        sys.exit(1)
