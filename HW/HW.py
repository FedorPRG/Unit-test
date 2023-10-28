
class HW:
    def avg(self, args):
        if not isinstance(args, list):
            raise TypeError
        sum = 0
        for i in args:
            sum += i
        return sum / len(args)
    def program(self, list1, list2):
        average1 = self.avg(list1)
        print(average1)
        average2 = self.avg(list2)
        print(average2)

        if average1 > average2:
            return "Первый список имеет большее среднее значение"
        elif average1 < average2:
            return "Второй список имеет большее среднее значение"
        else:
            return "Средние значения равны"

