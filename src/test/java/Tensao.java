import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Tensao {

    _110v("110v"), _220v("220v");

    private final String value;

    Tensao(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Tensao forValue(String value) {
        return Arrays.stream(Tensao.values())
                .filter(tensao -> tensao.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Valor inválido: " + value));
    }

}
