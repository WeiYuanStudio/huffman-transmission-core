package HuffmanUtil;

import java.util.Map;

public class HuffmanBinaryMsgBuilderImpt implements HuffmanBinaryMsgBuilder {
    private String content;
    private Map<Character, String> charDict;

    /**
     * 加载明文
     */
    @Override
    public HuffmanBinaryMsgBuilder loadContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public HuffmanBinaryMsgBuilder loadDict(Map<Character, String> charDict) {
        this.charDict = charDict;
        return this;
    }

    @Override
    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        content.chars().forEach(_char -> {
            System.out.println((char) _char);
            stringBuilder.append(charDict.get((char) _char));
        });
        String binaryStr = stringBuilder.toString(); //二进制字符串序列
        System.out.println(binaryStr);

        Byte _byte = (byte) Integer.parseInt("00011111", 2);
        System.out.println(Integer.parseInt("00011111", 2));
        System.out.println(_byte);

        byte b2 = (byte) _byte;
        String s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        System.out.println(s2);

        return binaryStr;
    }
}
