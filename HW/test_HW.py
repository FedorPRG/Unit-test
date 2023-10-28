import pytest

from HW import *

class Test:

    def test_avg(self):
        hw = HW()
        assert hw.avg([1, 2, 3]) == 2

    def test_raise_item_is_not_number_avg(self):
        hw = HW()
        with pytest.raises(TypeError): hw.avg(['a', 2, 3])

    def test_raise_argument_is_not_list_avg(self):
        hw = HW()
        with pytest.raises(TypeError): hw.avg('a')

    @pytest.mark.parametrize("a, b, answer", [([1, 2, 3], [1, 2, 3], "Средние значения равны"),
                                              ([10, 2, 3], [1, 2, 3], "Первый список имеет большее среднее значение"),
                                              ([1, 2, 3], [10, 2, 3], "Второй список имеет большее среднее значение")])
    def test_program(self, a, b, answer):
        hw = HW()
        assert hw.program(a, b) == answer
