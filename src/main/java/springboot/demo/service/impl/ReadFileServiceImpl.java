package springboot.demo.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import springboot.demo.exeption.FileReaderException;
import springboot.demo.service.ReadFileService;

@Service
public class ReadFileServiceImpl implements ReadFileService {

    @Override
    public List<String> readFromFile(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new FileReaderException("Can't find file or can't read file from " + path, e);
        }
        return lines;
    }
}
