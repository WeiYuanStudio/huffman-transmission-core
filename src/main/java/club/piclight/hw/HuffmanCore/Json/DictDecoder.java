package club.piclight.hw.HuffmanCore.Json;

import com.google.gson.Gson;

public class DictDecoder {
    private String jsonText;
    private DictModel model;

    public DictDecoder(String jsonText) {
        this.jsonText = jsonText;
    }

    public DictModel decode() {
        Gson gson = new Gson();
        this.model = gson.fromJson(jsonText, DictModel.class);
        return this.model;
    }
}
