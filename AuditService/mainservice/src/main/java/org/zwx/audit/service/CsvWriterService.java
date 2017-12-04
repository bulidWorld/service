package org.zwx.audit.service;

import org.springframework.stereotype.Service;
import org.supercsv.io.CsvListWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Service
public class CsvWriterService {

    public void write2Csv(Path path, List<String> header, List<Map<String, Object>> rows) {
        try {
            CsvListWriter cw = new CsvListWriter(Files.newBufferedWriter(path), CsvPreference.STANDARD_PREFERENCE);
            String[] realHeader = header.toArray(new String[header.size()]);
            cw.writeHeader(realHeader);
            for (Map<String, Object> row : rows) {
                cw.write(row.values());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
