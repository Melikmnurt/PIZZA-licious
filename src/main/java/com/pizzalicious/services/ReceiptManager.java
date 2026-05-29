package com.pizzalicious.services;

import com.pizzalicious.models.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Handles saving receipts
public class ReceiptManager {

    public boolean saveReceipt(Order order) {

        try {

            // Create receipts folder if it doesn't exist
            File receiptsFolder = new File("receipts");

            if (!receiptsFolder.exists()) {
                receiptsFolder.mkdir();
            }

            // Required assignment format:
            // yyyyMMdd-hhmmss.txt
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

            String fileName =
                    LocalDateTime.now().format(formatter) + ".txt";

            File receiptFile =
                    new File(receiptsFolder, fileName);

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(receiptFile)
                    );

            writer.write(order.toString());

            writer.close();

            System.out.println("Receipt saved: " + fileName);
            return true;

        } catch (IOException e) {

            System.out.println(
                    "Error saving receipt."
            );

            e.printStackTrace();
            return false;
        }
    }
}
