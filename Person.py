
class Person:
    def __init__(self):
        self.balance=5000

    def transfer_money(self, sum,bank):
        self.balance-=sum
        bank.recive(sum)

class Bank:
    def __init__(self):
        self.balance = 5000000

    def recive(self, sum):
        self.balance+=sum