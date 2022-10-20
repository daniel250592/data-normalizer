package pl.skoli.datanormalizer.dto.interfaces;

import java.util.List;

public interface ScraperService<T> {

    List<T> fetchData();
}
