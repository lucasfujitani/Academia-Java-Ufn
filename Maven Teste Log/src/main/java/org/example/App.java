package org.example;

import org.apache.commons.math3.util.Precision;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        double number = 3.14159265359;
        int decimalPlaces = 2;
        double rounded = Precision.round(number, decimalPlaces);

        // Log do número arredondado
        logger.info("Número arredondado: {}", rounded);

        // Mensagem de depuração
        logger.debug("Este é um exemplo de mensagem de depuração.");

        // Escrever em um arquivo de texto com data e hora
        writeToFile("output.txt", "Número arredondado: " + rounded);

        // Mensagem de erro simulada
        try {
            int result = 10 / 0; // Simula uma exceção
        } catch (Exception e) {
            logger.error("Ocorreu um erro:", e);
        }
    }

    private static void writeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            // Adiciona a data e hora ao conteúdo
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
            String logEntry = "[" + timestamp + "] " + content + "\n";

            writer.write(logEntry);
            logger.info("Conteúdo gravado em '{}'", fileName);
        } catch (IOException e) {
            logger.error("Erro ao escrever no arquivo '{}': {}", fileName, e.getMessage());
        }
    }
}
