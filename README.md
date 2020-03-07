# Huffman Trasmission Core

哈夫曼编码实现P2P模式通讯

这是实现通讯的后端部分

## API V1.0

头部4bit代表协议版本v1，后4bit代表传送数据类型,再后24bit(6位SHA-1 hash)为消息源码Hash

### 传送字典

通过该格式，传送哈夫曼字典

第二字段0001表明该消息为字典数据

```text
0001|0001|24bit hash|huffman dict json String java to byte
```

### 传送消息

通过该格式，传送消息

第二字段0002表明该消息为哈夫曼编码后的消息数据

```text
|0001|0002|24bit hash|16bit length|huffman binary data
```