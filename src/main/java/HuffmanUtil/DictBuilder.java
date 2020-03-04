package HuffmanUtil;

import java.util.Map;

public interface DictBuilder {
    public DictBuilder loadContent(String content);
    public Map<Character, String> build();
}
