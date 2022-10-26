package pl.skoli.datanormalizer.interfaces;

import java.util.List;

public interface ScraperService<T> {

    List<T> fetchData();
}
