package HuffmanUtil;

import java.util.HashMap;
import java.util.Map;

public class HuffmanBinaryMsgDecoder {
    private Map<Character, String> charDict; //K:字符，V:01哈夫曼字典
    private Map<String, Character> reverseCharDict; //K:01哈夫曼，V:字符 反转字典
    private String binaryContent; //String 格式哈夫曼01代码
    private StringBuilder messageContent;

    public HuffmanBinaryMsgDecoder(Map<Character, String> charDict, String binaryContent) {
        this.charDict = charDict;
        this.binaryContent = binaryContent;
        this.reverseCharDict = new HashMap<>();
        this.charDict.forEach((key, value) -> {
            this.reverseCharDict.put(value, key);
        });
        this.messageContent = new StringBuilder();
    }

    public String decode() {
        StringBuilder huffmanBuffer = new StringBuilder();
        binaryContent.chars().forEach(_char -> {
            huffmanBuffer.append((char) _char);
            if (reverseCharDict.get(huffmanBuffer.toString()) != null) {
                messageContent.append(reverseCharDict.get(huffmanBuffer.toString()));
                huffmanBuffer.delete(0, huffmanBuffer.length());
            }
            System.out.println(huffmanBuffer.toString());
            System.out.println(reverseCharDict.get(huffmanBuffer.toString()));
        });
        System.out.println(messageContent);
        return null;
    }
}
