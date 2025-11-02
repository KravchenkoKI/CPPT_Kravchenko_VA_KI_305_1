# module: shaded_matrix.py
# Лабораторна робота №7
# Автор: Кравченко В.А., група КІ305
# Дата: 02.11.2025

import sys

"""Основний модуль лабораторної №7.
Формує квадратну матрицю та зубчастий список із заштрихованих елементів."""

def generate_shaded_matrix():
    """Генерує квадратну матрицю та зубчастий список для заштрихованих ділянок."""

    # --- Введення даних ---
    try:
        n = int(input("Введіть розмір квадратної матриці: "))
    except ValueError:
        print("❌ Помилка: потрібно ввести ціле число.")
        sys.exit(1)

    # --- Перевірка коректності розміру матриці ---
    if n <= 0:
        print("❌ Розмір матриці повинен бути більше нуля.")
        sys.exit(1)

    filler = input("Введіть символ-заповнювач: ")

    # --- Перевірка введення символу ---
    if len(filler) == 0:
        print("❌ Не введено символ-заповнювач.")
        sys.exit(1)
    elif len(filler) > 1:
        print("❌ Забагато символів-заповнювачів.")
        sys.exit(1)

    # --- Формування матриці ---
    matrix = []
    for i in range(n):
        row = []
        for j in range(n):
            # Заштриховані області: верхній лівий та нижній правий квадранти
            if (i < n // 2 and j < n // 2) or (i >= n // 2 and j >= n // 2):
                row.append(filler)
            else:
                row.append(".")  # позначення "порожніх" клітин
        matrix.append(row)

    # --- Виведення матриці ---
    print("\nСформована матриця:")
    for row in matrix:
        print(" ".join(row))

    # --- Створення зубчастого списку ---
    jagged_list = [
        [matrix[i][j] for j in range(n) if matrix[i][j] == filler]
        for i in range(n)
    ]

    # --- Виведення зубчастого списку ---
    print("\nЗубчастий список (заштриховані елементи):")
    for sublist in jagged_list:
        print(sublist)


# --- Точка входу ---
if __name__ == "__main__":
    generate_shaded_matrix()
