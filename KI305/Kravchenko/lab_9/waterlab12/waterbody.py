# -*- coding: utf-8 -*-
"""
Модуль waterbody.py
Базовий клас: WaterBody (Водойма)

Цей модуль реалізує базову поведінку будь-якої водойми:
- зберігає назву, площу, середню глибину і тип води (прісна/солона)
- надає методи доступу (get/set)
- дозволяє обчислювати об'єм, перевіряти можливість купання та навігації
"""

class WaterBody:
    """Базовий клас для будь-якої водойми."""

    def __init__(self, name: str, area_km2: float, avg_depth_m: float, fresh: bool = True):
        """
        Ініціалізує водойму.

        Args:
            name (str): назва водойми
            area_km2 (float): площа в км²
            avg_depth_m (float): середня глибина в метрах
            fresh (bool): True якщо прісна, False якщо солона
        """
        self.__name = name
        self.__area_km2 = float(area_km2)
        self.__avg_depth_m = float(avg_depth_m)
        self.__fresh = bool(fresh)

    # ===== Методи доступу =====
    def get_name(self) -> str:
        """Повертає назву водойми."""
        return self.__name

    def set_name(self, name: str):
        """Встановлює нову назву водойми."""
        self.__name = name

    def get_area(self) -> float:
        """Повертає площу водойми в км²."""
        return self.__area_km2

    def set_area(self, area: float):
        """Встановлює площу водойми (якщо > 0)."""
        if area > 0:
            self.__area_km2 = area

    def get_avg_depth(self) -> float:
        """Повертає середню глибину водойми в метрах."""
        return self.__avg_depth_m

    def set_avg_depth(self, depth: float):
        """Встановлює середню глибину (якщо > 0)."""
        if depth > 0:
            self.__avg_depth_m = depth

    def is_fresh(self) -> bool:
        """Повертає True, якщо вода прісна."""
        return self.__fresh

    def set_fresh(self, fresh: bool):
        """Встановлює тип води (прісна/солона)."""
        self.__fresh = fresh

    # ===== Функціональні методи =====
    def volume_cubic_km(self) -> float:
        """Оцінює об'єм водойми в кубічних кілометрах."""
        return self.__area_km2 * self.__avg_depth_m * 0.001

    def is_suitable_for_swimming(self, min_depth_m: float = 0.5) -> bool:
        """
        Перевіряє, чи водойма придатна для купання.

        Args:
            min_depth_m (float): мінімальна допустима глибина для купання
        Returns:
            bool: True, якщо середня глибина >= min_depth_m
        """
        return self.__avg_depth_m >= min_depth_m

    def is_navigable(self, min_depth_m: float = 10.0) -> bool:
        """
        Перевіряє, чи водойма придатна для судноплавства.

        Args:
            min_depth_m (float): мінімальна глибина для навігації
        Returns:
            bool: True, якщо середня глибина >= min_depth_m
        """
        return self.__avg_depth_m >= min_depth_m

    def info(self) -> str:
        """
        Повертає рядок з повною інформацією про водойму.

        Returns:
            str: опис водойми
        """
        kind = "прісна" if self.__fresh else "солона"
        return (f"Водойма '{self.__name}': площа={self.__area_km2} км², "
                f"середня глибина={self.__avg_depth_m} м, тип={kind}, "
                f"об'єм≈{self.volume_cubic_km():.3f} км³")
