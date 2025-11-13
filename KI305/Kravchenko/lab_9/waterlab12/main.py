# -*- coding: utf-8 -*-
"""
Цей модуль показує:
- створення об'єктів WaterBody та Sea
- використання методів info(), is_suitable_for_swimming(), is_navigable()
- демонстрацію поліморфізму
"""

from .waterbody import WaterBody
from .sea import Sea

def demo():
    """Демонстраційна функція запуску програми."""
    # Приклад базового класу
    lake = WaterBody(name="Озеро Світязь", area_km2=26.0, avg_depth_m=8.6, fresh=True)
    print(lake.info())
    print("Підходить для купання?", lake.is_suitable_for_swimming())
    print("Підходить для навігації?", lake.is_navigable())
    print()

    # Приклад похідного класу
    black_sea = Sea(name="Чорне море", area_km2=436400.0, avg_depth_m=1253.0,
                    salinity_psu=18.0, avg_wave_height_m=1.2, sea_type="напівзамкнуте")
    print(black_sea.info())
    print("Підходить для навігації?", black_sea.is_navigable())
    print("Підходить для купання?", black_sea.is_suitable_for_swimming(min_depth_m=1.0))

if __name__ == "__main__":
    demo()
