package HuffmanUtil;

import java.util.Map;

public interface HuffmanBinaryMsgBuilder {
    public HuffmanBinaryMsgBuilder loadContent(String content);
    public HuffmanBinaryMsgBuilder loadDict(Map<Character, String> charDict);
    public String build();
}
