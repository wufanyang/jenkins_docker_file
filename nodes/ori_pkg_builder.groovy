import jenkins.model.*
import hudson.model.*
import hudson.slaves.*

Jenkins.instance.addNode(
  new DumbSlave(
    "ori-pkg-builder", // Name
    "build  components", // Description.
    "c:\\jenkins", // Remote root directory
    "1", // Number of executors
    Node.Mode.NORMAL , // "Usage" field, utilize this node as much as possible
    "ori-pkg-builder", // Labels
    new JNLPLauncher(), // Launch strategy, JNLP is the Java Web Start setting services use
    new RetentionStrategy.Always() // Is the "Availability" field
))

