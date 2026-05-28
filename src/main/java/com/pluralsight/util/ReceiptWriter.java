package com.pluralsight.util;

import com.pluralsight.model.Order;
import com.pluralsight.model.ShopItem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class ReceiptWriter {
    private static DateTimeFormatter receiptDateTimeFormat= DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");

    private static String header = """
            ===================================================================
                                       BLOCKY BREWS
            ===================================================================
            """;
    private static String spacer =
            "\n===================================================================";

    public static void writeReceipt(Order userOrder){

        // Get current date time and set it as file name
        LocalDateTime orderTime = LocalDateTime.now();
        String fileName = "receipt/" + orderTime.format(receiptDateTimeFormat);

        try {

            BufferedWriter receiptWriter = new BufferedWriter(new FileWriter(fileName));

            // Write receipt header
            receiptWriter.write(header);

            // Convert Order / Shop Item list into a stream then convert each item into their respective toString
            // Collect into one string separated by a \n for each item
            String line = userOrder.getOrder().stream()
                    .map(ShopItem::toString)
                    .collect(Collectors.joining("\n"));

            // Write to receipt file
            receiptWriter.write(line);

            // Spacers with Order total inbetween
            receiptWriter.write(spacer);

            line = String.format("\nOrder Total: %43d Emerald(s)", userOrder.getTotal());
            receiptWriter.write(line);

            receiptWriter.write(spacer);

            receiptWriter.close();

        } catch(IOException e){
            System.out.println("Hrghh Hrghhhh (File not found)");
        }
    }
}
