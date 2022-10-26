package pl.skoli.datanormalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Technologies implements Serializable {

    private List<String> technologies;

}
