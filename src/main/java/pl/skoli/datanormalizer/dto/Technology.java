package pl.skoli.datanormalizer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Technology implements Serializable {

    private List<String> technologyList;

}
