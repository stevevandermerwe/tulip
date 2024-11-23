///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.github.wfouche.tulip:tulip-runtime:0.1.0-SNAPSHOT
//SOURCES HttpUser.java

import io.github.wfouche.tulip.api.TulipApi;
import io.github.wfouche.tulip.api.TulipUserFactory;

void main() {
   TulipApi.runTulip("./benchmark_config.json", new TulipUserFactory());
}
