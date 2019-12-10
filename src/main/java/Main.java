import Instruments.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.ENGLISH);
    private static LocalDate currentDate;
    private static ArrayList<Instrument> instruments = new ArrayList<>();

    public static void main(String[] args) {

        if (args.length > 0) {
            setDate(args[0]);
        } else {
            setDate(null);
        }

        long m = System.currentTimeMillis();

        instruments.add(new Instrument1("INSTRUMENT1"));
        instruments.add(new Instrument2("INSTRUMENT2", 2014, 11));
        instruments.add(new Instrument3("INSTRUMENT3"));
        instruments.add(new Instrument4("INSTRUMENT4"));


        String path = "Financial_instruments_input Инструменты.txt";

        for (int i = 0; i < 100; i++) {
            System.out.println("Iteration: " + i);

//            Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(Main::startProcessing);


            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(path), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    processing(line);
                }
            } catch (IOException e) {
                // log error
            }

            for (Instrument instrument : instruments) {
                System.out.println(instrument.toString());
            }

        }

        System.out.println((double) (System.currentTimeMillis() - m));
    }

    private static void processing(String str) {

        String[] a = str.split(",");
        LocalDate date = LocalDate.parse(a[1], DF);

        if (!currentDate.isAfter(date)) return;

        switch (a[0]) {
            case "INSTRUMENT1": {
                instruments.get(0).calculate(Double.parseDouble(a[2]), date);
                break;
            }
            case "INSTRUMENT2": {
                instruments.get(1).calculate(Double.parseDouble(a[2]), date);
                break;
            }
            case "INSTRUMENT3": {
                instruments.get(2).calculate(Double.parseDouble(a[2]), date);
                break;
            }
            default: {
                instruments.get(3).calculate(Double.parseDouble(a[2]), date);
            }
        }
    }

    private static void setDate(String localDate) {
        if (localDate == null) {

            currentDate = LocalDate.now();
        } else {

            try {

                System.out.println("Попытка установки даты: " + localDate);
                currentDate = LocalDate.parse(localDate, DF);
            } catch (Exception e) {
                System.out.println("Ошибка установки даты. Повторите ввод.");
                while (currentDate == null) {
                    try {
                        if (localDate == null) {
                            currentDate = LocalDate.now();
                        } else {
                            System.out.print("Введите интересующую дату [ по умолчанию: " + LocalDate.now().format(DF) + " ]:");
                            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                            localDate = reader.readLine();
                            if (localDate.equals("")) currentDate = LocalDate.now();
                            else currentDate = LocalDate.parse(localDate, DF);
                        }
                    } catch (Exception ex) {
                        System.out.println("Ошибка установки даты. Повторите ввод.");
                    }
                }
            }
        }
        System.out.println("Установлена дата : " + currentDate.format(DF));
    }
}
