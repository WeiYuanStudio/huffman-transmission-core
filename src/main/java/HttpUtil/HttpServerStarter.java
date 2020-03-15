package HttpUtil;

import java.util.logging.Logger;

public class HttpServerStarter extends Thread {
    Logger logger = Logger.getLogger(HttpServerStarter.class.getName());
    //服务配置
    private static int SERVER_PORT = 8080; //默认端口
    private static final int SERVER_QUEUE = 0; //默认配置
    private static String SERVER_PATH = "/huffman"; //默认路径

    @Override
    public void run() {
        logger.info("Http server starting...");
        super.run();
    }
}
