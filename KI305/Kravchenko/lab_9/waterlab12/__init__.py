# -*- coding: utf-8 -*-
"""
Пакет waterlab12 — лабораторна робота №9 (варіант 12)

Містить:
- WaterBody: базовий клас для будь-якої водойми
- Sea: похідний клас, специфічний для морів
"""
from .waterbody import WaterBody
from .sea import Sea

__all__ = ["WaterBody", "Sea"]
