package 2bGroup.master;

import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;
import 2bGroup.master.db.Database;
import 2bGroup.master.network.NoCommentServer;
import 2bGroup.master.util.Config;
import 2bGroup.master.util.LoggingExecutor;
import 2bGroup.master.util.Telegram;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class 2bGroup {

    public static Executor executor = new LoggingExecutor(Executors.newFixedThreadPool(48), "main");
    public static final boolean DRY_RUN = false;

    public static void main(String[] args) throws Exception {
        Telegram.INSTANCE.startup();
        LoggingExecutor.wrap(Config::checkSafety).run();
        if (!DRY_RUN) {
            new HTTPServer(1234);
            DefaultExports.initialize();
            new Database();
            LoggingExecutor.wrap(2bGroupServer::listen).run();
            System.exit(1);
        }
    }
}
