import HuffmanUtil.DictBuilderImpt;
import HuffmanUtil.HuffmanBinaryMsgBuilder;
import HuffmanUtil.HuffmanBinaryMsgBuilderImpt;
import HuffmanUtil.HuffmanBinaryMsgDecoder;

import java.util.Map;

public class HuffmanTransmissionStarter {
    public static void main(String[] args) {
        String content = "Hello_World";
        Map<Character, String> map = new DictBuilderImpt().loadContent(content).build();
        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        String code = new HuffmanBinaryMsgBuilderImpt().loadContent(content).loadDict(map).build();
        HuffmanBinaryMsgDecoder decoder = new HuffmanBinaryMsgDecoder(map, code);
        decoder.decode();
    }
}
