from new_tasks import *
from Person import *
import pytest
from unittest.mock import Mock


def test_avg():
    assert avg([1, 2, 3]) == 2.0


def test_raise_avg():
    with pytest.raises(TypeError): avg(['a', 'b', 'c'])


def test_transfer_sum():
    pers = Person()
    bank = Bank()

    pers.transfer_money(500, bank)

    assert pers.balance == 4500
    assert bank.balance == 5000500


def test_transfer_sum_mock():
    pers = Person()
    bank_mock = Mock()
    sum = 500

    pers.transfer_money(sum, bank_mock)
    bank_mock.recive.assert_called_with(sum)


def test_zero_division_error():
    with pytest.raises(ZeroDivisionError):
        div(5, 0)


@pytest.mark.parametrize("a, b, expected", [(10, 0, 0), (5, 2, 10)])  # Умножение на 0
def test_multy(a, b, expected):
    assert multy(a, b) == expected


def test_string_len():
    s = "test"
    assert length(s) == 4


def test_square():
    s = 2
    assert square(s) == 4


@pytest.mark.parametrize("value, result", [(2, True), (4, False), (824, False), (823, True), (67, True)])
def test_is_prime(value, result):
    assert is_prime(value) == result
