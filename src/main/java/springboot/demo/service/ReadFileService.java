package springboot.demo.service;

import java.util.List;

public interface ReadFileService {
    List<String> readFromFile(String path);
}
