package nl.koetsier.irisserver;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class IrisService {

    private final List<Iris> irisData = new ArrayList<>();

    @Value("classpath:irisdata/iris.csv")
    private Resource resource;

    @PostConstruct
    private void init() throws IOException, CsvException {
        try (var reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            try (var csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(new CSVParserBuilder().withSeparator(',').build())
                    .build()) {
                var records = csvReader.readAll();
                for (var record : records) {
                    irisData.add(new Iris(
                            Float.parseFloat(record[0]),
                            Float.parseFloat(record[1]),
                            Float.parseFloat(record[2]),
                            Float.parseFloat(record[3]),
                            record[4]
                    ));
                }
            }
        }
    }

    public List<Iris> getIrisData() {
        return irisData;
    }
}
