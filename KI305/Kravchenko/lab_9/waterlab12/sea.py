# -*- coding: utf-8 -*-
"""
Модуль sea.py
Похідний клас: Sea (Море)

Розширює WaterBody специфічними властивостями морів:
- солоність
- середня висота хвиль
- тип моря (open, semi-closed, enclosed)
- перевірка на навігацію
"""

from .waterbody import WaterBody

class Sea(WaterBody):
    """Клас Sea, похідний від WaterBody, з морськими параметрами."""

    def __init__(self, name: str, area_km2: float, avg_depth_m: float,
                 salinity_psu: float = 35.0, avg_wave_height_m: float = 1.0,
                 sea_type: str = "open"):
        """
        Ініціалізує море.

        Args:
            name (str): назва моря
            area_km2 (float): площа моря
            avg_depth_m (float): середня глибина
            salinity_psu (float): солоність (PSU)
            avg_wave_height_m (float): середня висота хвиль
            sea_type (str): тип моря (open/semienclosed/enclosed)
        """
        super().__init__(name, area_km2, avg_depth_m, fresh=False)
        self.__salinity_psu = float(salinity_psu)
        self.__avg_wave_height_m = float(avg_wave_height_m)
        self.__sea_type = sea_type

    # ===== Методи доступу =====
    def get_salinity(self) -> float:
        """Повертає солоність (PSU)."""
        return self.__salinity_psu

    def set_salinity(self, salinity: float):
        """Встановлює солоність (якщо > 0)."""
        if salinity > 0:
            self.__salinity_psu = salinity

    def get_wave_height(self) -> float:
        """Повертає середню висоту хвиль."""
        return self.__avg_wave_height_m

    def set_wave_height(self, height: float):
        """Встановлює середню висоту хвиль (>= 0)."""
        if height >= 0:
            self.__avg_wave_height_m = height

    def get_sea_type(self) -> str:
        """Повертає тип моря."""
        return self.__sea_type

    def set_sea_type(self, sea_type: str):
        """Встановлює тип моря."""
        self.__sea_type = sea_type

    # ===== Функціональні методи =====
    def is_navigable(self, min_depth_m: float = 5.0) -> bool:
        """
        Перевіряє, чи море придатне для навігації.

        Args:
            min_depth_m (float): мінімальна глибина
        Returns:
            bool: True, якщо середня глибина >= min_depth_m
        """
        return self.get_avg_depth() >= min_depth_m

    def wave_info(self) -> str:
        """Повертає інформацію про висоту хвиль."""
        return f"Середня висота хвиль: {self.__avg_wave_height_m} м"

    def info(self) -> str:
        """
        Повертає повну інформацію про море.

        Returns:
            str: опис моря
        """
        base_info = super().info()
        return (f"{base_info}; солоність={self.__salinity_psu} PSU; "
                f"тип моря={self.__sea_type}; {self.wave_info()}")
