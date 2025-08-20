package hr.tvz.bilogrevic.zavrsniradbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DhmzData {

    private String temperature;
    private String humidity;
    private String weather;

}
