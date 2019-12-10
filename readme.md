Например:

INSTRUMENT1,12-Mar-2015,12.21

Задача:

Требуется прочитать котировки инструментов из предоставленного файла
 и рассчитать следующие метрики/индикаторы.

Вычислительный модуль должен рассчитать следующие метрики:

· Для INSTRUMENT1 – среднее значение цены

· Для INSTRUMENT2 – среднее значение за ноябрь 2014 года

· Для INSTRUMENT3 – любые другие статистические расчеты, которые мы
 можем просчитать на лету после прочтения файла, на ваше усмотрение

· Для любого, не перечисленного ранее, инструмента из входного файла
 – сумма 10 самых новых котировок с точки зрения даты

Что нужно сделать:

· Спроектировать решение, используя принципы ООП

· Протестировать/покрыть тестами ваше решение

· Предоставить только исходный код решения в zip архиве

Следует помнить:

· Входные данные не отсортированы.

· Мы можем взять за текущую дату 19-Dec-2014, котировки позже этой даты не ожидаются.

· Валидировать котировки по датам – это должен быть рабочий день понедельник – пятница.
 Котировки с выходными днями должны быть исключены из обработки.

· Решение должно работать для огромных файлов в десятки гигабайт.

· Важно, чтобы метрики рассчитывались как можно быстрее.

· Решение должно быть масштабируемым.