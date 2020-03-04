import HuffmanUtil.DictBuilderImpt;

import java.util.Map;

public class HuffmanTransmissionStarter {
    public static void main(String[] args) {
        Map<Character, String> map = new DictBuilderImpt().loadContent("Hello_World_i_am_WeiYuan_w").build();
        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
