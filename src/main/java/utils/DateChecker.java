package utils;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateChecker {
    @Getter
    private final DateTimeFormatter DF;
    @Getter
    private LocalDate currentDate;

    public DateChecker(String dateSting) {
        this(dateSting, DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.ENGLISH));
    }

    public DateChecker(String dateSting, DateTimeFormatter DF) {
        this.DF = DF;
        setDate(dateSting);
    }

    public static boolean isWeekEndCheck(DayOfWeek day) {
        return day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY);
    }

    public void setDate(String localDate) {
        if (localDate == null) {
            currentDate = LocalDate.now();
        } else {
            try {
                System.out.println("Попытка установки даты: " + localDate);
                currentDate = LocalDate.parse(localDate, DF);
            } catch (DateTimeParseException e) {
                System.out.println("Ошибка установки даты. Повторите ввод.");
                while (currentDate == null) {
                    try {
                        System.out.print("Введите интересующую дату [ по умолчанию: " + LocalDate.now().format(DF) + " ]:");
                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        localDate = reader.readLine();
                        if (localDate.equals("")) currentDate = LocalDate.now();
                        else currentDate = LocalDate.parse(localDate, DF);
                    } catch (DateTimeParseException ex) {
                        System.out.println("Ошибка установки даты. Повторите ввод.");
                    } catch (IOException ex) {
                        System.out.println("Неудачное чтение ввода с клавиатуры. Дальнейшая работа программы невозможна. Извините. Передайте желаемую дату первым параметром при запуске программы, или запустите без параметров для установки сегодняшней даты.");
                        System.exit(1);
                    }
                }
            }
        }
        System.out.println("Установлена дата : " + currentDate.format(DF));
    }

    public LocalDate dateParser(String dateString) {
        try {
            return LocalDate.parse(dateString, getDF());
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isFuture(LocalDate date) {
        return date.isAfter(currentDate);
    }
}
